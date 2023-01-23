package mvc;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane primaryDesign;
    private ObservableList<ContatoLead> contatoLeadDados = FXCollections.observableArrayList();
    private ObservableList<ContatoCliente> contatoClienteDados = FXCollections.observableArrayList();

    public Main() {
        contatoLeadDados.add(new ContatoLead("teste", "macaco"));
        contatoClienteDados.add(new ContatoCliente("mamaco", "cacamo"));
    }

    public ObservableList<ContatoLead> getContatoLeadDados() {
        return contatoLeadDados;
    }
    
    public ObservableList<ContatoCliente> getContatoClienteDados() {
        return contatoClienteDados;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Agenda");

        initPrincipalDesign();
        mostrarDadosGerais();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void initPrincipalDesign() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("PrincipalDesign.fxml"));
            primaryDesign = (BorderPane) loader.load();

            Scene scene = new Scene(primaryDesign);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDadosGerais() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("DadosGerais.fxml"));
            AnchorPane dadosGerais = (AnchorPane) loader.load();

            primaryDesign.setCenter(dadosGerais);
            DadosGeraisController dg = loader.getController();
            dg.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean mostrarAlterar(ContatoLead contato) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("ContatoAlterar.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Dados do Contato");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ContatoAlterarController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setContato(contato);

            dialogStage.showAndWait();

            return controller.foiClicado();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void adicionarCliente(ContatoCliente contato){
        contatoClienteDados.add(contato);
    }
    
    public static float retornaSingleton(){
        Singleton singleton = Singleton.getInstance(5);
        return singleton.value;
    }

    public static void main(String[] args) {
        launch(args);             
    }
}
