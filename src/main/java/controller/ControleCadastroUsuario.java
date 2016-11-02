package controller;

import beans.UsuarioBean;
import exception.UsuarioExistenteException;
import model.Agenda;
import model.Usuario;
import service.CadastraUsuarioService;

public class ControleCadastroUsuario {
	
	CadastraUsuarioService cadastroUsuarioService = new CadastraUsuarioService();

	public String cadastraUsuario(UsuarioBean cadastroUsuarioBean) throws UsuarioExistenteException{
		
		try {
			Usuario user = new Usuario(cadastroUsuarioBean.getNome(), 
									   cadastroUsuarioBean.getEmail(), 
									   cadastroUsuarioBean.getUsername(), 
									   cadastroUsuarioBean.getPassword(), 
									   new Agenda());
			//cadastrando usuário no banco e setando id do usuario que o banco retorna
			Usuario usuario = cadastroUsuarioService.cadastraUsuario(user);
			cadastroUsuarioBean.setId(usuario.getId_usuario());
			return "success";
		} catch (Exception e) {
			throw new UsuarioExistenteException("Usuario já existe no banco");
		}
		
	}
}
