package com.exemple.hotel.cli;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class AbstractMain {
	public static String SERVICE_URL;
	public static String login;
	public static String password;
	public static final String QUIT = "0";
	
	
	protected void setTestServiceUrl (BufferedReader inputReader) throws IOException {
		//System.out.println("please provide the login:");
		//SERVICE_URL = inputReader.readLine();
		//login = inputReader.readLine();
		//System.out.println("please provide the password:");
		//password = inputReader.readLine();

		/*while (! validLogin() || ! validPassword()) {
			System.err.println("Error: the login or the password isn't a valid, please try again");
			login = inputReader.readLine();
			password = inputReader.readLine();
		}
	
		/*while (! validServiceWSDLUrl()) {
			System.err.println("Error: "+ SERVICE_URL + "isn't a valid service Url");
			SERVICE_URL = inputReader.readLine();*/
		}
	
	
	
	
	//protected abstract boolean validPassword();
	//protected abstract boolean validLogin();
	//protected abstract boolean validServiceWSDLUrl();
	protected abstract void menu();
	
	

}
