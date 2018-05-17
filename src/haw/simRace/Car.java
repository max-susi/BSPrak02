package haw.simRace;

import java.util.Random;

public class Car extends Thread {

	private final int autoNummer;

	private int gesamtFahrzeit = 0;

	private int runde = 1;

	private int anzahlrunden;

	public boolean hatteUnfall = false;

	private Accident accident;

	public Car(int autoNummer, int anzahlrunden, Accident accident) {
		this.autoNummer = autoNummer;
		this.anzahlrunden = anzahlrunden;
		this.accident = accident;
	}

	// radom zeit fuer runde
	private void fahreRunde() throws InterruptedException {

			int zufallszahl = new Random().nextInt(100);
			gesamtFahrzeit += zufallszahl;
			System.out.println(toString() + "  Runde " + String.valueOf(runde));
			Thread.sleep((long) zufallszahl);
			runde++;
	}

	@Override
	public void run() {
		while (!zielerreicht()) {
			try {
					fahreRunde();
			} catch (InterruptedException e) {
				return;
			}
		}
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
		return "Wagen " + String.valueOf(autoNummer) + "  Zeit: " + String.valueOf(gesamtFahrzeit);
	}

	public boolean zielerreicht() {
		return runde == anzahlrunden + 1;
	}

}
