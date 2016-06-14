package com.comtrade.daoFacade;

import java.util.List;
import javax.sql.DataSource;

public interface ProductDAO {
	
	   public void setDataSource(DataSource ds);
	   
	   public Product getProduct(String id);
	   
	   public List<Product> listProducts();
	   
	   public void delete(String id);
	   
	   public void update(String id, String price);
	   
}
