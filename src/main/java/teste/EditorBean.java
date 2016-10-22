package teste;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="editor")
public class EditorBean {

	private String value = "Entre com usuário e senha para acessar seus contatos";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
