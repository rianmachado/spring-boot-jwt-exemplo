package br.com.pitang.desafio.services;

import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pitang.desafio.entities.User;
import br.com.pitang.desafio.exceptions.BusinessException;
import br.com.pitang.desafio.exceptions.CodeBusinessMessageUser;
import br.com.pitang.desafio.repository.UserRepository;

/**
 * @author rianmachado@gmail.com
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private PhoneValidator phoneValidator;

	public User record(final User user) {

		if (user == null) {
			throw new BusinessException(CodeBusinessMessageUser.ERROR_USER_RECORD);
		}

		if (CollectionUtils.isEmpty(user.getPhones())) {
			throw new BusinessException(CodeBusinessMessageUser.ERROR_USER_PHONE_NAO_INFORMADO);
		}

		userValidator.allDataUser(user);

		Optional<User> retorno = userRepository.findByEmail(user.getEmail());
		if (retorno.isPresent()) {
			throw new BusinessException(CodeBusinessMessageUser.ERROR_USER_EMAIL_JA_INFORMADO);
		}

		user.getPhones().forEach(phone -> {
			phoneValidator.allDataPhone(phone);
		});

		return userRepository.save(user);
	}

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findByEmailEndPassword(String email, String password) {
		Optional<User> retorno = userRepository.findByEmailEndPassword(email, password);
		retorno.orElseThrow(() -> new BusinessException(CodeBusinessMessageUser.ERROR_USER_END_PASWORD_NAO_LOCALIZADO));
		return retorno;
	}

	public User update(User user) {
		return user;
	}

	public void emailAndPassordIsPresent(final User user) {
		userValidator.emailAndPasswordIsPresent(user);
	}

}
