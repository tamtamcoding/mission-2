package com.mission.mission2.Controller;


import com.mission.mission2.Entity.Product;
import com.mission.mission2.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    @DeleteMapping(value = "/delete/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value ="productId", required = true) String productId){
        productService.deleteProduct(Integer.parseInt(productId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Product>>getAllProduct(){
        List<Product> allProducts = productService.getAllProduct();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
    @GetMapping(value = "/getOne")
    public ResponseEntity<Product> getOneProduct(@RequestParam("productId") String productId){
        Product product = productService.getProduct(Integer.parseInt(productId));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping(value = "/saveOrUpdate")
    public ResponseEntity<Void> saveOrUpdateProduct(@RequestBody Product product){
        productService.saveOrUpdateProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
