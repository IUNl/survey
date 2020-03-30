package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
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

public class NSActivity extends AppCompatActivity {
    String t,upload = "",filename = "survey";
    LinearLayout ll;
    RelativeLayout rl;
    TextView tvs,tvn;
    Button btn_n1;
    int len,turn,temp;
    char c[];
    RadioGroup rp;
    JSONObject json,upJson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_n_s );

        Intent intent = getIntent();
        turn = intent.getIntExtra( "turn",0 );
        upload = intent.getStringExtra( "json" );
        System.out.println( "第几个问题:" );
        System.out.println( turn );
        ll = findViewById( R.id.ll0 );
        rp = findViewById( R.id.rp );
        tvn = findViewById( R.id.tvn );
        tvs = findViewById( R.id.tvs );
        btn_n1 = findViewById( R.id.btn_n1 );

        //读json,数组c保存json字符串
        try {
            // Writing to a file at /data/data/com.studio.android.survey
            File file = new File( getFilesDir(), filename );
            file.createNewFile();
            //FileWriter fileWriter = new FileWriter( file );
            FileReader fileReader = new FileReader( file );
            //System.out.println( "Writing" );
            //System.out.println( "-----------------------" );
            //System.out.println( file.getAbsolutePath() );
            //System.out.println( json.toString() );

            //fileWriter.write( json.toString() );
            //fileWriter.flush();
            //fileWriter.close();

            c = new char[1000] ;
            for(int i = 0;i < c.length;i++)
                c[i] = ' ';
            fileReader.read( c );
            fileReader.close();
            //System.out.println( "Reading" );
            //System.out.println( "-----------------------" );
            //System.out.println( c );
        } catch (IOException e) {
            e.printStackTrace();
        }

        //还原字符串
        /*oc = new char[2000];
        for(int i = 0;i < oc.length;i++)
            oc[i] = ' ';
        for(int i = 0,j = 0;j < c.length;i++,j++){
            if(c[j] == '"'){
                oc[i++] = '\\';
                oc[i] = '"';
            }else{
                oc[i] = c[j];
            }
        }*/

        //构造json
        try {
            json = new JSONObject( String.valueOf(c).trim() );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println( json );
        //解析json
        try {

            JSONObject jo = json.getJSONObject( "survey" );
            int id = jo.getInt( "id" );
            len = jo.getInt( "len" );

            if(turn >= len){
                System.out.println( "大" + upload );
                tvn.setText( "The end of the survey" );
                tvs.setText( "Click the button to save!" );
                btn_n1.setText( "Save" );
                upJson = new JSONObject(upload);
            }else{
                System.out.println( "小" + upload );
                temp = turn + 1;
                tvn.setText( "Question" + temp );
                if(turn == 0)
                    upJson = new JSONObject();
                else
                    upJson = new JSONObject(upload);
            }

            JSONArray questions = jo.getJSONArray( "questions" );
            JSONObject questionObj = questions.getJSONObject( turn );
            String type = questionObj.getString( "type" );
            String question = questionObj.getString( "question" );
            tvs.setText( question );
            JSONArray optionsArr = questionObj.getJSONArray( "options" );

            //动态增加选项
            for (int i = 0; i < optionsArr.length(); i++) {
                String option = optionsArr.getString( i );
                RadioButton rb = new RadioButton( this );
                rb.setText( option );
                rb.setGravity( Gravity.CENTER );
                LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT );
                rp.addView( rb,llp );
                setContentView(ll);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //按钮点击事件
        btn_n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn >= len)
                    save();
                else {
                    jump();
                }
            }
        });

    }

    public String selectRadioBtn(RadioGroup radioGroup){
        RadioButton radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
        return(radioButton.getText().toString());
    }

    public void jump(){
        turn++;
        Intent intent = new Intent();
        intent.setClass( NSActivity.this, NSActivity.class );
        intent.putExtra( "turn", turn );
        try {
            upJson.put( String.valueOf( turn ),selectRadioBtn( rp ) );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println( "upJson是" + upJson );
        intent.putExtra( "json", upJson.toString() );
        System.out.println( "XXXXXXXXXX" );
        System.out.println( upJson );
        startActivity( intent );
    }

    public void save(){
        try {
            File file = new File( getFilesDir(), "results" );
            file.createNewFile();
            FileWriter fileWriter = new FileWriter( file );
            System.out.println( "Writing JSON object to file" );
            System.out.println( "-----------------------" );
            System.out.println( file.getAbsolutePath() );
            System.out.println( upJson.toString() );
            fileWriter.write( upJson.toString() );
            fileWriter.flush();
            fileWriter.close();
            Toast.makeText(NSActivity.this, "Save Successfully!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
