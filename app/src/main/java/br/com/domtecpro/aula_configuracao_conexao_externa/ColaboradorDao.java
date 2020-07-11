package br.com.domtecpro.aula_configuracao_conexao_externa;

import android.content.Context;

import java.sql.PreparedStatement;

public class ColaboradorDao {

    public static int inserirColaborador(Colaborador colaborador, Context ctx){
        int resposta = 0;

        try{
            PreparedStatement pst = Conexao.conectar(ctx).prepareStatement(
                    "Insert Into Colaborador (nome, cargo, situacao) " +
                            "values (?,?,?)"
            );
            pst.setString(1, colaborador.getNome());
            pst.setString(2, colaborador.getCargo());
            pst.setInt(3, colaborador.getSituacao());

            resposta = pst.executeUpdate();

        }catch (Exception e){
            e.getMessage();
        }
        return resposta;
    }
}
