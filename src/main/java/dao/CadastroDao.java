package dao;

import model.Contato;
import model.Usuario;

public interface CadastroDao {

	public Usuario cadastraUsuario(Usuario umUsuario);

	public Contato cadastraContato(Contato contato);
	
	public void removeContato(Contato contato);

	public Contato updateContato(Contato contato);

}
