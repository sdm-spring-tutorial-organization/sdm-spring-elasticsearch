package com.sdm.spring.controllers;

import com.sdm.spring.config.EsConfig;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping(value = "es")
public class EsController {

    @Autowired
    EsConfig esConfig;

    @Autowired
    Client client;

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Autowired
    SearchSourceBuilder searchSourceBuilder;

    private static final Scroll scroll = new Scroll(TimeValue.timeValueSeconds(10L));

    // TEST
    @RequestMapping(value = "/test")
    public String esTestPost() throws Exception {
        SearchRequest searchRequest = new SearchRequest(EsConfig.esIndex);
        searchRequest.scroll(scroll);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        return searchResponse.toString();
    }

}
