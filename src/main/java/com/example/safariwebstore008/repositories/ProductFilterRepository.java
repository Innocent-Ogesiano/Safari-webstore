package com.example.safariwebstore008.repositories;



import com.example.safariwebstore008.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFilterRepository extends CrudRepository<Product, Long> {

}
