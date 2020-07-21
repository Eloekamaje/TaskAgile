package com.taskagile.domain.common.security;

public interface PasswordEncryptor {
	/**
	 * Encrypt a raw password
	 * @param password the raw password to be encrypted
	 * @return encrypted password
	 */
	public String encrypt(String rawPassword);

}
