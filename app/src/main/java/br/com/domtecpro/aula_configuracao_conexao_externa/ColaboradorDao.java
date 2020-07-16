package br.com.domtecpro.aula_configuracao_conexao_externa;

import android.content.Context;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Colaborador> pesquisarColaboradores(Context contexto){
        // Listagem de colaboradores
        List<Colaborador> lista = null;
        // Objeto de declaração
        PreparedStatement pst;

        try {
            // Criação da declaração
            pst = Conexao.conectar(contexto).prepareStatement("" +
                    "Select id, nome, cargo, situacao " +
                    "from Colaborador Order by id ASC");
            // Execução da pesquisa e retorno das linhas
            ResultSet res = pst.executeQuery();
            lista = new ArrayList<Colaborador>();
            while(res.next()){
                lista.add(new Colaborador(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static List<Colaborador> pesquisarColaboradores(
            String dado, Context contexto){
        // Listagem de colaboradores
        List<Colaborador> lista = null;
        // Objeto de declaração
        PreparedStatement pst;

        try {
            // Criação da declaração
            pst = Conexao.conectar(contexto).prepareStatement("" +
                    "Select id, nome, cargo, situacao " +
                    "from Colaborador " +
                    "Where nome like '%" + dado + "%' " +
                    "Order by id ASC");
            // Execução da pesquisa e retorno das linhas
            ResultSet res = pst.executeQuery();
            lista = new ArrayList<Colaborador>();
            while(res.next()){
                lista.add(new Colaborador(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
