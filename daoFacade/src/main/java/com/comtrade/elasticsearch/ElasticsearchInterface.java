package com.comtrade.elasticsearch;

import java.util.List;
import java.util.Set;

import org.elasticsearch.action.search.SearchResponse;

import com.comtrade.daoFacade.Product;

public interface ElasticsearchInterface {
	List<Product> search(String term);
}
