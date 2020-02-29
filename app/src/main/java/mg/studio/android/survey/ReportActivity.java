package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ReportActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12;
    Button btn;
    String s;
    String filename = "survey";
    Intent intent;
    JSONObject json = new JSONObject();
    FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_report );

        intent = getIntent();
        tv1 = findViewById( R.id.tv1 );
        tv2 = findViewById( R.id.tv2 );
        tv3 = findViewById( R.id.tv3 );
        tv4 = findViewById( R.id.tv4 );
        tv5 = findViewById( R.id.tv5 );
        tv6 = findViewById( R.id.tv6 );
        tv7 = findViewById( R.id.tv7 );
        tv8 = findViewById( R.id.tv8 );
        tv9 = findViewById( R.id.tv9 );
        tv10 = findViewById( R.id.tv10 );
        tv11 = findViewById( R.id.tv11 );
        tv12 = findViewById( R.id.tv12 );
        btn = findViewById( R.id.btn_save );

        tv1.setText( "Q1:" + intent.getStringExtra( "question_one" ) );
        tv2.setText( "Q2:" + intent.getStringExtra( "question_two" ) );
        tv3.setText( "Q3:" + intent.getStringExtra( "question_three" ) );
        tv4.setText( "Q4:" + intent.getStringExtra( "question_four" ) );
        tv5.setText( "Q5:" + intent.getStringExtra( "question_five" ) );
        tv6.setText( "Q6:" + intent.getStringExtra( "question_six" ) );
        tv7.setText( "Q7:" + intent.getStringExtra( "question_seven" ) );
        tv8.setText( "Q8:" + intent.getStringExtra( "question_eight" ) );
        tv9.setText( "Q9:" + intent.getStringExtra( "question_nine" ) );
        tv10.setText( "Q10:" + intent.getStringExtra( "question_ten" ) );
        tv11.setText( "Q11:" + intent.getStringExtra( "question_eleven" ) );
        tv12.setText( "Q12:" + intent.getStringExtra( "question_twelve" ) );

        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject json = new JSONObject();
                try {
                    json.put( "Q1", intent.getStringExtra( "question_one" ) );
                    json.put( "Q2", intent.getStringExtra( "question_two" ) );
                    json.put( "Q3", intent.getStringExtra( "question_three" ) );
                    json.put( "Q4", intent.getStringExtra( "question_four" ) );
                    json.put( "Q5", intent.getStringExtra( "question_five" ) );
                    json.put( "Q6", intent.getStringExtra( "question_six" ) );
                    json.put( "Q7", intent.getStringExtra( "question_seven" ) );
                    json.put( "Q8", intent.getStringExtra( "question_eight" ) );
                    json.put( "Q9", intent.getStringExtra( "question_nine" ) );
                    json.put( "Q10", intent.getStringExtra( "question_ten" ) );
                    json.put( "Q11", intent.getStringExtra( "question_eleven" ) );
                    json.put( "Q12", intent.getStringExtra( "question_twelve" ) );
                    Log.d( "info", json.toString() );
                    Toast.makeText( ReportActivity.this, "Infomation saved!", Toast.LENGTH_SHORT ).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                btn.setEnabled( false );

                try {

                    // Writing to a file at /data/data/com.studio.android.survey
                    File file = new File( getFilesDir(), filename );
                    file.createNewFile();
                    FileWriter fileWriter = new FileWriter( file );
                    FileReader fileReader = new FileReader( file );
                    System.out.println( "Writing JSON object to file" );
                    System.out.println( "-----------------------" );
                    System.out.println( file.getAbsolutePath() );
                    System.out.println( json.toString() );

                    fileWriter.write( json.toString() );
                    fileWriter.flush();
                    fileWriter.close();

                    char c[] = new char[1000] ;
                    fileReader.read( c );
                    System.out.println( "Testing JSON file is stored" );
                    System.out.println( "-----------------------" );
                    System.out.println( c );

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        } );
    }


}
