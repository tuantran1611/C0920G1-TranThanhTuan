package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductImpl implements ProductService {

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 12", "32000000", "Made in VietNam", "Apple"));
        products.put(2, new Product(2, "Samsung Galaxy Note 11", "29000000", "Made in Viet Nam", "Samsung"));
        products.put(3, new Product(3, "Xiaomi S10", "12000000", "Made in China", "China"));
        products.put(4, new Product(4, "Sony S20", "22000000", "Made in Japan", "Sony"));
        products.put(5, new Product(5, "Oppo X12", "18000000", "Made in China", "Oppo"));
        products.put(6, new Product(6, "Viettel S100", "120000000", "Made in VietNam", "Viettel"));
        products.put(7, new Product(7, "BKAV S15", "19000000", "Made in VietNam", "BKAV"));
        products.put(8, new Product(8, "Vsmart S5", "14000000", "Made in VietNam", "VinSmart"));
        products.put(9, new Product(9, "Iphone 15", "150000000", "Made in VietNam", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
}
