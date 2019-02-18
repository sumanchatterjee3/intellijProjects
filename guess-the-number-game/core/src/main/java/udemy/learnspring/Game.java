package udemy.learnspring;

public interface Game {
    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getRemainingGusses();

    void reset();

    void check();

    boolean isVaildNumberRange();

    boolean isGameWon();

    boolean isGameLost();
}
