package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ElevenActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_eleven );

        btn = (Button)findViewById( R.id.button11 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_twelve();
            }
        });
    }

    void to_twelve(){
        rg = (RadioGroup)findViewById( R.id.radioGroup11 );
        if(rg.getCheckedRadioButtonId() != -1){
            Intent intent = new Intent();
            intent.setClass(ElevenActivity.this,TwelveActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(ElevenActivity.this, "You have to choose one!", Toast.LENGTH_SHORT).show();
        }
    }
}
