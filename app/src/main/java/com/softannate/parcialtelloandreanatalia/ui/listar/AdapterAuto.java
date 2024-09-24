package com.softannate.parcialtelloandreanatalia.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softannate.parcialtelloandreanatalia.R;
import com.softannate.parcialtelloandreanatalia.ui.Auto;

import java.util.ArrayList;
import java.util.List;

public class AdapterAuto extends RecyclerView.Adapter<AdapterAuto.ViewHolderAuto>{
    private ArrayList<Auto> listCar;
    private LayoutInflater inflater;


    public AdapterAuto(ArrayList<Auto> listCar) {
        this.listCar = listCar;

    }

    @NonNull
    @Override
    public ViewHolderAuto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_item, parent, false);
        return new ViewHolderAuto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAuto holder, int position) {
        Auto auto = listCar.get(position);
        holder.tvPatente.setText(auto.getPatente());
        holder.tvMarca.setText(auto.getMarca());
        holder.tvModelo.setText(auto.getModelo());
        holder.tvPrecio.setText(String.valueOf(auto.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return listCar.size();
    }

    public static class ViewHolderAuto extends RecyclerView.ViewHolder {
        TextView tvPatente, tvMarca, tvModelo, tvPrecio;

        public ViewHolderAuto(@NonNull View itemView) {
            super(itemView);
            tvPatente = itemView.findViewById(R.id.tvPatente);
            tvMarca = itemView.findViewById(R.id.tvMarca);
            tvModelo = itemView.findViewById(R.id.tvModelo);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
        }
    }

    // Método para actualizar la lista de autos
    public void setAutoList(ArrayList<Auto> listCar ) {
        this.listCar = listCar;
        notifyDataSetChanged();
    }
}