package com.example.hangin.view.auth;

import android.os.Bundle;

import com.example.hangin.R;
import com.example.hangin.view.auth.loginFragment.LoginFragment;
import androidx.appcompat.app.AppCompatActivity;
import static com.example.hangin.utilities.Utility.openFragment;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        openFragment(getSupportFragmentManager(),new LoginFragment(),R.id.user_activity);


    }
}
