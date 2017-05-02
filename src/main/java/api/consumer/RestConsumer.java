package api.consumer;

import java.util.Arrays;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import core.model.Product;

@Service
public class RestConsumer {
	
	private String getUrl = "http://localhost:8080/spring_rest-0.0.1-SNAPSHOT/products/{id}";
	private String postUrl = "http://localhost:8080/spring_rest-0.0.1-SNAPSHOT/product";
	private String getAllUrl = "http://localhost:8080/spring_rest-0.0.1-SNAPSHOT/products";
	
	
	public Product getProduct(Long id){
		return new RestTemplate().getForObject(getUrl, Product.class, id);
	}
	
	public List<Product> getProducts(){
		Product[] response = new RestTemplate().getForObject(getAllUrl, Product[].class);
		return Arrays.asList(response);
	}
	
	public Product postProduct(Product product){
		return new RestTemplate().postForObject(postUrl,product,Product.class);	
	}
	
	
	
	@Scheduled(initialDelay=10000, fixedRate=10000)
	public void testRestConsumer(){
        Product product = new Product("refrigirator", 8);
		Long id = postProduct(product).getId();
		Product received = getProduct(id);
		System.out.println("REST recieved: " + received);
		System.out.println("REST all recieved: " + getProducts());

	}

	
	

}
