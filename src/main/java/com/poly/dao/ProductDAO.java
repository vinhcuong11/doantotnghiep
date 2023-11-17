package com.poly.dao;



 

import java.util.List; 

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 
import com.poly.entity.Products;

public interface ProductDAO extends JpaRepository<Products, Integer>{
	
	
	@Query("select p from Products p where p.productid=?1")
	 Products getOne(Integer id);

	@Query("select p from Products p where  concat(p.productid,p.name,p.category.id) like %?1%")
	List<Products> findAllByName(String keyword);

}
