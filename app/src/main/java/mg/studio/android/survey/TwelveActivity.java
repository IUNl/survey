package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TwelveActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_twelve );

        btn = (Button)findViewById( R.id.button12 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_final();
            }
        });
    }

    void to_final(){
        rg = (RadioGroup)findViewById( R.id.radioGroup12 );
        if(rg.getCheckedRadioButtonId() != -1){
            Intent intent = new Intent();
            intent.setClass(TwelveActivity.this,FinalActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(TwelveActivity.this, "You have to choose one!", Toast.LENGTH_SHORT).show();
        }
    }
}
