package com.example.hangin.view.auth.RegisterFragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hangin.R;
import com.example.hangin.data.Model.Model;
import com.example.hangin.utilities.SharedPreferencesManger;
import com.example.hangin.view.home.MainActivity;


import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class RegisterFragment extends Fragment implements RegisterView {


    @BindView(R.id.register_et_firstName)
    EditText registerEtFirstName;
    @BindView(R.id.register_et_lastName)
    EditText registerEtLastName;
    @BindView(R.id.register_et_Email)
    EditText registerEtEmail;
    @BindView(R.id.register_et_phoneNumber)
    EditText registerEtPhoneNumber;
    @BindView(R.id.register_et_password)
    EditText registerEtPassword;
    @BindView(R.id.register_et_confirmPassword)
    EditText registerEtConfirmPassword;
    @BindView(R.id.register_btn_createAccount)
    Button registerBtnCreateAccount;


    private SharedPreferencesManger sharedPreferencesManger;
    private RegisterPresenter registerPresenter;
    private Unbinder unbinder;
    private Model model;


    public static String USER_DATA = "USER_DATA";
    public static String USER_PASSWORD = "USER_PASSWORD";


    public RegisterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, view);

        registerPresenter = new RegisterPresenter(this, new RegisterInterActor());

        return view;
    }

    @OnClick({R.id.register_tv_back, R.id.register_btn_createAccount})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_tv_back:
                break;

            case R.id.register_btn_createAccount:
                validation();
                break;
        }
    }

    private void validation() {

        String firstName = registerEtFirstName.getText().toString().trim();
        String lastName = registerEtLastName.getText().toString().trim();
        String email = registerEtEmail.getText().toString().trim();
        String phone = registerEtPhoneNumber.getText().toString().trim();
        String password = registerEtPassword.getText().toString().trim();
        String confirmPassword = registerEtConfirmPassword.getText().toString().trim();

        registerPresenter.signUP(firstName, lastName, email, phone, password, confirmPassword);
    }

    @Override
    public void firstNameError() {
        registerEtFirstName.setError("First Name Is Empty");
        registerEtFirstName.requestFocus();
    }

    @Override
    public void lastNameError() {
        registerEtLastName.setError("LastName Is Empty");
        registerEtLastName.requestFocus();
    }

    @Override
    public void phoneError() {
        registerEtPhoneNumber.setError("Phone Number Must Be 11 Num.");
        registerEtPhoneNumber.requestFocus();
    }

    @Override
    public void emailError() {
        registerEtEmail.setError("Email Is Empty OR Not Match.");
        registerEtEmail.requestFocus();
    }

    @Override
    public void passwordError() {
        registerEtPassword.setError("Password Must be More Than 6 Num.");
        registerEtPassword.requestFocus();
    }

    @Override
    public void confirmPasswordError() {
        registerEtConfirmPassword.setError("Confirm Not Match Password");
        registerEtConfirmPassword.requestFocus();
    }

    @Override
    public void validCredentials() {

        Toast.makeText(getActivity(), " Welcome To Home :)", Toast.LENGTH_SHORT).show();
        Intent i1 = new Intent(getActivity(), MainActivity.class);
        startActivity(i1);
    }

    @Override
    public void inValidCredentials() {
        Toast.makeText(getActivity(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
    }
}
