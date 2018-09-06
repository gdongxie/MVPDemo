package com.zzl.loginmvp.model;

/**
 * Created by ZZL on 2018/9/5.
 * Email:gdongxie@gmail.com
 */
public interface IUser {
    String getName();

    String getPwd();

    int checkUserValidity(String userName, String userPwd);
}
