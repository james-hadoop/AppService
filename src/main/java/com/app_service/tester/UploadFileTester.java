package com.app_service.tester;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.app_service.common.GlobalConstant;
import com.app_service.entity.ProfileFile;
import com.app_service.util.FileUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UploadFileTester {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws ClientProtocolException, IOException {
        // uploadPortrait();
        uploadProfile();
    }

    private static void uploadPortrait() throws ClientProtocolException, IOException {
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

    private static void uploadProfile() throws ClientProtocolException, IOException {
        String imagePath = "C:\\Users\\qjiang\\Pictures\\2.jpg";
        String imageBase64String = FileUtil.imageToBase64(imagePath);

        ProfileFile profileFile = new ProfileFile();
        profileFile.setFileName(imagePath);
        profileFile.sethUserPhoneNr(13333333331l);
        profileFile.setSessionCode(GlobalConstant.DEFAULT_SESSION_CODE);
        profileFile.setBase64(imageBase64String);

        String postContent = mapper.writeValueAsString(profileFile);
        System.out.println("postContent:\n\t" + postContent);
        HttpEntity entity = new StringEntity(postContent, "UTF-8");

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://47.94.94.196:8088/v1/service/user/uploadProfile");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setEntity(entity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();
        System.out.println(responseEntity);
    }
}
