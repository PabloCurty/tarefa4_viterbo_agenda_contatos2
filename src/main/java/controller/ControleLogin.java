package controller;

import javax.inject.Inject;

import exception.PasswordException;
import exception.UsernameException;
import model.Usuario;
import service.LoginService;

public class ControleLogin {
	
	//@Inject
	//LoginService loginService;
	
	Usuario usuario = new Usuario();
	
	public String login (String username, String password){
		try {
			LoginService loginService = new LoginService();
			usuario = loginService.autentica(username);
			if(usuario.getPassword().equals(password)){
				return "success";
			}else{
				return "failure";
			}
			
		} catch (UsernameException e) {
			throw new UsernameException("usuario errado");
		} catch ( PasswordException ex) {
			throw new PasswordException("senha errada"); 
		}
		
	}

}
