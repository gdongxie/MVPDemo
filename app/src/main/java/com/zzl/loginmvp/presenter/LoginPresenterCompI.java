package com.zzl.loginmvp.presenter;

import android.os.Handler;
import android.os.Looper;

import com.zzl.loginmvp.model.IUser;
import com.zzl.loginmvp.model.UserModel;
import com.zzl.loginmvp.view.ILoginView;

/**
 * Created by ZZL on 2018/9/5.
 * Email:gdongxie@gmail.com
 */
public class LoginPresenterCompI implements ILoginPresenter {
    private ILoginView loginView;
    private IUser iUser;
    private Handler handler;

    public LoginPresenterCompI(ILoginView loginView) {
        this.loginView = loginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    private void initUser() {
        iUser = new UserModel("MVP", "MVP");
    }

    @Override
    public void clear() {
        loginView.onClearText();

    }

    @Override
    public void doLogin(String userName, String userPwd) {
        Boolean isLoginSuccess = true;
        final int code = iUser.checkUserValidity(userName, userPwd);
        if (code != 0) isLoginSuccess = false;
        final boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loginView.onLoginResult(result, code);
            }
        }, 3000);

    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        loginView.onSetProgressBarVisibility(visiblity);
    }
}
