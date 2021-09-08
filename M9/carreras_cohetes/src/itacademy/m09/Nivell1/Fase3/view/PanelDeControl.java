package itacademy.m09.Nivell1.Fase3.view;

import itacademy.m09.Nivell1.Fase3.domain.Cohetes;
import itacademy.m09.Nivell1.Fase3.domain.Propulsor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

class PanelDeControl extends JPanel {
	
	int marcha = 1;
	JButton acelerar = new JButton("acelerar");
	JButton frenar = new JButton("frenar");
	JButton stop = new JButton("stop");
	Cohetes cohetes;

	public PanelDeControl(Cohetes cohetes) {
		
		this.cohetes = cohetes;
		setLayout(null);
		frenar.setEnabled(false);
		setBackground(Color.WHITE);
		Font fuente = new Font("Arial", Font.BOLD, 16);

		acelerar.addActionListener(e -> {
			acelerar.setEnabled(false);
			frenar.setEnabled(true);
			accionBotones(e);
		});
		acelerar.setBounds(100, 40, 100, 40);

		frenar.addActionListener(e -> {
			frenar.setEnabled(false);
			acelerar.setEnabled(true);
			accionBotones(e);
		});
		frenar.setBounds(300, 40, 100, 40);
		
		JLabel marchas = new JLabel("Marchas ", SwingConstants.CENTER);
		marchas.setFont(fuente);
		marchas.setForeground(Color.BLACK);
		marchas.setBounds(20, 10, 70, 20);
		this.add(marchas);
        
		// caja de selección de marcha
		String[] mach = { "X 1", "X 2", "X 3", "X 4", "X 5" };

		JList<String> listMarchas = new JList<>(mach);
		listMarchas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMarchas.setSelectedIndex(0);
		listMarchas.setFixedCellHeight(15);
		listMarchas.setFixedCellWidth(50);
		listMarchas.setVisibleRowCount(5);
		listMarchas.setBounds(30, 30, 50, 80);
		
		listMarchas.addListSelectionListener(e -> {
			JList list = (JList) e.getSource();

			// sumo 1 porque el array comienza con 0
			marcha = list.getSelectedIndex() + 1;
		});

		add(listMarchas); 
		add(acelerar);
		add(frenar);

		setVisible(true);
	}  // fin constructor de la clase PanelDeControl

	protected void accionBotones(ActionEvent e) {
		
// cada propulsor tiene su propia variable del tipo Thread que puede encargarse tanto de frenar como de acelerar
		
		if (e.getSource() == acelerar) {
			//cuando el acelerar viene desde el "cohetes 1
			for (Propulsor p : cohetes.getPropulsores()) {
				if (p.getThread() != null)
					p.getThread().interrupt();
				Runnable r = new threadAcelerarPropulsor(p);
				p.setThread(r);
				p.getThread().start();
			}
		}
		else if (e.getSource() == frenar) {

			for (Propulsor p : cohetes.getPropulsores()) {
				if (p.getThread() != null)
					p.getThread().interrupt();
				Runnable r = new threadFrenarPropulsor(p);
				p.setThread(r);
				p.getThread().start();
			}
		}		
	}
	
	class threadAcelerarPropulsor implements Runnable{
		Propulsor propulsor;
		
		public threadAcelerarPropulsor(Propulsor p) {
			propulsor = p;
			
		}

		public void run() {
			int x;				
			
			for (x = propulsor.getPotenciaActual(); x <= propulsor.getPotenciaMaxima(); x = x + marcha) {
				
				try {
					Thread.sleep(1000);
					propulsor.setPotenciaActual(x );
					propulsor.setTextLabel();						
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
			}
		}
	}
	
	static class threadFrenarPropulsor implements Runnable {
		Propulsor propulsor;

		public threadFrenarPropulsor(Propulsor p) {
			propulsor = p;
		}

		public void run() {
			int x;				
			
			for (x = propulsor.getPotenciaActual(); x >= 0; x--) {
				
				try {
					Thread.sleep(500);
					propulsor.setPotenciaActual(x);
					propulsor.setTextLabel();					
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
			}
		}
	}
}