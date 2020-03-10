package com.example.atividade01ac1.service;

import java.util.HashMap;

import com.example.atividade01ac1.model.Product;
import com.example.atividade01ac1.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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
    public HashMap<Integer,Product> getProductsInStock()
    {
        HashMap<Integer,Product> products = repository.getProducts();
        HashMap<Integer,Product> productsStock = new HashMap<>();
        for(Product p:products.values())
        {
            if(p.getEstoque() >0)
                productsStock.put(p.getCodigo(), p);
        }
        return productsStock;
    }
    public HashMap<Integer,Product> getProductsGreater20()
    {
        HashMap<Integer,Product> products = repository.getProducts();
        HashMap<Integer,Product> productsGreater20 = new HashMap<>();
        for(Product p:products.values())
        {
            if(p.getValor() >20)
                productsGreater20.put(p.getCodigo(), p);
        }
        return productsGreater20;
    }
    public HashMap<Integer,Product> getProductsLess20()
    {
        HashMap<Integer,Product> products = repository.getProducts();
        HashMap<Integer,Product> productsLess20 = new HashMap<>();
        for(Product p:products.values())
        {
            if(p.getValor() <20)
                productsLess20.put(p.getCodigo(), p);
        }
        return productsLess20;
    } 

}