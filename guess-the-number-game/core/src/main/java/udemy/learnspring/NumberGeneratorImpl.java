package udemy.learnspring;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    private final Random rand = new Random();

    private int maxNumber = 100;

    // == public methods ==
    @Override
    public int next() {
        return rand.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
