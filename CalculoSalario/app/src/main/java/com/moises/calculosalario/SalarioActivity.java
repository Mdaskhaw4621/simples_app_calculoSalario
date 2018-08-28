package com.moises.calculosalario;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.app.*;

public class SalarioActivity extends Activity {

        RadioGroup rgopcoes;
        Button btncalcular;

        EditText edsalario;

        CheckBox ckbImp_s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        edsalario = (EditText) findViewById(R.id.edsalario);
        rgopcoes = (RadioGroup) findViewById(R.id.rgopcoes);
        btncalcular = (Button) findViewById(R.id.btnCalcular);

        ckbImp_s = (CheckBox) findViewById(R.id.ckbImp_S);



        btncalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                double salario = Double.parseDouble(edsalario.getText().toString());

                int op = rgopcoes.getCheckedRadioButtonId();

                double novo_salario = 0;

                //Calculo do percentual de aumento
                if (op == R.id.rb40){
                    novo_salario = salario + (salario * 0.4);
                }
                else if(op == R.id.rb45){
                    novo_salario = salario + (salario*0.45);
                }
                else if(op == R.id.rb50){
                    novo_salario = salario + (salario*0.5);
                }

                //Calculo do imposto de 8,5% agregado a o novo salário caso o usuario
                // escolha sim


                if(ckbImp_s.isChecked() == true){
                    novo_salario = novo_salario - (salario*0.085);
                }

                AlertDialog.Builder dialogo  = new
                        AlertDialog.Builder(SalarioActivity.this);

                dialogo.setTitle("Novo Salário");

                dialogo.setMessage("Seu novo salário é: R$" + String.valueOf(novo_salario));

                dialogo.setNeutralButton("Ok", null);

                dialogo.show();
            }
        });
    }
}
