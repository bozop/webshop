package com.comtrade.webshopRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comtrade.daoFacade.PersonInterface;
import com.comtrade.daoFacade.Product;
import com.comtrade.daoFacade.ProductInterface;
import com.comtrade.elasticsearch.ElasticsearchInterface;

@RestController
public class WebShopRestController implements ErrorController {
	private static final String PATH = "/error";
	
	@Autowired
	private ProductInterface productInterface;
	
	@Autowired
	private PersonInterface personInterface;
	
	@Autowired
	private ElasticsearchInterface elasticsearchInterface;
	
	@CrossOrigin
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> listOfProductsFromDAO() {
		return productInterface.listOfProducts();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public boolean signupFromDAO(String username, String password) {
		return personInterface.signup(username, password);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public String validationFromDAO(String username, String password){
		return personInterface.validation(username, password);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Product> searchProductsByName(String term) {
		return elasticsearchInterface.search(term) ;
	}
	
	@RequestMapping("/hello")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping(value = PATH)
	public String error() {
		return "Error handling";
	}
	
	@Override
	public String getErrorPath() {
		return PATH;
	}
}
