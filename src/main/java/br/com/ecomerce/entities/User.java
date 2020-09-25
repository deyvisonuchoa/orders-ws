package br.com.ecomerce.entities;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email; 
	private String phone;
	private String password;
	
	public User() {		
	}

	public User(Long id, String nome, String email, String telefone, String senha) {
		super();
		this.id = id;
		this.name = nome;
		this.email = email;
		this.phone = telefone;
		this.password = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return phone;
	}

	public void setTelefone(String telefone) {
		this.phone = telefone;
	}

	public String getSenha() {
		return password;
	}

	public void setSenha(String senha) {
		this.password = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
			
	
}