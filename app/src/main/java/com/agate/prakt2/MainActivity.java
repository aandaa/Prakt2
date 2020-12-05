package com.agate.prakt2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goToSecound= findViewById(R.id.go_to_secoound);
        goToSecound.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent activity2Intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(activity2Intent);
            }
        });
        Button goToDialog= findViewById(R.id.button2);
        goToDialog.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Group participants: ");

        String[] participants = {"Agate Ziediņa", "Anda Āriņa", "Annija Cunska"};
        boolean[] checkedItems = {false, false, false};
        builder.setMultiChoiceItems(participants, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // user checked or unchecked a box
                String variable = "";
                if (isChecked==true){ variable= " checked!";}
                if (isChecked==false){ variable= " unchecked!";}
                Context context = getApplicationContext();
                CharSequence text = text = participants[which]+ variable;
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Context context = MainActivity.this;
                CharSequence text = "You clicked OK!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
               dialog.dismiss();
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Context context = getApplicationContext();
                CharSequence text = "You closed dialog!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                //finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
            }
        });
    }
}