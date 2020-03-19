package com.example.hangin.view.auth.RegisterFragment;


import android.util.Patterns;
import com.example.hangin.utilities.SharedPreferencesManger;


public class RegisterPresenter implements RegisterInterActor.createAccountListener {



    private RegisterView registerView;
    private RegisterInterActor registerInteractor;
    private SharedPreferencesManger sharedPreferencesManger;

    public RegisterPresenter(RegisterView registerView, RegisterInterActor registerInteractor) {
        this.registerView = registerView;
        this.registerInteractor = registerInteractor;
    }

    void signUP(String firstName, String lastName, String email, String phone,
                String password, String confirmPassword) {

        if (firstName.isEmpty()) {
            registerView.firstNameError();
        } else if (lastName.isEmpty()) {
            registerView.lastNameError();
        } else if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            registerView.emailError();
        } else if (phone.isEmpty() || phone.length() != 11) {
            registerView.phoneError();
        } else if (password.isEmpty() || password.length() < 6) {
            registerView.passwordError();
        } else if (confirmPassword.isEmpty() || !confirmPassword.equals(password)) {
            registerView.confirmPasswordError();
        } else {
            registerInteractor.signUP(firstName, lastName, email, phone,
                    password, confirmPassword, this);

        }
    }

    @Override
    public void success() {
        if (registerView != null) {
            registerView.validCredentials();
        }
    }
    @Override
    public void fail() {
        if (registerView != null) {
            registerView.inValidCredentials();
        }
    }
}
