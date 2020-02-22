package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SixActivity extends AppCompatActivity {
    Button btn;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_six );

        btn = (Button)findViewById( R.id.button6 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_seven();
            }
        });
    }

    void to_seven() {
        et = (EditText) findViewById( R.id.et61 );
        if (!et.getText().toString().isEmpty()) {
            Intent intent = new Intent();
            intent.setClass( SixActivity.this, SevenActivity.class );
            startActivity( intent );
        } else {
            Toast.makeText( SixActivity.this, "You have to text something!", Toast.LENGTH_SHORT ).show();
        }
    }
}
