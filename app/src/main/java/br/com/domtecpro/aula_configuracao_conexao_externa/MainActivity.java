package br.com.domtecpro.aula_configuracao_conexao_externa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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
    }
}
