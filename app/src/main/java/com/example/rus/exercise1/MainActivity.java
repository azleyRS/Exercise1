package com.example.rus.exercise1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText message;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        message = findViewById(R.id.message_edit_text);
        sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMessageActivity();
            }
        });
    }

    private void openMessageActivity() {
        if (message.getText().length() != 0){
            Intent intent = MessageActivity.newIntent(this, message.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.no_text_warning, Toast.LENGTH_SHORT).show();
        }
    }
}
