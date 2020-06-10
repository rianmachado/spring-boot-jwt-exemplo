package br.com.pitang.desafio.data.transfer.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

/**
 * @author rianmachado@gmail.com
 * 
 */
public class User {

	private long identificador;
	private String password;
	private String email;
	private String lastName;
	private String firstName;
	private String token;
	private String creationDate;
	private String loginLastDate;
	private List<Phone> phones;

	public void addPhone(Phone phone) {
		if (!CollectionUtils.isEmpty(phones)) {
			phones.add(phone);
		} else {
			phones = new ArrayList<>();
			phones.add(phone);
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLoginLastDate() {
		return loginLastDate;
	}

	public void setLoginLastDate(String loginLastDate) {
		this.loginLastDate = loginLastDate;
	}
	

}