package com.sdm.spring.repository;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EsRepository {

    private Client client;

    @Autowired
    public EsRepository(Client client) {
        this.client = client;
    }

}
