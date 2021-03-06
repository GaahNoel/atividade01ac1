package com.example.atividade01ac1.controller;

import java.util.HashMap;

import java.util.TreeMap;

import com.example.atividade01ac1.model.Product;
import com.example.atividade01ac1.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ProductController
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService ps;
    
    @GetMapping("/{id}")
    public ModelAndView productByID(@PathVariable("id") int id)
    {
        ModelAndView mv = new ModelAndView("ProductIDView");
        Product product = ps.getProduto(id);
        mv.addObject("product", product);
        
        return mv;
    }
    @GetMapping("/greatervalue/{value}")
    public ModelAndView greaterValue(@PathVariable("value")double value)
    {
        ModelAndView mv = new ModelAndView("ProductsGreaterValue");
        HashMap<Integer,Product> hm = ps.getProductsGreaterValue(value);
        mv.addObject("products", hm.values());
        mv.addObject("value", value);
        return mv;
    }
    @GetMapping("/lessvalue/{value}")
    public ModelAndView lessValue(@PathVariable("value")double value)
    {
        ModelAndView mv = new ModelAndView("ProductsLessValue");
        HashMap<Integer,Product> hm = ps.getProductsLessValue(value);
        mv.addObject("products", hm.values());
        mv.addObject("value", value);
        return mv;
    }
    @GetMapping("/instock")
    public ModelAndView inStock()
    {
        ModelAndView mv = new ModelAndView("ProductsInStock");
        TreeMap<Integer,Product> hm = ps.getProductsInStock();
        mv.addObject("products", hm.values());
        return mv;
    }
}