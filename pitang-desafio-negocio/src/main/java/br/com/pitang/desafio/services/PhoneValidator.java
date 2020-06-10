package br.com.pitang.desafio.services;

import org.springframework.stereotype.Component;

import br.com.pitang.desafio.entities.Phone;
import br.com.pitang.desafio.exceptions.BusinessException;
import br.com.pitang.desafio.exceptions.CodeBusinessMessageUser;

@Component
public class PhoneValidator {

	void numberIsPresent(Phone phone) {

		if (phone.getNumber() == null || phone.getNumber().isEmpty()) {
			throw new BusinessException(CodeBusinessMessageUser.ERROR_USER_PHONE_NUMBER_NAO_INFORMADO);
		}

	}

	void areaCodeIsPresent(Phone phone) {
		if (phone.getAreaCode() == null || phone.getAreaCode().isEmpty()) {
			throw new BusinessException(CodeBusinessMessageUser.ERROR_USER_PHONE_CODE_NAO_INFORMADO);
		}
	}

	void countryCodeIsPresent(Phone phone) {
		if (phone.getCountryCode() == null || phone.getCountryCode().isEmpty()) {
			throw new BusinessException(CodeBusinessMessageUser.ERROR_USER_PHONE_COUNTRY_NAO_INFORMADO);
		}
	}

	void allDataPhone(Phone phone) {
		numberIsPresent(phone);
		areaCodeIsPresent(phone);
		countryCodeIsPresent(phone);
	}

}