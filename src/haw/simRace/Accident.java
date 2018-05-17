package haw.simRace;

import java.util.List;
import java.util.Random;

public class Accident extends Thread {

	private List<Car> autoListe;

	public Accident(List<Car> autosListe) {
		this.autoListe = autosListe;
	}

	@Override
	public void run() {
		try {
			// Thread.sleep(new Random().nextInt(Integer.MAX_VALUE));
			Thread.sleep(new Random().nextInt(700));
		} catch (InterruptedException e) {
			return;
		}
		System.out.println("aaaaaahhhhh unfall");
		Main.abgebrochen = true;
		for (Car car : autoListe) {
			car.interrupt();
		}
		System.out.println("Abbruch des Rennens!");
	}

}
