package com.taskagile.domain.model.user;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.taskagile.domain.common.security.PasswordEncryptor;

public class RegistrationManagementTests {

  private UserRepository repositoryMock;
  private PasswordEncryptor passwordEncryptorMock;
  private RegistrationManagement instance;

  @Before
  public void setUp() {
    repositoryMock = mock(UserRepository.class);
    passwordEncryptorMock = mock(PasswordEncryptor.class);
    instance = new RegistrationManagement(repositoryMock, passwordEncryptorMock);
  }

  @Test(expected = UsernameExistsException.class)
  public void register_existedUsername_shouldFail() throws RegistrationException {
    String username = "existUsername";
    String emailAddress = "sunny@taskagile.com";
    String password = "MyPassword!";
    // We just return an empty user object to indicate an existing user
    when(repositoryMock.findByUsername(username)).thenReturn(new User());
    instance.register(username, emailAddress, password);
  }

  @Test(expected = EmailAddressExistsException.class)
  public void register_existedEmailAddress_shouldFail() throws RegistrationException {
    String username = "sunny";
    String emailAddress = "exist@taskagile.com";
    String password = "MyPassword!";
    // We just return an empty user object to indicate an existing user
    when(repositoryMock.findByEmailAddress(emailAddress)).thenReturn(new User());
    instance.register(username, emailAddress, password);
  }

  @Test
  public void register_uppercaseEmailAddress_shouldSucceedAndBecomeLowercase() throws RegistrationException {
    String username = "sunny";
    String emailAddress = "Sunny@TaskAgile.com";
    String password = "MyPassword!";
    instance.register(username, emailAddress, password);
    User userToSave = User.create(username, emailAddress.toLowerCase(), password);
    verify(repositoryMock).save(userToSave);
  }

  @Test
  public void register_newUser_shouldSucceed() throws RegistrationException {
    String username = "sunny";
    String emailAddress = "sunny@taskagile.com";
    String password = "MyPassword!";
    String encryptedPassword = "EncryptedPassword";
    User newUser = User.create(username, emailAddress, encryptedPassword);
  }
}

