package com.tutorial.distributecache.service;

import com.tutorial.distributecache.config.CacheConfig;
import com.tutorial.distributecache.entities.Product;
import com.tutorial.distributecache.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public Product save(Product product) {
    	return this.productRepository.save(product);
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Cacheable(cacheNames = CacheConfig.PRODUCTS_CACHE, unless = "#result == null")
    public Product findById(Long id) {
        return this.productRepository.findProduct(id).orElse(null);
    }

    @CachePut(cacheNames = CacheConfig.PRODUCTS_CACHE, key = "#id", unless = "#result == null")
    public Product updatePrice(Long id, float price) {
        int res = this.productRepository.updatePrice(id, price);
        return res > 0 ? this.productRepository.findById(id).orElse(null): null;
    }

    @CacheEvict(cacheNames = CacheConfig.PRODUCTS_CACHE, key = "#id")
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
