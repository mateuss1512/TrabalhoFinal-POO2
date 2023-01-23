package mvc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContatoTest {
    
    public ContatoTest() {
    }

    @Test
    public void testcodProperty() {
        int esperado = 5;
        int obtido = 6;
        assertEquals(esperado, obtido);
    }
    
}
