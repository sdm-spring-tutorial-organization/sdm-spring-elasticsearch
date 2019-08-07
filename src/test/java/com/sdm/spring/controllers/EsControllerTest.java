package com.sdm.spring.controllers;

import com.sdm.spring.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EsControllerTest {

    @Autowired
    EsController esController;

    @Test
    public void esTestPost() throws Exception {
        String resultOfPost = esController.esTestPost();
        System.out.println(resultOfPost);
        /*assertEquals(1, 1);*/
    }

}