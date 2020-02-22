package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ThreeActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_three );

        btn = (Button)findViewById( R.id.button3 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_four();
            }
        });
    }

    void to_four(){
        rg = (RadioGroup)findViewById( R.id.radioGroup3 );
        if(rg.getCheckedRadioButtonId() != -1){
            Intent intent = new Intent();
            intent.setClass(ThreeActivity.this,FourActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(ThreeActivity.this, "You have to choose one!", Toast.LENGTH_SHORT).show();
        }

    }
}
