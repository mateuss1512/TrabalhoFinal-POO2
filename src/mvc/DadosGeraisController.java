package mvc;

import java.sql.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DadosGeraisController {

    @FXML
    private TableView<ContatoLead> contatoTabelaLead;
    @FXML
    private TableColumn<ContatoLead, String> nomeColunaLead;
    @FXML
    private TableColumn<ContatoLead, String> sobrenomeColunaLead;
    @FXML
    private TableView<ContatoCliente> contatoTabelaCliente;
    @FXML
    private TableColumn<ContatoCliente, String> nomeColunaCliente;
    @FXML
    private TableColumn<ContatoCliente, String> sobrenomeColunaCliente;
    @FXML
    private Label nomeLabel;
    @FXML
    private Label sobrenomeLabel;
    @FXML
    private Label ruaLabel;
    @FXML
    private Label codLabel;
    @FXML
    private Label cidadeLabel;
    @FXML
    private Label dataLabel;
    @FXML
    private Label labelDado;
    @FXML
    private Label labelValue;

    private Main main;

    public DadosGeraisController() {

    }

    @FXML
    public void initialize() {
        nomeColunaLead.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        sobrenomeColunaLead.setCellValueFactory(cellData -> cellData.getValue().sobrenomeProperty());
        dadosDetalhesLead(null);
        contatoTabelaLead.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> dadosDetalhesLead(newValue));
        
        nomeColunaCliente.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        sobrenomeColunaCliente.setCellValueFactory(cellData -> cellData.getValue().sobrenomeProperty());
        dadosDetalhesCliente(null);
        contatoTabelaCliente.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> dadosDetalhesCliente(newValue));
    }

    public void setMain(Main main) {
        this.main = main;

        contatoTabelaLead.setItems(main.getContatoLeadDados());
        contatoTabelaCliente.setItems(main.getContatoClienteDados());
    }

    public void dadosDetalhesLead(ContatoLead contato) {
        contatoTabelaCliente.getSelectionModel().clearSelection();
        if (contato != null) {
            nomeLabel.setText(contato.getNome());
            sobrenomeLabel.setText(contato.getSobrenome());
            ruaLabel.setText(contato.getRua());
            codLabel.setText(Integer.toString(contato.getCod()));
            cidadeLabel.setText(contato.getCidade());
            //dataLabel.setText("COMO Q CONVERTE ISSO");
            dataLabel.setText(ConverterData.formatar(contato.getData()));
            labelDado.setVisible(true);
            labelValue.setVisible(true);
            labelDado.setText("Origem");
            labelValue.setText(contato.getOrigem());
        } else {
            //System.out.println("ENTROU AQUIIIIII");
            nomeLabel.setText("");
            sobrenomeLabel.setText("");
            ruaLabel.setText("");
            codLabel.setText("");
            cidadeLabel.setText("");
            dataLabel.setText("");
            labelDado.setVisible(false);
            labelValue.setVisible(false);
        }
    }
    
    public void dadosDetalhesCliente(ContatoCliente contato) {
        contatoTabelaLead.getSelectionModel().clearSelection();
        if (contato != null) {
            nomeLabel.setText(contato.getNome());
            sobrenomeLabel.setText(contato.getSobrenome());
            ruaLabel.setText(contato.getRua());
            codLabel.setText(Integer.toString(contato.getCod()));
            cidadeLabel.setText(contato.getCidade());
            //dataLabel.setText("COMO Q CONVERTE ISSO");
            dataLabel.setText(ConverterData.formatar(contato.getData()));
            labelDado.setVisible(true);
            labelValue.setVisible(true);
            labelDado.setText("Valor Contrato");
            labelValue.setText(Float.toString(contato.getValorHoraContrato()));
        } else {
            //System.out.println("ENTROU AQUIIIIII");
            nomeLabel.setText("");
            sobrenomeLabel.setText("");
            ruaLabel.setText("");
            codLabel.setText("");
            cidadeLabel.setText("");
            dataLabel.setText("");
            labelDado.setVisible(false);
            labelValue.setVisible(false);
        }
    }

    @FXML
    private void deletar() {
        int con_del = contatoTabelaLead.getSelectionModel().getSelectedIndex();
        int con1_del = contatoTabelaCliente.getSelectionModel().getSelectedIndex();
        if (con_del >= 0) {
            contatoTabelaLead.getItems().remove(con_del);
        }else if(con1_del >= 0){
            contatoTabelaCliente.getItems().remove(con1_del);
        }else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Nenhum campo selecionado");
            alert.setHeaderText("NENHUM CONTATO FOI SELECIONADO");
            alert.setContentText("Selecione um contato antes de deletá-lo");
            alert.showAndWait();
        }
    }

    @FXML
    private void novoContato() {
        ContatoLead novo = new ContatoLead();
        boolean salvarClick;
        System.out.println("PASSOU AQUI");
        salvarClick = main.mostrarAlterar(novo);
        if (salvarClick) {
            System.out.println(" NÃO PASSOU AQUI");
            main.getContatoLeadDados().add(novo);
            //ou algo assim
            //String sql = "insert into contacts(name, phone_number, email, address, city, state) values(?,?,?,?,?,?)";
            //con.close();
            
        }
    }

    @FXML
    private void editar() {
        ContatoLead cont_selected = contatoTabelaLead.getSelectionModel().getSelectedItem();

        if (cont_selected != null) {
            boolean salvarClick;
            salvarClick = main.mostrarAlterar(cont_selected);
            if (salvarClick) {
                dadosDetalhesLead(cont_selected);
            }
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Nenhum campo selecionado");
            alert.setHeaderText("NENHUM CONTATO FOI SELECIONADO");
            alert.setContentText("Selecione um contato");

            alert.showAndWait();
        }
    }
    
    @FXML
    private void leadParaCliente(){
        ContatoLead cont_selected = contatoTabelaLead.getSelectionModel().getSelectedItem();
        if (cont_selected != null) {
            int con_del = contatoTabelaLead.getSelectionModel().getSelectedIndex();
            LeadClienteAdapter newContato = new LeadClienteAdapter(cont_selected);
            //System.out.println(newContato);
            main.adicionarCliente(newContato);
            contatoTabelaCliente.setItems(main.getContatoClienteDados());
            contatoTabelaLead.getItems().remove(con_del);
            dadosDetalhesLead(cont_selected);
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Nenhum campo selecionado");
            alert.setHeaderText("NENHUM LEAD FOI SELECIONADO");
            alert.setContentText("Selecione um lead");

            alert.showAndWait();
        }
    }
}
