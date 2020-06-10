package br.com.pitang.desafio.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.pitang.desafio.entities.utilits.UtilDate;

/**
 * @author rianmachado@gmail.com
 * 
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8423922580840208047L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "USER_FIRSTNAME")
	private String firstname;

	@Column(name = "USER_LASTNAME")
	private String lastname;

	@Column(name = "USER_EMAIL")
	private String email;

	@Column(name = "USER_PASSWORD")
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date loginLastDate;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "user_addresses", joinColumns = @JoinColumn(name = "USER_ID"))
	@AttributeOverrides({ @AttributeOverride(name = "number", column = @Column(name = "number")),
			@AttributeOverride(name = "areaCode", column = @Column(name = "areaCode")),
			@AttributeOverride(name = "countryCode", column = @Column(name = "countryCode")) })
	private Set<Phone> phones;

	public Long getPK() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addPhones(Phone phone) {
		if (phones == null) {
			phones = new HashSet<>();
			phones.add(phone);
		} else {
			phones.add(phone);
		}
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLoginLastDate() {
		return loginLastDate;
	}

	public void setLoginLastDate(Date loginLastDate) {
		this.loginLastDate = loginLastDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@PrePersist
	public void onPrePersist() throws ParseException {
		creationDate = UtilDate.getDateNow(UtilDate.DDMMYYYYHHMMSS);
	}

}