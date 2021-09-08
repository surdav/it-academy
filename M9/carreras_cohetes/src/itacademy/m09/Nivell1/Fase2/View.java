package itacademy.m09.Nivell1.Fase2;

public class View {

	public static void main(String[] args) {

		Cohetes cohete1 = new Cohetes("32WESSDS");
		cohete1.addPropulsor(new Propulsor(10));
		cohete1.addPropulsor(new Propulsor(30));
		cohete1.addPropulsor(new Propulsor(80));

		Cohetes cohete2 = new Cohetes("LDSFJA32");
		cohete2.addPropulsor(new Propulsor(30));
		cohete2.addPropulsor(new Propulsor(40));
		cohete2.addPropulsor(new Propulsor(50));
		cohete2.addPropulsor(new Propulsor(50));
		cohete2.addPropulsor(new Propulsor(30));
		cohete2.addPropulsor(new Propulsor(10));

		System.out.println(cohete1);

		System.out.println(cohete2);

	}

}
