import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator angka1;

    @BeforeEach
     void init() {
         angka1 = new Calculator(4,2);
    }
    @Test
    void testAdd(){
        Assertions.assertEquals(6, angka1.add(),"Add Method");
    }

    @Test
    void testKurang(){
        Assertions.assertEquals(2, angka1.kurang(),"Kurang Method");
    }

    @Test
    void testKali(){
        Assertions.assertEquals(8 ,angka1.kali(),"Kali Method");
    }

    @Test
    void testBagi(){
        Assertions.assertEquals(2, angka1.bagi(),"Bagi Method");
    }

    @Test
    void testAll(){
        Assertions.assertAll(
                ()->Assertions.assertEquals(5,angka1.kali()),
                ()->Assertions.assertNotNull(angka1.a)
        );
    }

    @Test
    void testSame(){
        Assertions.assertSame(2,angka1);
    }


}
