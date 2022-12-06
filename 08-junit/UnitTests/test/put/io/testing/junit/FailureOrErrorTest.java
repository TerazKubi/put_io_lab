package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FailureOrErrorTest {

    @Test
    public void test1(){
        Assertions.assertEquals(1, 2);
    }

    @Test
    public void test2(){
        int x = 1/0;

    }

    //pytanie 4.1
    //test1 zostanie oznaczona jako failure
    //test2 zostanie oznaczona jako error


    @Test
    public void test3(){
        try{
            Assertions.assertEquals(1, 2);
        } catch (Throwable t) {
            System.out.println(t.getClass());
        }
    }
    //pytanie 4.2
    // Junit oczekuje na klase Exception

}
