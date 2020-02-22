package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SevenActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_seven );

        btn = (Button)findViewById( R.id.button7 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_eight();
            }
        });
    }

    void to_eight() {
        rg = (RadioGroup) findViewById( R.id.radioGroup7 );
        if (rg.getCheckedRadioButtonId() != -1) {
            Intent intent = new Intent();
            intent.setClass( SevenActivity.this, EightActivity.class );
            startActivity( intent );
        } else {
            Toast.makeText( SevenActivity.this, "You have to choose one!", Toast.LENGTH_SHORT ).show();
        }
    }
}
