package com.sdm.spring.config;

import com.sdm.spring.utils.WebUtil;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@Configuration
public class EsConfig {

    @Value("${elasticsearch.cluster-name}")
    private String clusterName;

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private String port;

    // traha
    //    static final  String esIp = "rest-traha.na.nexon.com";
    //    static final  String esIndex = "430008885-*";

    // new-dev
    public static final String esIp = "rest-jp-dev.na.nexon.com";
    public static final String esIndex = "1050765879-*";

    public static final String esPort = "80";

    private static final String esUsername = "got-user";
    private static final String esPassword = "got-user";

    @Bean
    public Client client() throws Exception {
        Settings settings = Settings
                .builder()
                .put("cluster.name", clusterName)
                .build();

        return new PreBuiltTransportClient(settings)
                .addTransportAddress(
                        new TransportAddress(InetAddress.getByName(host), Integer.valueOf(port)));

        // * Elastic search 6.0 has removed InetSocketTransportAddress class
        // return new PreBuiltTransportClient(settings)
        //         .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));

    }

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        /*HttpHost httpHost = new HttpHost(esIp, Integer.parseInt(esPort), "https");*/
        HttpHost httpHost = new HttpHost(esIp, 443, "https");
        /*System.out.println(httpHost.toString());*/ // https://rest-jp-dev.na.nexon.com:80
        RestClientBuilder builder = RestClient
                // default schema : "http"
                .builder(httpHost)
                .setDefaultHeaders(WebUtil.getAuthHeader(esUsername, esPassword));
        return new RestHighLevelClient(builder);
    }

    @Bean
    public static SearchSourceBuilder searchSourceBuilder() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        /*searchSourceBuilder.query(queryBuilder);*/
        searchSourceBuilder.sort("createdate", SortOrder.DESC);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS)); // 60초 time-out
        searchSourceBuilder.size(30000); // 한번에 최대 30,000 조회
        return searchSourceBuilder;
    }

}
