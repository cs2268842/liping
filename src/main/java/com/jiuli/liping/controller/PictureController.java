package com.jiuli.liping.controller;

import com.jiuli.liping.vo.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.jiuli.liping.service.PictureService;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
@Component
@RestController
@RequestMapping(value = "/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<Picture> pictures = pictureService.findAllList();
        return pictures;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        Picture picture = pictureService.get(id);
        return picture;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody Picture picture) {
        if (pictureService.insert(picture) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<Picture> pictures) {
        if (pictureService.insertBatch(pictures) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody Picture picture) {
        if (pictureService.update(picture) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody Picture picture) {
        if (pictureService.delete(picture) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
