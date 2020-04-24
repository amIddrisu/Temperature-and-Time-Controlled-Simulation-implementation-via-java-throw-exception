import java.util.concurrent.TimeUnit;

public class IdealTemperature {

	public static final double TooHot = 85;
	public static final double TooCold = 10;

	public static void tempSetting() {
		System.out.println("<<<---Hello and Weclome to Lab Testing Simulation--->>>");
		System.out.println("--->All temperature figures are in Degree Celcius");
	}

	public static void testingTemp(double roomTemp) throws TooColdException, TooHotException {

		if (roomTemp <= TooCold) {
			throw new TooColdException();

		} else if (roomTemp >= TooHot) {
			throw new TooHotException();

		}
	}

	public static void main(String[] args) throws TooHotException, TooColdException, InterruptedException {
		double currentTemp = 90;
		boolean wrongTemp = true;
		
		tempSetting();
		System.out.println();
		
		while (wrongTemp) {
			try {
				testingTemp(currentTemp);
				System.out.println("This temperature is ideal for the lab simulation");
				wrongTemp = false;
			} catch (TooHotException e1) {
				System.out.println("The temperature is too hot for a successfull lab simulation ");
				currentTemp = currentTemp - 5;

			} catch (TooColdException e2) {
				System.out.println("The current Temperature is too cold to carry out the experiment");
				currentTemp = currentTemp + 5;
			}
			TimeUnit.SECONDS.sleep(2);
		}
		System.out.println("The Time Exception Simulations have been excuted successfully");
	}
}
