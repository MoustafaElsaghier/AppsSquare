package elsaghier.example.com.appssquare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import elsaghier.example.com.appssquare.First_Task.FirstTask;
import elsaghier.example.com.appssquare.Fourth_Task.MapTask;
import elsaghier.example.com.appssquare.Second_Task.SecondTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        Intent intent = null;
        int id = view.getId();
        if (id == R.id.firstTaskBtn)
            intent = new Intent(this, FirstTask.class);
        else if (id == R.id.secondTaskBtn)
            intent = new Intent(this, SecondTask.class);
        else if (id == R.id.third_task)
            Toast.makeText(this, "لسه معملتهوش شوف غيره :D ", Toast.LENGTH_SHORT).show();
        else if (id == R.id.fourth_task)
            intent = new Intent(this, MapTask.class);
        else
            intent = null;

        if (intent != null)
            startActivity(intent);
    }
}