package br.com.domtecpro.aula_configuracao_conexao_externa;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Colaborador}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyColaboradorRecyclerViewAdapter extends
        RecyclerView.Adapter<MyColaboradorRecyclerViewAdapter.ViewHolder> {

    // listagem de colaboradores
    private final List<Colaborador> mValues;

    public MyColaboradorRecyclerViewAdapter(List<Colaborador> colabs) {
        mValues = colabs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_lista_colaborador, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(String.valueOf(mValues.get(position).getId()));
        holder.mNomeView.setText(mValues.get(position).getNome());
        holder.mCargoView.setText(mValues.get(position).getCargo());
        holder.mSituacaoView.setText(String.valueOf(
                mValues.get(position).getSituacao()));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final AppCompatTextView mIdView;
        public final AppCompatTextView mNomeView;
        public final AppCompatTextView mCargoView;
        public final AppCompatTextView mSituacaoView;
        public Colaborador mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (AppCompatTextView) view.findViewById(R.id.tv_id);
            mNomeView = (AppCompatTextView) view.findViewById(R.id.tv_nome);
            mCargoView = (AppCompatTextView) view.findViewById(R.id.tv_cargo);
            mSituacaoView = (AppCompatTextView) view.findViewById(R.id.tv_situacao);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNomeView.getText() + "'";
        }
    }
}