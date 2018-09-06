package com.zzl.loginmvp.model;

import android.text.TextUtils;

/**
 * Created by ZZL on 2018/9/5.
 * Email:gdongxie@gmail.com
 */
public class UserModel implements IUser {
    private String userName;
    private String userPwd;

    public UserModel(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    @Override
    public String getName() {
        return userName;
    }

    @Override
    public String getPwd() {
        return userPwd;
    }

    @Override
    public int checkUserValidity(String userName, String userPwd) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(userPwd) || !userName.equals(getName()) || !userPwd.equals(getPwd())) {
            return -1;
        }
        return 0;
    }
}
