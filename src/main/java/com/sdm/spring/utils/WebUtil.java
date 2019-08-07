package com.sdm.spring.utils;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.Base64;

public class WebUtil {

    /**
     * get Authorization Header ( Base64 )
     *
     * @link https://stackoverflow.com/questions/54285703/java-using-https-to-connect-elasticsearch-cluster
     * */
    public static Header[] getAuthHeader(String esUsername, String esPassword) {
        String auth = esUsername + ":" + esPassword;
        String basicAuth  = "Basic "+ Base64.getEncoder().encodeToString(auth.getBytes());
        return new Header[] {
                new BasicHeader("Authorization", basicAuth)
        };
    }

}
