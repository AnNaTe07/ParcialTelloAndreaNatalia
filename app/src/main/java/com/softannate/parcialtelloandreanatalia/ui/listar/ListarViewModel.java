package com.softannate.parcialtelloandreanatalia.ui.listar;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softannate.parcialtelloandreanatalia.MainActivity;
import com.softannate.parcialtelloandreanatalia.ui.Auto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListarViewModel extends AndroidViewModel {
    private  MutableLiveData<ArrayList<Auto>> mAutoL;
    private  ArrayList<Auto> listaAuto = new ArrayList<>();

    public ListarViewModel(Application application) {
        super(application);
        mAutoL = new MutableLiveData<>(new ArrayList<>());
    }

    public void setAutos(ArrayList<Auto> autos) {
        if (autos != null) {
            Log.d("ListarViewModel", "Autos recibidos: " + autos.size());
            listaAuto.clear();
            listaAuto.addAll(autos);
            ordenarAutosPorPrecio();
            mAutoL.setValue(listaAuto);
        }
    }

    private void ordenarAutosPorPrecio() {
        Collections.sort(listaAuto, new Comparator<Auto>() {
            @Override
            public int compare(Auto a1, Auto a2) {
                return Double.compare(a2.getPrecio(), a1.getPrecio());
            }
        });
    }

    public LiveData<ArrayList<Auto>> getAutos() {
        if(mAutoL==null){
            mAutoL=new MutableLiveData<>();
        }
        return mAutoL;
    }
}