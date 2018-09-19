package com.example.rus.exercise1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    private TextView messageText;
    private Button emailButton;

    private static final String KEY_TEXT = "KEY_TEXT";
    private String email = "azley@mail.ru";
    private String subject = "Hello, Android Academy MSK!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        init();
    }

    private void init() {
        messageText = findViewById(R.id.message_text_view);
        emailButton = findViewById(R.id.email_button);

        messageText.setText(getIntent().getStringExtra(KEY_TEXT));

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        String message = getIntent().getStringExtra(KEY_TEXT);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.no_email_app, Toast.LENGTH_SHORT).show();
        }
    }

    public static Intent newIntent(Context context, String text) {
        Intent intent = new Intent(context, MessageActivity.class);
        intent.putExtra(KEY_TEXT, text);
        return intent;
    }
}
