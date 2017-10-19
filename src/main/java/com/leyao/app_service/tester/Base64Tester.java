package com.leyao.app_service.tester;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Tester {
    public static void main(String[] args) {
        String imagePath = "C:\\Users\\qjiang\\Pictures\\1.jpg";
        String imageDestPath = "C:\\Users\\qjiang\\Pictures\\dest.jpg";

        String imageBaseString = getImageStr(imagePath);
        boolean result = generateImage(imageBaseString,imageDestPath);
        System.out.println("result=" + result);
    }

    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    public static boolean generateImage(String imgStr, String path) {
        if (imgStr == null) {
            return false;
        }

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(imgStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            
            File file=new File(path);
            file.createNewFile();
            
            OutputStream out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}