package itacademy.m09.Nivell1.Fase1;

public class Cohetes {

	private String nom;
	private int propulsores;

	public Cohetes(String nom, int propulsores) {
		super();
		this.nom = nom;
		this.propulsores = propulsores;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPropulsores() {
		return propulsores;
	}

	public void setPropulsores(int propulsores) {
		this.propulsores = propulsores;
	}

	@Override
	public String toString() {
		return "Cohetes id=" + nom + ": Te " + propulsores + " propulsors";
	}

}
