package com.softannate.parcialtelloandreanatalia.ui.cargar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.softannate.parcialtelloandreanatalia.R;
import com.softannate.parcialtelloandreanatalia.ui.Auto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class cargar extends Fragment {
    private EditText etPatente, etMarca, etModelo, etPrecio;
    private Button btAgregar;

    // Lista estática para almacenar autos
   //public static ArrayList<Auto> listaAuto = new ArrayList<>();
    private CargarViewModel vm;

    //public static cargar newInstance() {
        //return new cargar();
    //}


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cargar, container, false);

        etPatente = view.findViewById(R.id.etPatente);
        etMarca = view.findViewById(R.id.etMarca);
        etModelo = view.findViewById(R.id.etModelo);
        etPrecio = view.findViewById(R.id.etPrecio);
        btAgregar = view.findViewById(R.id.btAgregar);

        vm = new ViewModelProvider(this).get(CargarViewModel.class);
        btAgregar.setOnClickListener(v -> agregarAuto());

        return view;
        //return inflater.inflate(R.layout.fragment_cargar, container, false);
    }
    private void agregarAuto() {
        String patente = etPatente.getText().toString().trim();
        String marca = etMarca.getText().toString().trim();
        String modelo = etModelo.getText().toString().trim();
        String precioStr = etPrecio.getText().toString().trim();

        String mensaje = vm.agregarAuto(patente, marca, modelo, precioStr);
        Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT).show();
        if (mensaje.equals("Auto agregado exitosamente")) {
            limpiarCampos();
        }
    }
    private void limpiarCampos() {
        etPatente.setText("");
        etMarca.setText("");
        etModelo.setText("");
        etPrecio.setText("");
    }

}