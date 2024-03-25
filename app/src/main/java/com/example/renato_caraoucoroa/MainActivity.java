package com.example.renato_caraoucoroa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ImageButton imageButton;
    private RadioButton radioButtonCara, radioButtonCoroa;
    private int opcao = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioGroup = findViewById(R.id.RgOpcoes);
        imageButton = findViewById(R.id.imageButtonPlay);
        radioButtonCara = findViewById(R.id.rButtonCara);
        radioButtonCoroa = findViewById(R.id.rButtonCoroa);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radioButtonCara.getId()) opcao = 0;
                if (checkedId == radioButtonCoroa.getId()) opcao = 1;
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (opcao != 3) {
                    String[] resultado = Auxiliar.jogar(opcao, MainActivity.this);
                    Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                    intent.putExtra("resultado", resultado[0]);
                    intent.putExtra("imagem", resultado[1]);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Erro: Selecione uma opção", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}