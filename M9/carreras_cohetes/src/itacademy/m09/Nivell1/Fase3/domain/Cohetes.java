package itacademy.m09.Nivell1.Fase3.domain;

import java.util.ArrayList;
import java.util.List;

public class Cohetes {

	private final String codigo;
	private final List<Propulsor> propulsores = new  ArrayList<>();
	private double speed=0;
	
	public Cohetes(String cod, int[] prop ) {
		
		codigo = cod;				
		for(Integer potencia:prop) {
			propulsores.add(new Propulsor(potencia));
			
		}				
	}		

	public void setSpeed(int potenciaTotal) {
		speed =  100 * Math.sqrt(potenciaTotal);
	}


	public String getCodigo() {
		return codigo;
	}


	public List<Propulsor> getPropulsores() {
		return propulsores;
	}


	public int getSpeed() {
		return (int)speed;
	}	
	
}
