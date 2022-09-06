package com.tutorial.distributecache.repository;

import com.tutorial.distributecache.entities.Product;

import java.util.Optional;
import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Modifying(clearAutomatically=true, flushAutomatically = true)
	@Transactional
	@Query(value ="UPDATE product SET price = :price WHERE id = :id",
		   nativeQuery = true)
    public int updatePrice(@Param("id") Long id, @Param("price") float price);
	
	/* Use only as example to log when call repository from service*/
    default public Optional<Product> findProduct(Long id)  {
    	System.out.println("Call REPOSITORY TO GET OBJECT WITH ID=" + id);
    	return this.findById(id);
    }
}
