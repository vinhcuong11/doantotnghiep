package com.poly.dao;



 

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Products;

public interface ProductDAO extends JpaRepository<Products, Integer>{
	
	
	@Query("select p from Products p where p.productid=?1")
	 Products getOne(Integer id);

	@Query("select p from Products p where  concat(p.productid,p.name,p.category.id) like %?1%")
	List<Products> findAllByName(String keyword);

	@Query("select p from Products p where p.category.id=?1")
	List<Products> findByCategory(Optional<String> cid);

	@Query("select p from Products p where p.price between ?1 and ?2")
	List<Products> findAllByPriceBetweenMinAndMax(Double min, Double max);
	
	@Query("select p from Products p where p.category.id=:cid")
	Page<Products> findByCategory(@Param("cid")Optional<String> cid, Pageable p);
	@Query("select p from Products p where  concat(p.productid,p.name,p.category.id) like %:keyword%")
	Page<Products> findAllByKeyword(@Param("keyword")String keyword, Pageable p);
	@Query("select p from Products p where p.price between :min and :max")
	Page<Products> findAllByPriceBetweenMinAndMax(@Param("min") Double min,@Param("max") Double max, Pageable p);

}
