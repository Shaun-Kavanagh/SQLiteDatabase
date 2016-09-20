package com.example.shaun.databasetest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button myButton=(Button)findViewById((R.id.buttonIn));
        final EditText ID=(EditText) findViewById((R.id.editTextID));
        final EditText Name=(EditText) findViewById((R.id.editTextName));
        final TextView retID=(TextView)findViewById(R.id.textView);
        final TextView retName=(TextView)findViewById(R.id.textView2);

        final Context context=this.getApplicationContext();


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID1=ID.getText().toString();
                String Name1=Name.getText().toString();
                DBPage DB= new DBPage(context);
                DB.insert(Name1,ID1);
                String retString=DB.read(Integer.parseInt(ID1));
                retID.setText(retString);
                retName.setText(retString);
            }
        });

    }
}
