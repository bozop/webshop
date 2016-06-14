package com.comtrade.daoFacade;

import java.util.List;

import javax.sql.DataSource;

public class ProductJDBCTemplate implements ProductDAO{

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getProduct(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String id, String price) {
		// TODO Auto-generated method stub
		
	}
//	private DataSource dataSource;
//	private JdbcTemplate jdbcTemplateObject;
//	
//	public void setDataSource(DataSource dataSource) {
//	      this.dataSource = dataSource;
//	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
//	}
//
//	public Product getProduct(String id) {
//	      String SQL = "select * from Product where id = ?";
//	      Product product = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new ProductMapper());
//	      return product;
//	}
//
//	public List<Product> listProducts() {
//	      String SQL = "select * from Product";
//	      List <Product> products = jdbcTemplateObject.query(SQL, new ProductMapper());
//	      return products;
//	}
//
//	public void delete(String id) {
//	      String SQL = "delete from Product where id = ?";
//	      jdbcTemplateObject.update(SQL, id);
//	      System.out.println("Deleted Record with ID = " + id );
//	      return;
//		
//	}
//
//	public void update(String id, String price) {
//	      String SQL = "update Product set price = ? where id = ?";
//	      jdbcTemplateObject.update(SQL, price, id);
//	      System.out.println("Updated Record with ID = " + id );
//	      return;
//		
//	}

}
