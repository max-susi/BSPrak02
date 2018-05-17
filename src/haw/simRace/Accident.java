package haw.simRace;

import java.util.Random;

public class Accident extends Thread{
	
	@Override
	public void run() {
		try {
//			Thread.sleep(new Random().nextInt(Integer.MAX_VALUE));
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
		
	}

}
