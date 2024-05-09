package com.demo.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig {

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        return new ElasticsearchClient(new RestClientTransport(RestClient.builder(HttpHost.create("http://127.0.0.1:9200")).build(), new JacksonJsonpMapper()));
    }

}
