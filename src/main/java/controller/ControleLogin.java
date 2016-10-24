package controller;

import javax.inject.Inject;

import exception.PasswordException;
import exception.UsernameException;
import service.LoginService;

public class ControleLogin {
	
	//@Inject
	//LoginService loginService;
	
	public String login (String usuario, String password){
		try {
			//LoginService loginService = new LoginService();
			//long numero = loginService.autentica(usuario, password);
			//if(numero == 1){
				return "success";
			//}else{
			//	return "failure";
			//}
			
		} catch (UsernameException e) {
			throw new UsernameException("usuario errado");
		} catch ( PasswordException ex) {
			throw new PasswordException("senha errada"); 
		}
		
	}

}
