package udemy.learnspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class GameImpl implements Game {

    // ==Constants==
    private static final Logger logger = LoggerFactory.getLogger(GameImpl.class);

    //==Fields==
    private NumberGenerator numberGenerator;
    private int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int largest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    //==init==
    @PostConstruct
    @Override
    public void reset() {
        number = numberGenerator.next();
        guess = 0;
        smallest = 0;
        largest = numberGenerator.getMaxNumber();
        remainingGuesses = guessCount;
        logger.debug("The Number Generated in the Game is: {}", number);
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("In game preDestroy()..");
    }



    /*
    // == Constructors for setting constructor based dependency injection  Option 1==
    public GameImpl(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

*/
    // == creating setter based dependency injection Option 2==
    public void setNumberGenerator(NumberGenerator numberGenerator){
        this.numberGenerator = numberGenerator;
    }



    //==Public Methods==
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;

    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return largest;
    }

    @Override
    public int getRemainingGusses() {
        return remainingGuesses;
    }


    @Override
    public boolean isVaildNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }


    //==Private Methods==
    @Override
    public void check() {
        checkValidNumberRange();
        if (validNumberRange) {
            if (guess > number) {
                largest = guess - 1;
            }
            if (guess < number) {
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= largest);
    }
}
