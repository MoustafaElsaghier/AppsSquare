package elsaghier.example.com.appssquare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import elsaghier.example.com.appssquare.First_Task.FirstTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        Intent intent;
        int id = view.getId();
        if (id == R.id.firstTaskBtn)
            intent = new Intent(this, FirstTask.class);
        else if (id == R.id.secondTaskBtn)
            intent = new Intent(this, SecondTask.class);
        else
            intent = null;

        if (intent != null)
            startActivity(intent);
    }
}