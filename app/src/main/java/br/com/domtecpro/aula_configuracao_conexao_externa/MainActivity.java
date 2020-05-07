package br.com.domtecpro.aula_configuracao_conexao_externa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.sql.Connection;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView texto = findViewById(R.id.tvTexto);

        Connection conn = Conexao.conectar(getApplicationContext());
        try {
            if (conn != null) {
                if (!conn.isClosed())
                    texto.setText("CONEXÃO REALIZADA COM SUCESSO!!!");
                else
                    texto.setText("CONEXÃO FECHADA!!!");
            }else{
                texto.setText("CONEXÃO NULA, NÃO REALIZADA!!!");
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            texto.setText("CONEXÃO FALHOU!!! " +
                    e.getMessage());
        }

        AppCompatButton botaoEntrar = findViewById(R.id.btnEntrar);
        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar entrada
                Intent it = new Intent(getApplicationContext(),
                        MenuActivity.class);
                startActivity(it);
            }
        });
    }
}
