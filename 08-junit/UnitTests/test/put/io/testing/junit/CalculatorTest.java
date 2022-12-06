package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    static Calculator calc;

    @BeforeAll
    public static void setUp(){
        calc = new Calculator();

        //pytanie 3.1
        //Zmieniajac adnotacje na BeforeAll testy przestaly by dzialac.
        //BeforeEach zostanie uruchomione przed kazdym testem
        //BeforeAll zostanie uruchomione raz przed wszystkimi testami
        //before all zadziala jesli zmienimy metode setUp i pole w klasie na statyczne

    }
    @Test
    public void testAdd(){
        int x = 10;
        int y = 12;
        int z = 5;


        Assertions.assertEquals(22, calc.add(x, y));
        Assertions.assertEquals(17, calc.add(z, y));

    }

    @Test
    public void testMultiply(){
        int x = 2;
        int y = 4;
        int z = 7;


        Assertions.assertEquals(8, calc.multiply(x, y));
        Assertions.assertEquals(28, calc.multiply(z, y));
    }

    @Test
    public void testAddPositiveNumbers(){
        int x = -2;
        int y = 10;


        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.addPositiveNumbers(x, y);
        });



    }

}