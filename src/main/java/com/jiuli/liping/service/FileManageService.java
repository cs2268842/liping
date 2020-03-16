package com.jiuli.liping.service;

import com.jiuli.liping.vo.Picture;
import com.jiuli.liping.vo.Product;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public interface FileManageService {
    String upload(MultipartFile file);

    ArrayList<Picture> uploadFiles(Product product);

    String download(String fileName, HttpServletResponse response);
}
