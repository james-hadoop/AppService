package com.leyao.app_service.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class MultipartFileUploadTest {
    public static void main(String[] args) throws ClientProtocolException, IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost uploadFile = new HttpPost("http://localhost:8088/v1/service/user/upload");
//        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addTextBody("username", "james", ContentType.TEXT_PLAIN);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost("http://localhost:8088/v1/service/user/uploadPortrait");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("hUserPhoneNr", "13333333334", ContentType.TEXT_PLAIN);

        // This attaches the file to the POST:
        File f = new File("C:\\Users\\qjiang\\Pictures\\1.jpg");
        builder.addBinaryBody("file", new FileInputStream(f), ContentType.APPLICATION_OCTET_STREAM, f.getName());

        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse response = httpClient.execute(uploadFile);
        HttpEntity responseEntity = response.getEntity();
        System.out.println(responseEntity);
    }
}
