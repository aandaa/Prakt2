package lv.anda.prakt2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button backButton = (Button) this.findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            finish();
        }
        });
    }
}