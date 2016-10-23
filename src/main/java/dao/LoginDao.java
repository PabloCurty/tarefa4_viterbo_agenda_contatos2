package dao;

import model.Usuario;

public interface LoginDao {

	public Usuario autentica(String usuario, String password);
}
