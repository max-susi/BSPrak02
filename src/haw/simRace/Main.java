package haw.simRace;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    static boolean abgebrochen = false;

    public static void main(String[] args) {
        int runden = 5;
        int anzahlAutos = 5;

        List<Car> autosListe = new ArrayList<>();

        for (int i = 0; i < anzahlAutos; i++) {
            Car tempCar = new Car(i, runden);
            autosListe.add(tempCar);
            tempCar.start();
        }

        while (!istRennenEnde(autosListe)) {
        }

        if (!abgebrochen) {
            System.out.println("**** Endstand ****");
            autosListe.sort(new Comparator<Car>() {

                @Override
                public int compare(Car o1, Car o2) {
                    return Integer.compare(o1.getGesamtFahrzeit(), o2.getGesamtFahrzeit());
                }

            });
            for (Car car : autosListe) {
                System.out.println(car.toString());
            }
        }
    }

    private static boolean istRennenEnde(List<Car> autosListe) {

        for (Car car : autosListe) {
            if (!car.zielerreicht()) {
                if (car.hatteUnfall) {
                    rennAbbruch(autosListe);
                    return true;
                }
//				System.out.println(car.toString() + " noch nicht fertig!!!");
                return false;

            }
        }
        System.out.println("Rennen vorbei!!!!!");
        return true;
    }

    private static void rennAbbruch(List<Car> autosListe) {
        System.out.println("Abbruch des Rennens!");
        abgebrochen = true;
        for (Car car : autosListe) {
            car.interrupt();
        }
    }
}
