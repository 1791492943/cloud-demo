package com.demo.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.common.domain.FileInfo;
import com.dubbo.ElasticSearchService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@DubboService
public class ElasticSearchServiceImpl implements ElasticSearchService {

    @Autowired
    private ElasticsearchClient esClient;

    @Override
    public List<FileInfo> search(String name) throws IOException {
        SearchResponse<FileInfo> res = esClient.search(search -> search.index("file").query(query -> query.match(match -> match.field("name").query(name))), FileInfo.class);
        return res.hits().hits().stream().map(Hit::source).toList();
    }
}
