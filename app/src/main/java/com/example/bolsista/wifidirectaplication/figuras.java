package com.example.bolsista.wifidirectaplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import static com.example.bolsista.wifidirectaplication.R.drawable.triangulo;

public class figuras extends AppCompatActivity {


    Button trocar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figuras);


        initialComponent();
        exqLinester();

    }

    private void initialComponent() {
        trocar = findViewById(R.id.btnFigura);
    }

    private void exqLinester() {
        trocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random radom  = new Random();
                int numeroTmp = radom.nextInt(6);

                if(numeroTmp == 0){
                    trocar.setBackgroundResource(triangulo);
                }else if(numeroTmp == 1){
                    trocar.setBackgroundResource(R.drawable.bola);
                }else if(numeroTmp == 2){
                    trocar.setBackgroundResource(R.drawable.quadrado);
                }else if(numeroTmp == 3){
                    trocar.setBackgroundResource(R.drawable.retangulo);
                }else if(numeroTmp == 4){
                    trocar.setBackgroundResource(R.drawable.pentagono);
                }else if(numeroTmp == 5){
                    trocar.setBackgroundResource(R.drawable.octagono);
                }else{
                    //trocar.setBackgroundResource(R.drawable.estrela);
                }


            }
        });
    }
}
