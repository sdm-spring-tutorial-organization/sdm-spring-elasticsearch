package com.sdm.spring.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Configuration
public class EsConfig {

    @Value("${elasticsearch.cluster-name}")
    private String clusterName;

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private String port;

    @Bean
    public Client client() throws Exception {
        Settings settings = Settings.builder().put("cluster.name", clusterName).build();

        // * Elastic search 6.0 has removed InetSocketTransportAddress class
        // return new PreBuiltTransportClient(settings)
        //         .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));

        return new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(host), Integer.valueOf(port)));
    }
}
