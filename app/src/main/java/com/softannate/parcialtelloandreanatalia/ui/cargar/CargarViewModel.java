package com.softannate.parcialtelloandreanatalia.ui.cargar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softannate.parcialtelloandreanatalia.MainActivity;
import com.softannate.parcialtelloandreanatalia.ui.Auto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CargarViewModel extends AndroidViewModel {

    private  MutableLiveData<ArrayList<Auto>> mAuto;
    private  ArrayList<Auto> listaAuto = new ArrayList<>();

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<Auto>> getAutos() {
        if(mAuto==null){
            mAuto=new MutableLiveData<>();
        }
        return mAuto;
    }
    public String agregarAuto(String patente, String marca, String modelo, String precioStr) {
        String mensajeError = validar(patente, marca, modelo, precioStr);
        if (mensajeError != null) {
            return mensajeError; // Retorna el mensaje de error específico
        }

        // Agregar auto si no hay errores
        double precio = Double.parseDouble(precioStr);
        Auto nuevoAuto = new Auto(patente, marca, modelo, precio);
        MainActivity.listaAutos.add(nuevoAuto);
        actualizarLista();

        return "Auto agregado exitosamente";
    }

    private String validar(String patente, String marca, String modelo, String precioStr) {
        // Validación de campos vacíos
        if (patente.isEmpty() || marca.isEmpty() || modelo.isEmpty() || precioStr.isEmpty()) {
            return "Error: Todos los campos deben ser llenados.";
        }

        // Validación de patente duplicada
        for (Auto auto : listaAuto) {
            if (auto.getPatente().equalsIgnoreCase(patente)) {
                return "Error: Patente ya ingresada.";
            }
        }

        // Validación de precio
        try {
            Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            return "Error: Precio inválido.";
        }

        return null; // Todo está bien
    }


    private void actualizarLista() {
        listaAuto.clear();  // Limpia la lista antes de actualizar
        listaAuto.addAll(MainActivity.listaAutos);  // Copia desde la lista estática
        if (mAuto != null) {
            mAuto.setValue(listaAuto);
        }
    }
}