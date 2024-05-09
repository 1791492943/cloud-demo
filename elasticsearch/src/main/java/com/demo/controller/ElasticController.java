package com.demo.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.common.domain.FileInfo;
import com.dubbo.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/es")
public class ElasticController {

    @Autowired
    private ElasticsearchClient esClient;

    @Autowired
    private ElasticSearchService elasticSearchService;

    @GetMapping("/search/{name}")
    public List<FileInfo> search(@PathVariable String name) throws IOException {
        return elasticSearchService.search(name);
    }


}
