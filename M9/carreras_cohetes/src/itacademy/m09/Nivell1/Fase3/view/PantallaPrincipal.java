package itacademy.m09.Nivell1.Fase3.view;

import itacademy.m09.Nivell1.Fase3.domain.Cohetes;
import java.awt.Color;
import javax.swing.JFrame;

public class PantallaPrincipal extends JFrame{

	PantallaDeCohete pantallaDeCohete1, pantallaDeCohete2;
	Cohetes cohetesUno, cohetesDos;
	PanelDeControl panelControl1;
	PanelDeControl panelControl2;
	
	public PantallaPrincipal(Cohetes coheteUno, Cohetes coheteDos) {
		
		this.cohetesUno = coheteUno;
		this.cohetesDos = coheteDos;
		
		this.setBounds(100, 100, 1070, 660);		

		setTitle("Plataforma de lanzamiento de Cohetes");

		/* instancio para cada cohetes una clase pantalla y otra de control */
		pantallaDeCohete1 = new PantallaDeCohete(coheteUno);
		pantallaDeCohete1.setBounds(0, 0, 500, 500);
		pantallaDeCohete1.setBackground(Color.WHITE);
		add(pantallaDeCohete1);

		pantallaDeCohete2 = new PantallaDeCohete(coheteDos);
		pantallaDeCohete2.setBounds(555, 0, 500, 500);
		pantallaDeCohete2.setBackground(Color.WHITE);
		add(pantallaDeCohete2);
		
		panelControl1 = new PanelDeControl(coheteUno);
		panelControl1.setBounds(0,500, 500, 120);
		this.add( panelControl1);
		
		panelControl2 = new PanelDeControl(coheteDos);
		panelControl2.setBounds(555,500, 500, 120);
		this.add( panelControl2);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
	}
}