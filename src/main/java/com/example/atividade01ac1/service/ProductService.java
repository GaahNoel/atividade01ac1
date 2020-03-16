package com.example.atividade01ac1.service;

import java.util.HashMap;
import java.util.TreeMap;

import com.example.atividade01ac1.model.Product;
import com.example.atividade01ac1.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * ProductService
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    
    public Product getProduto(int id)
    {
        Product product = repository.getProductByID(id);
        return product;

    }
    public TreeMap<Integer,Product> getProductsInStock()
    {
        HashMap<Integer,Product> products = repository.getProducts();
        TreeMap<Integer,Product> productsStock = new TreeMap<>();
        for(Product p:products.values())
        {
            if(p.getStock() >0)
                productsStock.put(p.getId(), p);
        }
        return productsStock;
    }
    public HashMap<Integer,Product> getProductsGreaterValue(double value)
    {
        HashMap<Integer,Product> products = repository.getProducts();
        HashMap<Integer,Product> productsGreaterValue = new HashMap<>();
        for(Product p:products.values())
        {
            if(p.getCost() >value)
                productsGreaterValue.put(p.getId(), p);
        }
        return productsGreaterValue;
    }
    public HashMap<Integer,Product> getProductsLessValue(double value)
    {
        HashMap<Integer,Product> products = repository.getProducts();
        HashMap<Integer,Product> productsLessValue = new HashMap<>();
        for(Product p:products.values())
        {
            if(p.getCost() <value)
                productsLessValue.put(p.getId(), p);
                
        }
        return productsLessValue;
        
    } 

}