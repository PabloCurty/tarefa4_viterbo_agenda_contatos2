package controller;

import beans.LoginBean;
import exception.PasswordException;
import exception.UsernameException;
import model.Usuario;
import service.LoginService;

public class ControleLogin {
	
	Usuario usuario = new Usuario();
	
	public String login (LoginBean loginBean){
		try {
			LoginService loginService = new LoginService();
			usuario = loginService.autentica(loginBean.getUsuario());
			
			if(usuario.getPassword().equals(loginBean.getPassword()))
			{
				loginBean.setId(usuario.getId_usuario());
				return "success";
			}
			else
			{
				return "failure";
			}
			
		} catch (UsernameException e) {
			throw new UsernameException("usuario errado");
		} catch ( PasswordException ex) {
			throw new PasswordException("senha errada"); 
		}
		
	}

}
