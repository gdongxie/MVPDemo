package com.zzl.loginmvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zzl.loginmvp.R;
import com.zzl.loginmvp.presenter.ILoginPresenter;
import com.zzl.loginmvp.presenter.LoginPresenterCompI;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {
    private EditText et_userName, et_userPwd;
    private Button btn_login, btn_clear;
    private ILoginPresenter iLoginPresenter;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        et_userName = findViewById(R.id.et_userName);
        et_userPwd = findViewById(R.id.et_userPwd);
        btn_login = findViewById(R.id.btn_login);
        btn_clear = findViewById(R.id.btn_clear);
        progressBar = findViewById(R.id.progress_login);
        btn_login.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        iLoginPresenter = new LoginPresenterCompI(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                iLoginPresenter.setProgressBarVisiblity(View.VISIBLE);
                btn_login.setEnabled(false);
                btn_clear.setEnabled(false);
                iLoginPresenter.doLogin(et_userName.getText().toString().trim(), et_userPwd.getText().toString().trim());
                break;
            case R.id.btn_clear:
                iLoginPresenter.clear();
                break;
            default:
                break;
        }

    }

    @Override
    public void onClearText() {
        et_userName.setText("");
        et_userPwd.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        iLoginPresenter.setProgressBarVisiblity(View.INVISIBLE);
        btn_login.setEnabled(true);
        btn_clear.setEnabled(false);
        if (result) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Login Fail, code = " + code, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }
}
