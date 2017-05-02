import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import core.CoreConfiguration;
import core.model.Product;
import core.service.ProductService;

public class Main {

	public static void main (String[] args){
		
		ApplicationContext context = new AnnotationConfigApplicationContext(CoreConfiguration.class);
		
		ProductService service = context.getBean("productService", ProductService.class);
		
		Product product = new Product("bread", 3);
		
		System.out.println(service.save(product));
	}
}
