package main.java.qa.android.main;

import main.java.qa.android.util.PropertyUtils;


public enum BaseUrls implements Constants {

	
	  GOOGLE("https://www.google.hu/"),
	  YAHOO("https://www.yahoo.com/"),
	  HBO("http://www.hbogo.hu/"),
	  PLAYER(PropertyUtils.getProperty("baseUrl"));

	  public String myUrls;

	  	BaseUrls (String url) {
	  		myUrls = url;
	  	}

	  	public String get() {
		  return myUrls;
		}
	  	
	  	public String toString(){
	  		if (this.equals(PLAYER)) {	  			
	  		}
	  		return PropertyUtils.getProperty("MainContents");  			  	
	  	}
}
