package com.softannate.parcialtelloandreanatalia.ui;

import java.io.Serializable;

public class Auto implements Serializable{
        private String patente;
        private String marca;
        private String modelo;
        private double precio;

        public Auto(String patente, String marca, String modelo, double precio) {
            this.patente = patente;
            this.marca = marca;
            this.modelo = modelo;
            this.precio = precio;
        }

        // Getters
        public String getPatente() { return patente; }
        public String getMarca() { return marca; }
        public String getModelo() { return modelo; }
        public double getPrecio() { return precio; }
    }


