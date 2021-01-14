package com.jk.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("oss")
public class OssController {

    @RequestMapping("upload")
    public Map upload(MultipartFile shopLogoImg) throws IOException {
        HashMap<String, Object> result = new HashMap<>();
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI4G5c5PCTRLWJ9oyy7GtX";
        String accessKeySecret = "qq3d7c2Rdmo11no79CwBjmvuoccLVl";
        String backetName = "education-tm";
        
        String filename = shopLogoImg.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        filename = uuid + filename;
        InputStream inputStream = shopLogoImg.getInputStream();

        // 创建OSSClient实例。
        OSS ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);
        ossClient.putObject(backetName,filename,inputStream);
        ossClient.shutdown();
        String path = "https://" + backetName + "." + endpoint + "/" + filename;
        result.put("img",path);
        return result;
    }
}
