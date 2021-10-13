package com.itacademy.CrudEmpleats.domain;

public enum Jobs {
	
	// Enum que define nombre del cargo y sueldo
	
	Director_Proyectos("Director de proyectos", 70000),
	Programador_Senior("Programador Senior", 37000),
	Programador_Mid("Programador Mid-Level", 29000),
	Programador_Junior("Programador Junior", 22000),
	Administrativo("Administrativo", 19000);

	private final String name;
	private final double salary;
	
	Jobs(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
	
	
	
	

	
}
