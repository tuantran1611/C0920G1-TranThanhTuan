package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Iphone 7", 12000000.0,"/img/abc.jpg",20));
        productList.add(new Product(2,"Iphone 8", 15000000.0,"/img/abc.jpg",10));
        productList.add(new Product(3,"Iphone X", 19000000.0,"/img/abc.jpg",40));
        productList.add(new Product(4,"Iphone 11", 25000000.0,"/img/abc.jpg",15));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        int index = productList.indexOf(product);
        if(index != -1){
            productList.set(index, product);
        }else {
            productList.add(product);
        }
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }
}
