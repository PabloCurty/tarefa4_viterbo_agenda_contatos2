package model;

//TODO discutir abaixo
//AgendaDono deve conter seu username e password para que o mesmo possa muda-lo caso queira
//Uma classe login talvez nao seja necessaria, uma vez que isso eh uma consulta ao banco
public class AgendaDono 
{
	private Agenda agenda;
	
	private String nome;
	private String email;
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
