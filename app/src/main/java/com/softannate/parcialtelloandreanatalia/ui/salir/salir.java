package com.softannate.parcialtelloandreanatalia.ui.salir;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softannate.parcialtelloandreanatalia.R;
import com.softannate.parcialtelloandreanatalia.databinding.FragmentSalirBinding;


public class salir extends Fragment {
    private FragmentSalirBinding binding;

    public salir() {

    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mostrarDialogoConfSalir();
    }

    private void mostrarDialogoConfSalir(){
        new AlertDialog.Builder(requireContext()).setTitle("Confirmar salida")// título del diálogo
                .setMessage("¿Está seguro que desea salir?")// mensaje del diálogo
                .setPositiveButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        requireActivity().finish();
                    }
                }).setNegativeButton("Cancelar",null).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}