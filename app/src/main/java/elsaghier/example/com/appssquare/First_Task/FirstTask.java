package elsaghier.example.com.appssquare.First_Task;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                String pass = password.getEditText().getText().toString();
                if (name.matches("")) {
                    userName.setErrorEnabled(true);
                    userName.setError("Enter Name");
                } else {
                    userName.setError(null);
                    userName.setErrorEnabled(false);
                }
                if (pass.matches("")) {
                    password.setErrorEnabled(true);
                    password.setError("Enter Password");
                } else {
                    password.setError(null);
                    password.setErrorEnabled(false);
                }
                if (!name.matches("") && !pass.matches(""))
                    Toast.makeText(FirstTask.this, R.string.validUserAndPass, Toast.LENGTH_SHORT).show();
            }
        });
    }

}