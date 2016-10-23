package controller;

import beans.CadastroUsuarioBean;
import exception.UsuarioExistenteException;
import model.Agenda;
import model.Usuario;

public class ControleCadastroUsuario {

	public String cadastraUsuario(CadastroUsuarioBean cadastroUsuarioBean) throws UsuarioExistenteException{
		
		try {
			Usuario user = new Usuario(cadastroUsuarioBean.getNome_usuario(), 
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
