package com.mission.mission2.Service;


import com.mission.mission2.Dao.ProductDao;
import com.mission.mission2.Entity.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductDao productDao;
    public void saveOrUpdateProduct(Product product){
        log.info("inserting product object");
        productDao.save(product);
    }
    public List<Product> getAllProduct(){
        log.info("getting all product");
        return productDao.findAll();
    }
    public Product getProduct(int productId){
        log.info("getting specific product by id-{}", productId);
    return productDao.findById(productId).orElse(null);
    }
    public void deleteProduct(Product product){
        log.info("deleting product");
        productDao.delete(product);
    }
    public void deleteProduct(int productId){
        log.info("deleting product by id");
        productDao.deleteById(productId);
    }
}
