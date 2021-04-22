
public class main {

	// TODO eventually we'll have to add tibia measurements, etc. Remember the
	// program actually takes measurements from a photo.
	public static int wingspan, torso, leg, height;

	public static void main(String[] args) {

		// Set leverages to random numbers for testing purposes
		wingspan = (int) (140 + 70 * Math.random());
		torso = (int) ((70 + 35 * Math.random()));
		leg = (int) (70 + 35 * Math.random());
		height = torso + leg;

		System.out.printf("%d %d %d %d \n", wingspan, torso, leg, height);

		// Calculate proportions
		int armLeverage = wingspan - height;
		if (armLeverage < 1) {
			System.out.println("You have short arms! " + armLeverage);
		} else if (armLeverage <= 5) {
			System.out.println("You have average arms! " + armLeverage);
		} else {
			System.out.println("You have long arms! " + armLeverage);
		}
		double legLeverage = (double) (leg) / height;
		if (legLeverage > 0.47) {
			System.out.println("You have long legs! " + legLeverage);
		} else if (legLeverage >= 0.44) {
			System.out.println("You have average legs! " + legLeverage);
		} else {
			System.out.println("You have short legs! " + legLeverage);
		}
	}

}
