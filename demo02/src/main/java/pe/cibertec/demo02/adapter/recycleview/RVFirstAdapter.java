package pe.cibertec.demo02.adapter.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.cibertec.demo02.R;
import pe.cibertec.demo02.entities.Persona;

/**
 * Created by Android-SAB-PM on 14/05/2016.
 */
public class RVFirstAdapter extends RecyclerView.Adapter<RVFirstAdapter.RVFirstAdapterViewHolder> {

    private ArrayList<Persona> mLstPersona;

    public RVFirstAdapter() {
        mLstPersona = new ArrayList<>();
    }

    public void clearAllAndAdd(ArrayList<Persona> lstPersona) {
        mLstPersona.clear();
        mLstPersona.addAll(lstPersona);
        notifyDataSetChanged();
    }

    @Override
    public RVFirstAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVFirstAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.first_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RVFirstAdapterViewHolder holder, int position) {
        Persona persona = mLstPersona.get(position);
        holder.tvFirstItemCodigo.setText(String.valueOf(persona.getIdpersona()));
        holder.tvFirstItemNombre.setText(persona.getNombre());
        holder.tvFirstItemApellido.setText(persona.getApellido());
        holder.tvFirstItemDNI.setText(persona.getDni());
        holder.tvFirstItemEdad.setText(String.valueOf(persona.getEdad()));
        holder.tvFirstItemGenero.setText(persona.getGeneroNombre());
    }

    @Override
    public int getItemCount() {
        return mLstPersona.size();
    }

    class RVFirstAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView tvFirstItemEdad, tvFirstItemGenero, tvFirstItemDNI, tvFirstItemApellido, tvFirstItemNombre, tvFirstItemCodigo;

        public RVFirstAdapterViewHolder(View itemView) {
            super(itemView);

            tvFirstItemEdad = (TextView) itemView.findViewById(R.id.tvFirstItemEdad);
            tvFirstItemGenero = (TextView) itemView.findViewById(R.id.tvFirstItemGenero);
            tvFirstItemDNI = (TextView) itemView.findViewById(R.id.tvFirstItemDNI);
            tvFirstItemApellido = (TextView) itemView.findViewById(R.id.tvFirstItemApellido);
            tvFirstItemNombre = (TextView) itemView.findViewById(R.id.tvFirstItemNombre);
            tvFirstItemCodigo = (TextView) itemView.findViewById(R.id.tvFirstItemCodigo);
        }
    }
}
