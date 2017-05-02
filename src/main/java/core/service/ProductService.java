package core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.model.Product;
import core.model.ProductRepo;

@Service
public class ProductService {
	
	
	private ProductRepo repository;
	
	@Autowired
	public ProductService(ProductRepo repository){
		this.repository = repository;
	}

	public Product save(Product product){
		return repository.saveAndFlush(product);
	}
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id){
		return repository.findOne(id);
	}
}
