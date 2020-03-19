package com.example.hangin.view.auth.loginFragment;

public interface LoginView {

    void showProgress();

    void hideProgress();

    void emailError();

    void passwordError();

    void validCredentials();

    void inValidCredentials();

}
