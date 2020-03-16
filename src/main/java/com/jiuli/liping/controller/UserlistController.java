package com.jiuli.liping.controller;

import com.jiuli.liping.vo.Userlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jiuli.liping.service.UserlistService;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-13
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/userlist")
public class UserlistController {
    @Autowired
    private UserlistService userlistService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<Userlist> userlists = userlistService.findAllList();
        return userlists;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        Userlist userlist = userlistService.get(id);
        return userlist;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody Userlist userlist) {
        if (userlistService.insert(userlist) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<Userlist> userlists) {
        if (userlistService.insertBatch(userlists) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody Userlist userlist) {
        if (userlistService.update(userlist) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody Userlist userlist) {
        if (userlistService.delete(userlist) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
