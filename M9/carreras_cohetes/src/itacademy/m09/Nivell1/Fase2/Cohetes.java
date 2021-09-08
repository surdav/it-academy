package itacademy.m09.Nivell1.Fase2;

import java.util.ArrayList;

public class Cohetes {

	private String nom;
	private final ArrayList<Propulsor> propulsores;

	public Cohetes(String nom) {
		super();
		this.nom = nom;
		this.propulsores = new ArrayList<>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void addPropulsor(Propulsor p) {
		if (p != null)
			this.propulsores.add(p);
	}

	public int getNumerosPropulsores() {
		int result = 0;

		if (this.propulsores != null)
			result = this.propulsores.size();

		return result;
	}
	
	
	@Override
	public String toString() {
		return "Cohetes id=" + nom + "\n" + "Potència Màxima propulsors: " + propulsores.toString();
	}

}
