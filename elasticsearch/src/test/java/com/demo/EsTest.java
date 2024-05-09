package com.demo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import com.common.domain.FileInfo;
import com.demo.utils.SimpleLatch;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
public class EsTest {

    @Autowired
    private ElasticsearchClient esClient;

    private static final ExecutorService executorService = Executors.newFixedThreadPool(8);
    private static final List<FileInfo> fileInfoList = new ArrayList<>();


//    @Test
    void syncData() throws IOException, InterruptedException {
        File file = new File("d://allDate.txt");
        BufferedReader br = Files.newBufferedReader(file.toPath());
        String s;
        while ((s = br.readLine()) != null) {
            JsonMapper jsonMapper = new JsonMapper();
            FileInfo fileInfo = jsonMapper.readValue(s, FileInfo.class);
            fileInfoList.add(fileInfo);
        }
        int count = (int) Math.ceil(fileInfoList.size() / 1000.0);
        SimpleLatch simpleLatch = new SimpleLatch(count);
        for (int i = 0; i < count; i++) {
            int finalI = i;
            executorService.submit(() -> {
                BulkRequest.Builder bulkRequest = new BulkRequest.Builder();
                List<FileInfo> list = fileInfoList.stream().skip(finalI * 1000L).limit(1000).toList();
                for (FileInfo fileInfo : list) {
                    bulkRequest.operations(op -> op.index(idx -> idx.index("file").id(fileInfo.getId().toString()).document(fileInfo)));
                }
                try {
                    esClient.bulk(bulkRequest.build());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    simpleLatch.countDown();
                }
            });
        }
        simpleLatch.await();
        br.close();
    }

}
