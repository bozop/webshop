package com.comtrade.daoFacade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.comtrade.elasticsearch.Elasticsearch;
import com.comtrade.elasticsearch.ElasticsearchInterface;

@Service
public class DAOFacade implements ProductInterface , PersonInterface, ElasticsearchInterface {
	private List<Product> products = new ArrayList<Product>();
	private List<Person> persons = new ArrayList<Person>();
	private Elasticsearch elasticsearch = new Elasticsearch();
	
	public List<Product> listOfProducts() {
		Product product = new Product();
		product.setId(UUID.randomUUID().toString());
		product.setName("Gel Hand Wash");
		product.setDescription("Sometimes the scent of seasonal hand wash is all we need to rouse our holiday spirits.");
		product.setPrice("3.99");
		products.add(product);
		
	    product = new Product();
		product.setId(UUID.randomUUID().toString());
		product.setName("Shoes");
		product.setDescription("The shoes had been billed as waterproof.");
		product.setPrice("29");
		products.add(product);
		
	    product = new Product();
		product.setId(UUID.randomUUID().toString());
		product.setName("Montana Chocolate");
		product.setDescription(" A lovely Montana Chocolate heavy cream and zesty orange oil, with a hint of vanilla.");
		product.setPrice("2.5");
		products.add(product);		
		return products;
	}
	
	public boolean signup(String username, String password){
		System.out.println("username : " + username);
		System.out.println("password : " + password);

		for (Person person : persons) {
			if (person.getUserName().equals(username))	
				return false;
		}

		Person person = new Person();
		person.setId(UUID.randomUUID().toString());
		person.setSignup(true);
		person.setUserName(username);
		person.setPassword(password);
		persons.add(person);
		
		System.out.println("User with username: " + username + " and password: " + password + " is signin.");
		return true;
	}
	
	public String validation(String username, String password){
		System.out.println("username : " + username + " password : " + password);
		String message = "";

		for (Person person : persons) {
			if (person.getUserName().equals(username)) {
				message = "User already exists.";
				System.out.println("Message : " + message);
				return message;
			}
		}
		System.out.println("Message : " + message);
		return message;
	}
	
	public List<Product> search(String term) {
		try {
			return elasticsearch.getSearchResponse(term);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
