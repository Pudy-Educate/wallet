import org.example.Calculator;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
    private  int res;

    @BeforeAll
    void setup(){
        System.out.println("before all");
    }
    @BeforeEach
    void setupMethod(){
        System.out.println("before method");
    }

    @AfterEach
    void setupEach(){
        System.out.println("after each");
    }
    @AfterAll
    void setupAll(){
        System.out.println("after all");
    }

    @Test
    @Order(1)
    void testAdd(){
        Calculator angka1 =new Calculator(4,2);
        res = angka1.add();
        Assertions.assertEquals(6, angka1.add(),"Add Method");
    }
    @Order(2)
    @Test
    void testKurang(){
        Calculator angka1 =new Calculator(res,5);

        Assertions.assertEquals(1, angka1.kurang(),"Kurang Method");
    }

//    @Test
//    void testKali(){
//        Assertions.assertEquals(8 ,angka1.kali(),"Kali Method");
//    }
//
//    @Test
//    void testBagi(){
//        Assertions.assertEquals(2, angka1.bagi(),"Bagi Method");
//    }
//
//    @Test
//    void testAll(){
//        Assertions.assertAll(
//                ()->Assertions.assertEquals(5,angka1.kali()),
//                ()->Assertions.assertNotNull(angka1.a)
//        );
//    }
//
//    @Test
//    void testSame(){
//        Assertions.assertSame(2,angka1);
//    }


}
