package com.softannate.parcialtelloandreanatalia.ui.listar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softannate.parcialtelloandreanatalia.MainActivity;
import com.softannate.parcialtelloandreanatalia.R;
import com.softannate.parcialtelloandreanatalia.ui.Auto;

import java.util.ArrayList;

public class listar extends Fragment {

    private ListarViewModel vm;
    private RecyclerView rv;
    private AdapterAuto adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listar, container, false);
        rv = view.findViewById(R.id.rvAuto);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new AdapterAuto(new ArrayList<>());
        rv.setAdapter(adapter);

        vm = new ViewModelProvider(this).get(ListarViewModel.class);
        observarAutos();
        vm.setAutos(MainActivity.listaAutos);

        return view;
    }

    private void observarAutos() {
        vm.getAutos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Auto>>() {
            @Override
            public void onChanged(ArrayList<Auto> autos) {
                Log.d("ListarFragment", "Autos observados: " + autos.size());
                if (autos.size() > 0) {
                    adapter.setAutoList(autos);
                } else {
                    Log.d("ListarFragment", "No hay autos para mostrar.");
                }
            }
        });
    }

    public void setAutos(ArrayList<Auto> autos) {
        vm.setAutos(autos);
    }
}