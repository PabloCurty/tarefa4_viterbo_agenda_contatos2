package model;

import java.util.Set;

public class Agenda 
{
	private Usuario dono;
	Set<Contato> contatos;
	
	public Usuario getDono() {
		return dono;
	}
	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	public Set<Contato> getContatos() {
		return contatos;
	}
	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}
	
}
