package com.zzl.loginmvp.view;

import com.zzl.loginmvp.Contract.LoginContract;

/**
 * Created by ZZL on 2018/9/5.
 * Email:gdongxie@gmail.com
 */
public interface ILoginView extends LoginContract.View {
    void onClearText();

    void onLoginResult(Boolean result, int code);

    void onSetProgressBarVisibility(int visibility);
}
