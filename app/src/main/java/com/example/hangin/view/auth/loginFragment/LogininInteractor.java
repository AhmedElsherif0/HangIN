package com.example.hangin.view.auth.loginFragment;

import android.os.Handler;

public class LogininInteractor {


    interface onLoginFinishedListener {

        void success();

        void fail();
    }

    void onLogin(String email, String password, onLoginFinishedListener loginFinishedListener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (email.equalsIgnoreCase("ahmed.elsherif010@gmail.com")
                        &&(password.equalsIgnoreCase("123456"))) {
                    loginFinishedListener.success();
                }else {loginFinishedListener.fail();}
            }
        }, 500);

    }

}
