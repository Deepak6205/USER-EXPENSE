package com.Geekster.User.Expense.Tracker.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.Geekster.User.Expense.Tracker.Entity.Product;
import com.Geekster.User.Expense.Tracker.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    // Coded by: Amit Ashok Swain
    // GitHub - amitashokswain
    // E-mail - business.amitswain@gmail.com
    // Instagram - _sanatani_hindutwa_
    @PostMapping("product")
    public String addAProduct(@RequestBody Product product)
    {
        return  productService.addAProduct(product);
    }

    @PostMapping("products")
    public String addListOfProducts(@RequestBody List<Product> products) {return productService.addListOfProducts(products);}

    @GetMapping("products")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }
}
