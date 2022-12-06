package put.io.testing.audiobooks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    //pytanie 5.1
    //odpowiedz: whitebox


    //Pytanie 5.2
    // Odpowiedź: 4 ścieżki    C:

    private Audiobook audiobook;
    private AudiobookPriceCalculator calc;

    @BeforeEach
    public void setUp(){
        this.audiobook = new Audiobook("Kubuś puchatek", 11.50);
        this.calc = new AudiobookPriceCalculator();
    }

    @Test
    public void testAudiobookPriceCalculatorIsSubscriber(){

        Customer customer = new Customer("Patryk", Customer.LoyaltyLevel.STANDARD, true);

        Assertions.assertEquals(0.0, calc.calculate(customer, audiobook));
    }

    @Test
    public void testAudiobookPriceCalculatorSilver(){

        Customer customer = new Customer("Patryk", Customer.LoyaltyLevel.SILVER, false);

        Assertions.assertEquals(0.9 * audiobook.getStartingPrice(), calc.calculate(customer, audiobook));
    }

    @Test
    public void testAudiobookPriceCalculatorGold(){

        Customer customer = new Customer("Patryk", Customer.LoyaltyLevel.GOLD, false);

        Assertions.assertEquals(0.8 * audiobook.getStartingPrice(), calc.calculate(customer, audiobook));
    }

    @Test
    public void testAudiobookPriceCalculatorDefault(){

        Customer customer = new Customer("Patryk", Customer.LoyaltyLevel.STANDARD, false);

        Assertions.assertEquals(audiobook.getStartingPrice(), calc.calculate(customer, audiobook));
    }
}