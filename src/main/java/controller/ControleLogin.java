package controller;

import javax.inject.Inject;

import exception.PasswordException;
import exception.UsernameException;
import service.LoginService;

public class ControleLogin {
	
	@Inject
	LoginService loginService;
	
	public String login (String usuario, String password){
		try {
			loginService.autentica(usuario, password);
			return "success";
		} catch (UsernameException e) {
			throw new UsernameException("usuario errado");
		} catch ( PasswordException ex) {
			throw new PasswordException("senha errada"); 
		}
		
	}

}
