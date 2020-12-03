package lv.anda.prakt2;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
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

        Button button_2nd_activity = findViewById(R.id.button_2nd_activity);
        button_2nd_activity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(activity2Intent);
            }
        });

        String[] membersList = getResources().getStringArray(R.array.members);
        Button button_dialog = findViewById(R.id.button_dialog);
        button_dialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.dialog_title).setMultiChoiceItems(R.array.members, null, new DialogInterface.OnMultiChoiceClickListener() {@Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if (isChecked) {
                        Toast.makeText(MainActivity.this, membersList[which] + " checked", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, membersList[which] + " unchecked", Toast.LENGTH_SHORT).show();
                    }
                }
                }).setPositiveButton(R.string.ok, null)

                        .setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(MainActivity.this, R.string.toast_text_close, Toast.LENGTH_SHORT).show();

                        }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, R.string.toast_text_ok, Toast.LENGTH_SHORT).show();
                }
                });
            }
        });
    }
}