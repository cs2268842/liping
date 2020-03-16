package com.jiuli.liping.service.impl;

import com.jiuli.liping.dao.PictureDao;
import com.jiuli.liping.service.FileManageService;
import com.jiuli.liping.vo.Picture;
import com.jiuli.liping.vo.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Service
public class FileManageServiceImpl implements FileManageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileManageService.class);

    @Value("${file_hostpath}")
    private String fileHostPath;

    @Autowired
    private PictureDao pictureDao;

    @Override
    public String upload(MultipartFile file){
        //防止文件名冲突
        String str = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
        String picture=file.getOriginalFilename();
        String[] s=picture.split("\\.");
        str=str+"."+s[1];
        System.out.println(str);

        File test = new File(fileHostPath+str);
        if (!test.exists()){
            test.mkdirs();
        }
        try {
            file.transferTo(test);
        }catch (IOException e){
            LOGGER.error(file.getOriginalFilename()+"文件上传失败", e);
        }
        return test+"";
    }

    @Override
    public String download(String fileName, HttpServletResponse response) {
        File file = new File(fileHostPath + fileName);
        if (!file.exists()){
            return "文件不存在";
        }
        byte[] bytes = new byte[1000];
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
            response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            outputStream = response.getOutputStream();
            int length;
            while ((length = bufferedInputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, length);
            }
            outputStream.flush();
        }catch (Exception e){
            LOGGER.error("文件下载失败", e);
        }finally {
            try {
                if (bufferedInputStream != null){
                    bufferedInputStream.close();
                }

                if (outputStream != null){
                    outputStream.close();
                }

                if (fileInputStream != null){
                    fileInputStream.close();
                }
            }catch (IOException e){
                LOGGER.error(e.getMessage(), e);
            }
        }
        return "success";
    }

    //file要与表单上传的名字相同
    @Override
    public ArrayList<Picture> uploadFiles(Product product) {
        //生成一个文件夹
        String dir = fileHostPath+"/chushihua.text";
        File fileDir = new File(dir);
        if(!fileDir.exists()) {
            fileDir.mkdirs();
        }

        //批量上传
        //生成文件在服务器端存放的名字
        ArrayList<Picture> pictureList = new ArrayList<>();
        for(int i=0;i<product.getFiles().length;i++) {
            String fileSuffix = product.getFiles()[i].getOriginalFilename().substring(product.getFiles()[i].getOriginalFilename().lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + fileSuffix;
            File file = new File(fileHostPath+"/"+fileName);
            //上传
            try {
                product.getFiles()[i].transferTo(file);
                Picture pi = new Picture();
                pi.setPictureUrl(file+"");
                pi.setFlag(1);
                pi.setProductId(product.getProductId());
                pictureDao.insert(pi);
                pictureList.add(pi);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pictureList;
    }
}
