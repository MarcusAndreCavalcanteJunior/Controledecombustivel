package com.example.controledecombustivel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    TextView tvwProporcao, tvwResultado;
    EditText edtAlcool, edtGasolina;
    DecimalFormat df = new DecimalFormat("#.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Views aqui para não dar erro no bloco
        btnCalcular = findViewById(R.id.btnCalcular);
        tvwProporcao = findViewById(R.id.tvwProporcao);
        tvwResultado = findViewById(R.id.tvwResultado);
        edtAlcool = findViewById(R.id.edtAlcool);
        edtGasolina = findViewById(R.id.edtGasolina);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });



/* Ensinado na aula           btnCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String strAlcool = edtAlcool.getText().toString();
                    String strGasolina = edtGasolina.getText().toString();
*//* Macete para comentar só selecionar as linhas que quer comentar e segurar ctrl + shift +/
System.out.println(strAlcool);PARA REPETIR A LINHA SÓ DAR ctrl + d
System.out.println(strGasolina); *//*
                    double dblAlcool = Double.parseDouble(strAlcool);
                    double dblGasoline = Double.parseDouble(strGasolina);
                    //System.out.println(dblAlcool + dblGasoline);
                    double dblResultado = (dblAlcool / dblGasoline) * 100;
                    tvwProporcao.setText("Proporção:" + df.format(dblResultado) + "%");

                    String strResultado;

                    if(dblResultado > 70) {
                        strResultado = "Abasteça com gasolina";
                    }else {
                        strResultado = "Abasteça com álcool";
                    }

                    tvwResultado.setText(strResultado);

                }
        });*/

        //Correção do Desafio da Aula tratamento dos erros se deixar o campo vazio
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String strAlcool = edtAlcool.getText().toString().trim();
                    String strGasolina = edtGasolina.getText().toString().trim();

                    // Validação para evitar erros de conversão
                    if (strAlcool.isEmpty() || strGasolina.isEmpty()) {
                        tvwResultado.setText(" Erro, preencha todos os campos.");
                        return;
                    }

                    // Conversão de strings para double do mesmo jeito da videoaula
                    double dblAlcool = Double.parseDouble(strAlcool);
                    double dblGasolina = Double.parseDouble(strGasolina);

                    // Cálculo da proporção 100 como video Aula
                    double dblResultado = (dblAlcool / dblGasolina) * 100;
                    tvwProporcao.setText("Proporção: " + df.format(dblResultado) + "%");

                    // Verificação do resultado
                    String strResultado;
                    if (dblResultado > 70) {
                        strResultado = "Abasteça com gasolina";
                    } else {
                        strResultado = "Abasteça com álcool";
                    }

                    tvwResultado.setText(strResultado);

                } catch (NumberFormatException e) {
                    // Tratamento de erros de conversão do desafio da video aula
                    tvwResultado.setText("Erro: Insira valores válidos.");
                }
            }
        });
    }
}