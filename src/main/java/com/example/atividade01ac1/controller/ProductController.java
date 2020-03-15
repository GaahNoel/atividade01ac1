package com.example.atividade01ac1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.example.atividade01ac1.model.Product;
import com.example.atividade01ac1.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    @GetMapping("/greater20")
    public ModelAndView greater20()
    {
        ModelAndView mv = new ModelAndView("ProductsGreater20");
        HashMap<Integer,Product> hm = ps.getProductsGreater20();
        mv.addObject("products", hm.values());
        return mv;
    }
    @GetMapping("/less20")
    public ModelAndView less20()
    {
        ModelAndView mv = new ModelAndView("ProductsLess20");
        HashMap<Integer,Product> hm = ps.getProductsLess20();
        mv.addObject("products", hm.values());
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