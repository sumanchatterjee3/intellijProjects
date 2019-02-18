package udemy.learnspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        logger.info("Guess The Number Game");

        //create the context first(Context)
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        //get Number Generator Bean from context (container)
        NumberGenerator numberGenerator = ctx.getBean("numberGenerator",NumberGenerator.class);


        //call method Next() to get a random number
        int number = numberGenerator.next();

        logger.info("Number Generated = {}",number);

        //get the game Bean from context(container)
        Game game = ctx.getBean(Game.class);

        //Commenting the reset method
        //game.reset();

        //close the container context
        ctx.close();

    }

}
