package haw.simRace;

import java.util.Random;

public class Car extends Thread{
	
	private final int autoNummer;
	

	private int gesamtFahrzeit = 0;
	
	private int runde = 0;
	
	private int anzahlrunden;
		
	public Car(int autoNummer, int anzahlrunden) {
		this.autoNummer = autoNummer;
		this.anzahlrunden = anzahlrunden;
	}
	
	//radom zeit für runde
	private void fahreRunde() throws InterruptedException {
		int zufallszahl = new Random().nextInt(100); 
		gesamtFahrzeit += zufallszahl;
		System.out.println(toString() + "  Runde " + String.valueOf(runde));
		Thread.sleep((long)zufallszahl);
		runde++;
	}
	
	@Override
	public void run() {
		Accident accident = new Accident();
		accident.start();
		while (!zielerreicht()) {
			try {
				fahreRunde();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		interrupt();
	}
	
	public int getRunde() {
		return runde;
	}
	
	public int getAutoNummer() {
		return autoNummer;
	}
	
	public int getGesamtFahrzeit() {
		return gesamtFahrzeit;
	}
	
	
	@Override
	public String toString() {
		return "Wagen " + String.valueOf(autoNummer) + "  Zeit: " + String.valueOf(gesamtFahrzeit) ;
	}

	public boolean zielerreicht() {
		return runde == anzahlrunden;
	}
	
	

}
