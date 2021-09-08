package itacademy.m09.Nivell1.Fase2;

public class Propulsor {

	private int potenciaMaxima;

	public Propulsor(int potenciaMaxima) {
		super();
		this.potenciaMaxima = potenciaMaxima;
	}

	public int getPotenciaMaxima() {
		return potenciaMaxima;
	}

	public void setPotenciaMaxima(int potenciaMaxima) {
		this.potenciaMaxima = potenciaMaxima;
	}

	@Override
	public String toString() {
		return "" + potenciaMaxima + "";
	}

}
