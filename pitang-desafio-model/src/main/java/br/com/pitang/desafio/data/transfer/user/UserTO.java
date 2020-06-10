package br.com.pitang.desafio.data.transfer.user;

import java.util.ArrayList;
import java.util.List;

import br.com.pitang.desafio.data.transfer.HeaderCuston;

/**
 * @author rianmachado@gmail.com
 * 
 */
public class UserTO extends HeaderCuston{

	private User usuario;
	private List<User> usuarios;
	
	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public List<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}

	public void adicionarUsuario(User usuario) {
		if (usuarios==null) {
			usuarios = new ArrayList<>();
			usuarios.add(usuario);
		} else {
			usuarios.add(usuario);			
		}
	}

}