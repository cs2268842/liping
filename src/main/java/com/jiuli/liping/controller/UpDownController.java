package com.jiuli.liping.controller;

import com.jiuli.liping.service.FileManageService;
import com.jiuli.liping.vo.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author zyl
 * Date  2019-12-05
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/upDown")
public class UpDownController {
    @Autowired
    private FileManageService fileManageService;

    @PostMapping("/upload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file){
        if (Objects.isNull(file)){
            return "文件上传失败，请重新选择文件";
        }
        return fileManageService.upload(file);
    }

    @GetMapping("/download")
    @ResponseBody
    public String fileDownload(@RequestParam("fileName") String fileName, HttpServletResponse response){
        if (Objects.isNull(fileName)){
            return "文件下载失败，请选择文件要下载的文件";
        }
        return fileManageService.download(fileName, response);
    }

    /*@PostMapping("/uploadFiles")
    @ResponseBody
    public Object uploadFiles(@RequestParam("files") MultipartFile[] files){
        if (Objects.isNull(files)){
            return "文件上传失败，请重新选择文件";
        }
        return fileManageService.uploadFiles(files);
    }*/
}
