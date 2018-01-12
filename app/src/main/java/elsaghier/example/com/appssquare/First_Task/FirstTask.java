package elsaghier.example.com.appssquare.First_Task;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import elsaghier.example.com.appssquare.R;

public class FirstTask extends AppCompatActivity {

    Button loginBTN;
    TextInputLayout userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_task);
        init();
    }

    private void init() {
        userName = findViewById(R.id.TIL_name);
        password = findViewById(R.id.TIL_pass);
        loginBTN = findViewById(R.id.BTN_login);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName.getEditText().getText().toString();
                String pass = userName.getEditText().getText().toString();
                if (TextUtils.isEmpty(name))
                    userName.setError("Please Enter Name");
                if (TextUtils.isEmpty(pass))
                    password.setError("Please Enter Password");
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pass))
                    Snackbar.make(view, R.string.validUserAndPass, Snackbar.LENGTH_LONG);
            }
        });
    }

}