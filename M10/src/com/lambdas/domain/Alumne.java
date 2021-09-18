package com.lambdas.domain;

public class Alumne {
    private String nom;
    private int edad;
    private String curs;
    private float nota;

    public Alumne(String nom, int edad, String curs, float nota) {
        this.nom = nom;
        this.edad = edad;
        this.curs = curs;
        this.nota = nota;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "nom='" + nom + '\'' +
                ", edad=" + edad +
                ", curs='" + curs + '\'' +
                ", nota=" + nota +
                '}';
    }
}
