package eidi2.sose25.weber.felix.sheet01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdditionTest {

    @Test
    public void testAddition() {
        int a = 5;
        int b = 6;
        int excepted = 11;
        int method = Addition.add(a, b);

        Assertions.assertEquals(excepted, method);
    }

}
