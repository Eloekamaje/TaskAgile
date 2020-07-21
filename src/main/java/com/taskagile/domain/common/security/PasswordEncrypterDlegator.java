package com.taskagile.domain.common.security;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncrypterDlegator implements PasswordEncryptor {

	@Override
	public String encrypt(String rawPassword) {
		// TODO Auto-generated method stub
		return rawPassword;
	}

}
