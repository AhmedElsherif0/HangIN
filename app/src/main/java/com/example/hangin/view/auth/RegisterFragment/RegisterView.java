package com.example.hangin.view.auth.RegisterFragment;

public interface RegisterView {

    void firstNameError();

    void lastNameError();

    void emailError();

    void phoneError();

    void passwordError();

    void confirmPasswordError();

    void validCredentials();

    void inValidCredentials();


}
