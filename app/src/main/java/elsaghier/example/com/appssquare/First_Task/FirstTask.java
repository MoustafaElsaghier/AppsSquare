package elsaghier.example.com.appssquare.First_Task;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import elsaghier.example.com.appssquare.R;

public class FirstTask extends AppCompatActivity {

    Button loginBTN;
    TextInputLayout userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_task);
    }

}