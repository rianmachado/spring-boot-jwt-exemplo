package br.com.pitang.desafio.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import br.com.pitang.desafio.entities.User;
import br.com.pitang.desafio.exceptions.BusinessException;
import br.com.pitang.desafio.exceptions.CodeBusinessMessageUser;

@Component
public class UserValidator {

	private String regex = "^(.+)@(.+)$";

	private Pattern pattern = Pattern.compile(regex);

	void emailIsPresent(User user) {
		if (user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new BusinessException(CodeBusinessMessageUser.ERROR_USER_EMAIL_NAO_INFORMADO);
		}
	}

	void formatEmail(User user) {
		Matcher matcher = pattern.matcher(user.getEmail());
		if (!matcher.matches()) {
			throw new BusinessException(CodeBusinessMessageUser.ERROR_USER_EMAIL_INVALIDO);
		}
	}

	void lastNameIsPresent(User user) {
		if (user.getLastname() == null || user.getLastname().isEmpty()) {
			throw new BusinessException(CodeBusinessMessageUser.ERROR_USER_LASTNAME_NAO_INFORMADO);
		}
	}

	void firstNameIsPresent(User user) {
		if (user.getFirstname() == null || user.getFirstname().isEmpty()) {
			throw new BusinessException(CodeBusinessMessageUser.ERROR_USER_FIRSTNAME_NAO_INFORMADO);
		}
	}

	void passwordIsPresent(User user) {
		if (user.getPassword() == null || user.getPassword().isEmpty()) {
			throw new BusinessException(CodeBusinessMessageUser.ERROR_USER_PASSWORD_NAO_INFORMADO);
		}
	}

	void allDataUser(User user) {
		emailIsPresent(user);
		firstNameIsPresent(user);
		lastNameIsPresent(user);
		passwordIsPresent(user);
		formatEmail(user);
	}
	
	void emailAndPasswordIsPresent(User user) {
		passwordIsPresent(user);
		emailIsPresent(user);
	}

}