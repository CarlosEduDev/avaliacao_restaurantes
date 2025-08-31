package com.example.avaliaopdm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText textNomeRestaurante;
    private Button btnAvaliar;
    private RatingBar ratingRest;
    private TextView textResult;


    @SuppressLint("MissingInflatedId")
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

        textNomeRestaurante = findViewById(R.id.textNomeRestaurante);
        btnAvaliar = findViewById(R.id.btnAvaliar);
        ratingRest = findViewById(R.id.ratingRest);
        textResult = findViewById(R.id.mostrarRest);

        ratingRest.setNumStars(5);


        btnAvaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String nomeRestaurante = textNomeRestaurante.getText().toString();

                if(nomeRestaurante.isEmpty()){
                    Toast.makeText(MainActivity.this, "O campo do nome do restaurante não pode ser vazio", Toast.LENGTH_SHORT).show();
                }else{
                    textResult.setText("Restaurante: " + nomeRestaurante + " estrelas: " + ratingRest.getRating());
                }
            }
        });

        ratingRest.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Estrelas: " + rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
}