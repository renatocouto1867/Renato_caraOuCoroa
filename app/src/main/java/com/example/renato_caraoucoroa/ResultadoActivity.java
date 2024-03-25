package com.example.renato_caraoucoroa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textView = findViewById(R.id.textViewResultado);
        imageView = findViewById(R.id.iViewResultado);
        button = findViewById(R.id.buttonTenterNovamente);

        Intent intent = getIntent();
        textView.setText((intent.getStringExtra("resultado")));
        imageView.setImageResource(Integer.parseInt((intent.getStringExtra("imagem"))));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNovamente = new Intent(ResultadoActivity.this, MainActivity.class);
                startActivity(intentNovamente);
            }
        });


    }
}