import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaTest {
    private Student mhs;
    @BeforeEach
    void init(){
        mhs = new Student("bobi",6,false);
    }

    @Test
    void testIsDoingMBKM(){
        Assertions.assertTrue(mhs.isDoingMBKM());
    }

}
