package com.zzl.loginmvp.view;

/**
 * Created by ZZL on 2018/9/5.
 * Email:gdongxie@gmail.com
 */
public interface ILoginView {
    public void onClearText();

    public void onLoginResult(Boolean result, int code);

    public void onSetProgressBarVisibility(int visibility);
}
