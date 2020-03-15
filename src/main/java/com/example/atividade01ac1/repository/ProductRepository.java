package com.example.atividade01ac1.repository;

import java.util.HashMap;

import com.example.atividade01ac1.model.Product;

import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 */
@Repository
public class ProductRepository {
    public HashMap<Integer,Product> repository= new HashMap<Integer,Product>();

    public ProductRepository()
    {
        repository.put(1, new Product(1, "Call of Duty", 200, 100));
        repository.put(2, new Product(2, "Battlefield", 250, 40));
        repository.put(3, new Product(3, "Shadow of the Colossus", 150, 10));
        repository.put(4, new Product(4, "Zelda BOTW", 300, 120));
        repository.put(5, new Product(5, "Mario Kart", 250, 200));
        repository.put(6, new Product(6, "Pokemon Sword", 200, 1000));
        repository.put(7, new Product(7, "Pokemon Shield", 200, 1000));
        repository.put(8, new Product(8, "Lost Planet 3", 80, 70));
        repository.put(9, new Product(9, "Forza Horizon", 50, 90));
        repository.put(10, new Product(10, "Undertale", 18, 100000));

    }
    public Product getProductByID(int id)
    {
        return repository.get(id);
    }
    public HashMap<Integer,Product> getProducts()
    {
        return repository;
    }
}