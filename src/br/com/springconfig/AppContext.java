package br.com.springconfig;

public class AppContext {
   
	private String message;

	public void setMessage(String message){
		this.message  = message;
	}
   
	public void getMessage() {
		System.out.println(message);
	}
	
}