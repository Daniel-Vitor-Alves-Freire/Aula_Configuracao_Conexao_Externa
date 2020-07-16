package br.com.domtecpro.aula_configuracao_conexao_externa;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.domtecpro.aula_configuracao_conexao_externa.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 */
public class ListaColaboradorFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private SearchView svBusca;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListaColaboradorFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListaColaboradorFragment newInstance(int columnCount) {
        ListaColaboradorFragment fragment = new ListaColaboradorFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_lista_colaborador_list, container, false);

        svBusca = view.findViewById(R.id.sv_busca);

        /*svBusca.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus==false){
                    Context context = view.getContext();
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
                    if (mColumnCount <= 1) {
                        recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    } else {
                        recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
                    }

                    recyclerView.setAdapter(new MyColaboradorRecyclerViewAdapter(
                                ColaboradorDao.pesquisarColaboradores(context)
                        ));
                }
            }
        });*/

        svBusca.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                // Set the adapter
                //if (view instanceof RecyclerView) {
                Context context = view.getContext();
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
                if (mColumnCount <= 1) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                } else {
                    recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
                }

                if (query.isEmpty()) {
                    recyclerView.setAdapter(new MyColaboradorRecyclerViewAdapter(
                            ColaboradorDao.pesquisarColaboradores(context)
                    ));
                } else {
                    recyclerView.setAdapter(new MyColaboradorRecyclerViewAdapter(
                            ColaboradorDao.pesquisarColaboradores(query, context)
                    ));
                }

                //}

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }


        });


        return view;
    }
}