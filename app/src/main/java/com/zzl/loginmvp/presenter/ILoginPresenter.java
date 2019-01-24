package com.zzl.loginmvp.presenter;

import com.zzl.loginmvp.Contract.LoginContract;

/**
 * Created by ZZL on 2018/9/5.
 * Email:gdongxie@gmail.com
 */
public interface ILoginPresenter extends LoginContract.Presenter {
    /***
     *一键清除
     */
    void clear();

    /***
     * 登陆
     * @param userName 用户名
     * @param userPwd 密码
     */
    void doLogin(String userName, String userPwd);

    /***
     * progressbar的显示与隐藏
     * @param visiblity
     */
    void setProgressBarVisiblity(int visiblity);
}
