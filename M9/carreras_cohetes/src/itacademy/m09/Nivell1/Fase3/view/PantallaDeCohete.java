package itacademy.m09.Nivell1.Fase3.view;

import itacademy.m09.Nivell1.Fase3.domain.Cohetes;
import itacademy.m09.Nivell1.Fase3.domain.Propulsor;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


class PantallaDeCohete extends JPanel {
	
	public JLabel speed; 	
	JLabel nameLabel;
	Cohetes cohetes;
	
		public PantallaDeCohete(Cohetes cohetes) {
			
			this.cohetes = cohetes;
			setBounds(600, 0, 500, 500);			
			
			Font miFuente = new Font("Arial", Font.BOLD, 20);
			setLayout(null);				

			nameLabel = new JLabel( "ROCKET "+ cohetes.getCodigo(), SwingConstants.CENTER);
			nameLabel.setFont(miFuente);
			nameLabel.setForeground(Color.RED);
			nameLabel.setBounds(0, 0, 500, 100);				
			this.add(nameLabel);
			
			JLabel speedLabel = new JLabel("Velocidad: ", SwingConstants.RIGHT);
			speedLabel.setFont(miFuente);
			speedLabel.setForeground(Color.BLACK);
			speedLabel.setBounds(0, 100, 250, 50);			
			this.add(speedLabel);
			
			speed = new JLabel("0 Km/h", SwingConstants.LEFT);
			speed.setFont(miFuente);
			speed.setForeground(Color.BLACK);
			speed.setBounds(250, 100, 250, 50);		
			this.add(speed);
			
			JLabel tituloPropulsor= new JLabel("Propulsor " , SwingConstants.LEFT);
			tituloPropulsor.setFont(miFuente);
			tituloPropulsor.setForeground(Color.BLACK);
			tituloPropulsor.setBounds(10, 150 , 140, 50);
			this.add(tituloPropulsor);
			
			JLabel titPotencia= new JLabel("<html>Potencia<br> actual</html>" , SwingConstants.LEFT);
			titPotencia.setFont(miFuente);
			titPotencia.setForeground(Color.BLACK);
			titPotencia.setBounds(180, 150 , 150, 50);
			this.add(titPotencia);
			
			JLabel titMaxPotencia= new JLabel("<html>Potencia <br>máxima</html>" , SwingConstants.LEFT);
			titMaxPotencia.setFont(miFuente);
			titMaxPotencia.setForeground(Color.BLACK);
			titMaxPotencia.setBounds(330, 150 , 150, 50);
			this.add(titMaxPotencia);
			
			int x=0;  // 
			for(Propulsor propulsor: cohetes.getPropulsores()) {
//para cada propulsor de cada cohete instancio 3 JLabel para su numero, su actual potencia y su maxima potencia
				x++;
				JLabel  numeroPropulsor = new JLabel(x + " " , SwingConstants.CENTER);
				 numeroPropulsor.setFont(miFuente);
				 numeroPropulsor.setForeground(Color.BLACK);
				 numeroPropulsor.setBounds(0, 150 + x*50, 150, 50);
				this.add( numeroPropulsor);
				
				JLabel potenciaPropulsor = new JLabel(propulsor.getPotenciaActual() + " " , SwingConstants.CENTER);
				potenciaPropulsor.setFont(miFuente);
				potenciaPropulsor.setForeground(Color.BLACK);
				potenciaPropulsor.setBounds(150, 150 + x * 50, 150, 50);
				this.add( potenciaPropulsor);
				
				JLabel maxPotencia= new JLabel(propulsor.getPotenciaMaxima() + " " , SwingConstants.CENTER);
				maxPotencia.setFont(miFuente);
				maxPotencia.setForeground(Color.BLACK);
				maxPotencia.setBounds(300, 150 + x*50, 150, 50);				
				this.add(maxPotencia);
				
				propulsor.setLabel(potenciaPropulsor);
			}
			Runnable r = new ActualizarVelocidad();

			// instancio un hilo exclusivo que controlará (velocidad) el JLabel de "speed"
			Thread threadActVel = new Thread(r);
			threadActVel.start();								
			
			setVisible(true);       											  
  	}
		
		class ActualizarVelocidad implements Runnable{		
			
			public void run() {
				int  potenciaTotal,  potenciaTotal2;
				
				try {
					while(true) {
						
						potenciaTotal = 0;
						potenciaTotal2 = 0 ;

						// actualiza la velocidad cada  segundo
						Thread.sleep(1000);
						
						for (Propulsor p: cohetes.getPropulsores())  potenciaTotal += p.getPotenciaActual();
						cohetes.setSpeed(potenciaTotal);
						speed.setText(cohetes.getSpeed()+"Km/h");
					}	
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					System.out.println(" Fallo interrumpido la actualizacion");
				}
			}
		}		
}


