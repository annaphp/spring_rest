package api.producer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.model.Product;
import core.service.ProductService;

@RestController
public class ProductRESTController {
   
	@Autowired
	ProductService service;
	
	@RequestMapping(value="/products", method=RequestMethod.GET, produces="application/json")
	public List<Product> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET, produces="application/json")
	public Product findById(@PathVariable Long id){
		return service.findById(id);
	}
	
	@RequestMapping(value="/product", method=RequestMethod.POST, consumes="application/json")
	public Product saveProduct(@RequestBody Product product){
		return service.save(product);
	}
	
}
