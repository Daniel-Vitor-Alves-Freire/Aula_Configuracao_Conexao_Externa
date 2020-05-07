package br.com.domtecpro.aula_configuracao_conexao_externa;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    /**
     * Método de Conexão com o banco de dados
     */
    public static Connection conectar(Context ctx){
        // Objeto de conexão
        Connection conn = null;
        try{
            // Adicionar política para criação de thread
            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);
            // Verificar se Driver de Conexão esta importado no projeto
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            // Configurar conexão
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.231;" +
                    "databaseName=PRAP3;user=sa;password=123456;");
        }catch(SQLException e){
            //e.getMessage();
            Toast.makeText(ctx, "SERVIDOR " +
                    "INDISPONÍVEL", Toast.LENGTH_LONG).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
