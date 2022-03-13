package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int valeur1=0;
    private int valeur2=0;
    private String operation="";
    private Boolean isOp1=true;
    private TextView saisie;

    private void afficher()
    {

        if(!isOp1)
        {
            if(valeur2 != 0)
            {
                saisie.setText(String.valueOf(valeur1) + "" + operation + "" + String.valueOf(valeur2));
            }
            else
            {
                saisie.setText(String.valueOf(valeur1) + "" + operation);
            }

        }
        else
        {
            saisie.setText(String.valueOf(valeur1));
        }
    }

    public boolean notOp(char txt)
    {
        if(txt != '+' && txt != '-' && txt != '/' && txt != '*')
        {
            return true;
        }
        return false;

    }

    public void setOperator(String c)
    {
        //verifier d'abord si carac precedant n'est pas un operateur
        String op = saisie.getText().toString();
        if(notOp(op.charAt(op.length()-1)))
        {
            operation = c;
            isOp1=false;
            afficher();

        }
        else
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Vous avez déjà choisi un opérateur",
                    Toast.LENGTH_SHORT);

            toast.show();
        }

    }

    public void ajouterNbr(String s)
    {
        int val = Integer.parseInt(s);
        if(isOp1)
        {
            valeur1 = valeur1 * 10 + val;
            afficher();
        }
        else
        {
            valeur2 = valeur2 * 10 + val;
            afficher();

        }

    }

    public void calculer()
    {

        if(!isOp1)
        {
            switch (operation)
            {
                case "+" :
                    valeur1 = valeur1 + valeur2;
                    break;
                case "-" :
                    valeur1 = valeur1 - valeur2;
                    break;
                case "*" :
                    valeur1 = valeur1 * valeur2;
                    break;
                case "/" :
                    valeur1 = valeur1 / valeur2;
                    break;
                default : return;
            }
            valeur2 = 0;
            isOp1= true;
            afficher();
        }
    }

    public void clean() //for AC button
    {
        isOp1=true;
        valeur1=0;
        valeur2=0;
        operation="";
        afficher();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        saisie = findViewById(R.id.textViewResult);

        Button zero = (Button)findViewById(R.id.zero);
        Button one = (Button)findViewById(R.id.one);
        Button two = (Button)findViewById(R.id.two);
        Button three = (Button)findViewById(R.id.three);
        Button four = (Button)findViewById(R.id.four);
        Button five = (Button)findViewById(R.id.five);
        Button six = (Button)findViewById(R.id.six);
        Button seven = (Button)findViewById(R.id.seven);
        Button eight = (Button)findViewById(R.id.eight);
        Button nine = (Button)findViewById(R.id.nine);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ajouterNbr(zero.getText().toString());
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ajouterNbr(one.getText().toString());
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ajouterNbr(two.getText().toString());
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ajouterNbr(three.getText().toString());
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ajouterNbr(four.getText().toString());
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ajouterNbr(five.getText().toString());
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ajouterNbr(six.getText().toString());
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ajouterNbr(seven.getText().toString());
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ajouterNbr(eight.getText().toString());
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ajouterNbr(nine.getText().toString());
            }
        });



        Button ac = (Button)findViewById(R.id.ac);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
            clean();
            }
        });

        Button div = (Button)findViewById(R.id.div);
        Button equal = (Button)findViewById(R.id.equal);
        Button product = (Button)findViewById(R.id.product);
        Button minus = (Button)findViewById(R.id.minus);
        Button plus = (Button)findViewById(R.id.plus);

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                setOperator(div.getText().toString());
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                setOperator(plus.getText().toString());
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                setOperator(minus.getText().toString());
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                setOperator(product.getText().toString());
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                calculer();
            }
        });



    }
}