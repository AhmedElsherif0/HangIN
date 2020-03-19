package com.example.hangin.view.auth.loginFragment;

import android.util.Patterns;

public class LoginPresenter implements LogininInteractor.onLoginFinishedListener {


    private LoginView viewLogin;
    private LogininInteractor interActorLoginIn;

    private LoginPresenter(LoginView loginView, LogininInteractor logininInteractor) {
        this.viewLogin = loginView;
        this.interActorLoginIn = logininInteractor;
    }

    boolean validateCredential(String email, String password) {

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            viewLogin.emailError();
        } else if (password.isEmpty() || password.length() > 6) {
            viewLogin.passwordError();
        } else {
            viewLogin.showProgress();
            interActorLoginIn.onLogin(email, password, this);
        }
        return false;
    }

    @Override
    public void success() {
        if (viewLogin != null) {
            viewLogin.hideProgress();
            viewLogin.validCredentials();
        }
    }

    @Override
    public void fail() {
        if (viewLogin != null) {
            viewLogin.hideProgress();
            viewLogin.inValidCredentials();
        }
    }
}
