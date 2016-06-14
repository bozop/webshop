package com.comtrade.elasticsearch;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import com.comtrade.daoFacade.Product;

public class Elasticsearch  {	
	
	public List<Product> getSearchResponse(String term) throws IOException {	
		Settings settings = Settings.settingsBuilder().put("cluster.name", "my-application").build();
		Client client = TransportClient.builder()
		        .settings(settings)
		        .build()
		        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
		
		
		SearchResponse response = client.prepareSearch("webshop")
		        .setTypes("products")
		        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
		        .setQuery(QueryBuilders.matchQuery("name", term))    				 // Query
		        .setPostFilter(QueryBuilders.rangeQuery("price").from(1).to(35))     // Filter
		        .setFrom(0).setSize(60).setExplain(true)
		        .execute()
		        .actionGet();	
		
	    List<Product> products = new ArrayList<>();
	    for (SearchHit hit : response.getHits()) {
	        Map<String, Object> source = hit.getSource();
	        Product product = new Product();
	        product.setId(UUID.randomUUID().toString());
	        product.setName(source.get("name").toString());
	        product.setDescription(source.get("description").toString());
	        product.setPrice(source.get("price").toString());
	        products.add(product);
	    }    
		return products;
	}	
}

