import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BigOTest {

    @Test
    @Order(0)
    void buffer() {
        assertEquals(1 ,1);
    }

    @Test
    @Order(1)
    void O_1() {
        assertEquals(40 ,BigO.O_1(20, 20));
    }

    @Test
    @Order(2)
    void O_LOG_N() {
        assertEquals(0, BigO.O_LOG_N(999999999));
    }

    @Test
    @Order(3)
    void O_N() {
        assertEquals(0, BigO.O_N(999999999));
    }

    @Test
    @Order(4)
    void O_N_LOG_N() {
        assertEquals(0, BigO.O_N_LOG_N(999999999));
    }

    @Test
    @Order(5)
    void O_N_2_KWADRAAT() {
        assertEquals(2250, BigO.O_N_2_KWADRAAT(12, 15));
    }
}