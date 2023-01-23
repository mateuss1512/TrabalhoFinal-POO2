package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.scene.control.Alert;

public class Conexao {

    /*ULTILIZANDO PADRÃO SINGLETON PARA UMA CONXEXÃO COM O BANCO DE DADOS 
    Ao invés de termos vários pontos no nosso projeto que geram conexões com 
    o banco de dados, podemos ter apenas uma classe singleton que realiza esta conexão
    otimizando a performance da aplicação.*/
    private Connection con;
    private String url = "jdbc:postgresql://localhost:5432/NOM DO BD";
    private String user = "postgresql";
    private String senha = "isadora";
    private static Conexao instancy; //recebe a instancia unica dessa classe

    public Conexao() {
        try {
            Class.forName("org.postgresql.Driver");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Banco de Dados");
            alert.setHeaderText("OK");
            alert.setContentText("CONEXÃO EFETUADA COM SUCESSO!!");

            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            this.con = DriverManager.getConnection(url, user, senha);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Banco de Dados");
            alert.setHeaderText("OK");
            alert.setContentText("CONEXÃO EFETUADA COM SUCESSO!!");

            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Conexao getInstancy() {
        if (instancy == null) {
            instancy = new Conexao();
        }
        return instancy;
    }

    public Connection getConexao() {
        return this.con;
    }

    public static void salvarContato(Contato contato) {
        try {
            Conexao cnx = Conexao.getInstancy();
            Connection con = cnx.getConexao();

            String sql = "insert into piriripororo";

            //System.out.println("nao passou");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void altContato(Contato contato) {
        try {
            Conexao cnx = Conexao.getInstancy();
            Connection con = cnx.getConexao();

            String sql = "alte table piriripororo";

            //System.out.println("nao passou");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dlContato(Contato contato) {
        try {
            Conexao cnx = Conexao.getInstancy();
            Connection con = cnx.getConexao();

            String sql = "deletar sla como q vai fazer isso";

            //System.out.println("nao passou");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
