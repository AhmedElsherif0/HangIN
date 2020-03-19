package com.example.hangin.view.auth.RegisterFragment;

import android.os.Handler;

import com.example.hangin.data.Model.Model;

public class RegisterInterActor extends Model {

    interface createAccountListener {

        void success();

        void fail();
    }


    public void signUP(String firstName, String lastName, String email, String phone,
                       String password, String confirmPassword, createAccountListener createAccoutListener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (email.equalsIgnoreCase("ahmed.elsherif010@gmail.com")
                        && password.equalsIgnoreCase("123456")) {
                    createAccoutListener.success();
                } else {
                    createAccoutListener.fail();
                }
            }
        }, 500);
    }

}
