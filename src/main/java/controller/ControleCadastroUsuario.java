package controller;

import beans.UsuarioBean;
import exception.UsuarioExistenteException;
import model.Agenda;
import model.Usuario;

public class ControleCadastroUsuario {

	public String cadastraUsuario(UsuarioBean cadastroUsuarioBean) throws UsuarioExistenteException{
		
		try {
			Usuario user = new Usuario(cadastroUsuarioBean.getNome(), 
									   cadastroUsuarioBean.getEmail(), 
									   cadastroUsuarioBean.getUsername(), 
									   cadastroUsuarioBean.getPassword(), 
									   new Agenda());
			//TODO chama o service que chama a persistencia
			return "success";
		} catch (Exception e) {
			throw new UsuarioExistenteException("Usuario já existe no banco");
		}
		
	}
}
