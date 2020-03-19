package com.example.hangin.view.auth.loginFragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hangin.R;
import com.example.hangin.utilities.SharedPreferencesManger;
import com.example.hangin.utilities.Utility;
import com.example.hangin.view.auth.FacebookFragment.FacebookFragment;
import com.example.hangin.view.auth.ForgetPassswordFragment.ForgetPasswordFragment;
import com.example.hangin.view.auth.GoogleFragment.GoogleFragment;
import com.example.hangin.view.auth.RegisterFragment.RegisterFragment;
import com.example.hangin.view.home.MainActivity;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.hangin.utilities.Utility.openFragment;


public class LoginFragment extends Fragment implements LoginView {


    @BindView(R.id.login_et_email)
    EditText loginEtEmail;
    @BindView(R.id.login_et_password)
    EditText loginEtPassword;
    @BindView(R.id.login_tv_forgetpassword)
    TextView loginTvForgetpassword;
    @BindView(R.id.login_btn_signin)
    Button loginBtnSignin;
    @BindView(R.id.login_btn_facebook)
    Button loginBtnFacebook;
    @BindView(R.id.login_btn_googlePlus)
    Button loginBtnGooglePlus;
    @BindView(R.id.login_tv_signUp)
    TextView loginTvSignUp;
    private Unbinder unbinder;

    private LoginPresenter loginPresenter;
    private SharedPreferencesManger sharedPreferencesManger;
    private Utility utility;


    public LoginFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        unbinder = ButterKnife.bind(this, view);

        loginPresenter = new LoginPresenter(this, new LogininInteractor());

        return view;
    }

    @OnClick({R.id.login_tv_forgetpassword, R.id.login_btn_signin,
            R.id.login_btn_facebook, R.id.login_btn_googlePlus, R.id.login_tv_signUp})

    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_tv_forgetpassword:
                openFragment(getActivity().getSupportFragmentManager(),
                        new ForgetPasswordFragment(), R.id.user_activity);
                break;
            case R.id.login_btn_signin:
                validation();
                break;
            case R.id.login_btn_facebook:
                openFragment(getActivity().getSupportFragmentManager(),
                        new FacebookFragment(), R.id.user_activity);
                break;
            case R.id.login_btn_googlePlus:
                openFragment(getActivity().getSupportFragmentManager(),
                        new GoogleFragment(), R.id.user_activity);
                break;
            case R.id.login_tv_signUp:
                openFragment(getActivity().getSupportFragmentManager(),
                        new RegisterFragment(), R.id.user_activity);
                break;
        }
    }

    private void validation() {
        String email = loginEtEmail.getText().toString().trim();
        String password = loginEtPassword.getText().toString().trim();

        loginPresenter.validateCredential(email, password);

        if (email.equalsIgnoreCase("ahmed.elsherif010@gmail.com")
                && (password.equalsIgnoreCase("123456"))) {
            Intent i1 = new Intent(getActivity(), MainActivity.class);
            startActivity(i1);

        } else {
            inValidCredentials();
        }
    }

    @Override
    public void showProgress() {
        utility.showDialog(getActivity(), "Loading...");
    }

    @Override
    public void hideProgress() {
        utility.hideDialog();
    }

    @Override
    public void emailError() {
        loginEtEmail.setError("Email Is Empty or Not Match");
        loginEtEmail.requestFocus();
    }

    @Override
    public void passwordError() {
        loginEtPassword.setError("Password Empty or Not Match");
        loginEtPassword.requestFocus();
    }

    @Override
    public void validCredentials() {
        Toast.makeText(getActivity(), "Login Successfully :)", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void inValidCredentials() {
        Toast.makeText(getActivity(), "InValid Email or Password", Toast.LENGTH_SHORT).show();
    }
}
