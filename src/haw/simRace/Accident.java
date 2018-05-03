package haw.simRace;

import java.util.Random;

public class Accident extends Thread{
	
	@Override
	public void run() {
		try {
			Thread.sleep(new Random().nextInt(Integer.MAX_VALUE));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
