package haw.simRace;

import java.util.Random;

public class Car extends Thread{
	
	private final int autoNummer;
	

	private int gesamtFahrzeit = 0;
	
	private int runde = 0;
	
	private int anzahlrunden;

	private Accident accident = new Accident();
	public boolean hatteUnfall = false;
		
	public Car(int autoNummer, int anzahlrunden) {
		this.autoNummer = autoNummer;
		this.anzahlrunden = anzahlrunden;
	}
	
	//radom zeit fuer runde
	private void fahreRunde() throws InterruptedException {
		int zufallszahl = new Random().nextInt(100); 
		gesamtFahrzeit += zufallszahl;
		System.out.println(toString() + "  Runde " + String.valueOf(runde));
		Thread.sleep((long)zufallszahl);
		runde++;
	}
	
	@Override
	public void run() {
		accident.start();
		while (!zielerreicht() && !isInterrupted()) {
			try {
                fahreRunde();
                unfallErgeinis();
                if (hatteUnfall){
                    interrupt();
                }

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
		if (!accident.isInterrupted()) accident.interrupt();
		interrupt();
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

    public boolean isHatteUnfall() {
        return hatteUnfall;
    }

    @Override
	public String toString() {
		return "Wagen " + String.valueOf(autoNummer) + "  Zeit: " + String.valueOf(gesamtFahrzeit) ;
	}

	public boolean zielerreicht() {
		return runde == anzahlrunden;
	}
	
	public void unfallErgeinis(){
		if (!accident.isAlive()) {
			System.out.println("Unfall bei Wagen " + autoNummer + " in Runde " + runde);
			hatteUnfall = true;
		}
//		return false;
	}

}
