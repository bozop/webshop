package com.comtrade.daoFacade;

public interface PersonInterface {
	
	boolean signup(String username, String password);
	
	String validation(String username, String password);
	
}
