package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rb;
    Button btn,btn_getSurvey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.welcome );

        btn = (Button)findViewById( R.id.button0 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_one();
            }
        });
        btn_getSurvey = findViewById( R.id.button00 );
        btn_getSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_getSurvey();
            }
        });
    }
    void to_one(){
        rb = (RadioButton)findViewById( R.id.radioButton0 );
        if(rb.isChecked()){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,OneActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this, "You have to accept!", Toast.LENGTH_SHORT).show();
        }
    }

    void to_getSurvey(){
        rb = (RadioButton)findViewById( R.id.radioButton0 );
        if(rb.isChecked()){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,NSActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this, "You have to accept!", Toast.LENGTH_SHORT).show();
        }
    }
}
