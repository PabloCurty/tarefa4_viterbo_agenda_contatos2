package model;

import java.util.Set;

public class Agenda 
{
	private AgendaDono dono;
	Set<Contato> contatos;
	
	public AgendaDono getDono() {
		return dono;
	}
	public void setDono(AgendaDono dono) {
		this.dono = dono;
	}
	public Set<Contato> getContatos() {
		return contatos;
	}
	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}
	
}
