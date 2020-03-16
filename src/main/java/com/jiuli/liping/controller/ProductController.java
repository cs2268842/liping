package com.jiuli.liping.controller;

import com.jiuli.liping.vo.Message;
import com.jiuli.liping.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jiuli.liping.service.ProductService;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<Product> products = productService.findAllList();
        return products;
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        Product product = productService.get(id);
        return product;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody Product product) {
        if (productService.insert(product) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<Product> products) {
        if (productService.insertBatch(products) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody Product product) {
        if (productService.update(product) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody Product product) {
        if (productService.delete(product) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    public Message insertProduct(Product product) {
        Message mess = productService.insertProduct(product);
        return mess;
    }
}
