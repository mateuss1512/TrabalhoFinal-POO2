package mvc;

import java.sql.Connection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConexaoTest {

    public ConexaoTest() {
    }
    
    @Test
    public void testGetConexao() {
        System.out.println("getConnection");
        Conexao instance = new Conexao();
        Connection result = instance.getConexao();
        assertNotNull(result);
    }
}
