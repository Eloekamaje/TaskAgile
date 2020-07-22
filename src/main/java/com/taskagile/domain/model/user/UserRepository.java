package com.taskagile.domain.model.user;

/**
 * 
 * @author ekassi
 *
 * UserRepository
 */
public interface UserRepository{
	/**
	 * Find user by usename
	 * @param username the provided username used for finding user
	 * @return an instance of <code>User</code> if found, null otherwise
	 */
	User findByUsername(String username);
	
	/**
	 * Find user by email address
	 * @param emailAddres the provided email address used for finding user
	 * @return an instance of <code>User</code> if found, null otherwise
	 */
	User findByEmailAddress(String emailAddress);
	
	/**
	 * Save a new user or an existing user
	 * @param user the user instance to be saved
	 * @return the newly save user
	 */
	void save(User user);

}