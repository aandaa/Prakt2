package lv.annija.prakt2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] listItems;
    boolean[] checkedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goTo2nd = findViewById(R.id.btn_to_2);
        goTo2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });;

        listItems = getResources().getStringArray(R.array.checklist);
        checkedItems = new boolean[listItems.length];

        Button goToDialog = findViewById(R.id.btn_to_dialog);
        goToDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.dialog_title)
                        .setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                String text;
                                if(isChecked){
                                    text = listItems[which] + " checked";
                                } else {
                                    text = listItems[which] + " unchecked";
                                }

                                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setCancelable(false)
                        .setPositiveButton(R.string.pos_btn, null)
                        .setNegativeButton(R.string.neg_btn, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getApplicationContext(), "You closed dialog", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();

                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "You clicked OK", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }




}