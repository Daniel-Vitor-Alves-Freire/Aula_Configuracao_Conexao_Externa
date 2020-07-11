package br.com.domtecpro.aula_configuracao_conexao_externa;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.snackbar.Snackbar;

public class CadastroFragment extends Fragment {

    private CadastroViewModel mViewModel;
    private AppCompatEditText edtNome;
    private AppCompatEditText edtCargo;
    private AppCompatEditText edtSituacao;
    private AppCompatButton botaoCadastrar;

    public static CadastroFragment newInstance() {
        return new CadastroFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.cadastro_fragment, container, false);

        edtNome = view.findViewById(R.id.txt_nome);
        edtCargo = view.findViewById(R.id.txt_cargo);
        edtSituacao = view.findViewById(R.id.txt_situacao);
        botaoCadastrar = view.findViewById(R.id.botao_cadastro);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Objeto de manipulação do teclado virtual
                InputMethodManager imm = (InputMethodManager) getContext()
                .getSystemService(Activity.INPUT_METHOD_SERVICE);

                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                // Chamar o método de inserção
                Colaborador colab = new Colaborador(
                        edtNome.getText().toString(),
                        edtCargo.getText().toString(),
                        Integer.parseInt(edtSituacao.getText().toString())
                );

                int res = ColaboradorDao.inserirColaborador(colab, getContext());
                if(res<=0){
                    Snackbar.make(view, "Inserção não realizada!",
                            Snackbar.LENGTH_LONG).show();
                }else{
                    Snackbar.make(view, "Colaborador Inserido com " +
                                    "Sucesso!",
                            Snackbar.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CadastroViewModel.class);
        // TODO: Use the ViewModel


    }

}