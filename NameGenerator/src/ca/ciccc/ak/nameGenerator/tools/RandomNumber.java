package ca.ciccc.ak.nameGenerator.tools;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumber {
	
	public static int draw(int f) {
		return draw(0, f);
	}
	
	public static int draw(int i, int f) {
		Random random = new Random();
		IntStream ints = random.ints(i, f);
		OptionalInt findFirst = ints.findFirst();
		return findFirst.getAsInt();
	}

}
