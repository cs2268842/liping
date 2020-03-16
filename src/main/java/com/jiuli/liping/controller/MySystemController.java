package com.jiuli.liping.controller;

import com.jiuli.liping.vo.MySystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jiuli.liping.service.MySystemService;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/mySystem")
public class MySystemController {
    @Autowired
    private MySystemService mySystemService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<MySystem> mySystems = mySystemService.findAllList();
        return mySystems;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        MySystem mySystem = mySystemService.get(id);
        return mySystem;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody MySystem mySystem) {
        if (mySystemService.insert(mySystem) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<MySystem> mySystems) {
        if (mySystemService.insertBatch(mySystems) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody MySystem mySystem) {
        if (mySystemService.update(mySystem) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody MySystem mySystem) {
        if (mySystemService.delete(mySystem) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = {"/getProductList"}, method = RequestMethod.POST)
    public Object getProductList() {
        List<MySystem> mySystemList = mySystemService.getProductList();
        return mySystemList;
    }
}
