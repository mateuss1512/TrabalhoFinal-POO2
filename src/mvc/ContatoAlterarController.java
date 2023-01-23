package mvc;

import java.sql.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ContatoAlterarController {

    @FXML
    private TextField nomeField;
    @FXML
    private TextField sobrenomeField;
    @FXML
    private TextField ruaField;
    @FXML
    private TextField cidadeField;
    @FXML
    private TextField codField;
    @FXML
    private TextField dataField;
    @FXML
    private TextField origemField;

    private Stage dialogStage;
    private ContatoLead contato;
    private boolean salvarClick = false;

    @FXML
    public void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setContato(ContatoLead contato) {
        this.contato = contato;

        nomeField.setText(contato.getNome());
        sobrenomeField.setText(contato.getSobrenome());
        ruaField.setText(contato.getRua());
        cidadeField.setText(contato.getCidade());
        codField.setText(Integer.toString(contato.getCod()));
        dataField.setText(ConverterData.formatar(contato.getData()));
        dataField.setPromptText("dd.mm.yyyy");
        origemField.setText(contato.getOrigem());
        //--------------TALVEZ AQUI FIQUE MAIS FACIL USAR O BD SLA-----------------
        //Conexao cnx = Conexao.getInstancy();
        //Connection con = cnx.getConexao();

        //String sql = "insert into contato() values()";
        //Conexao.salvarContato(contato);
    }

    public boolean foiClicado() {
        return salvarClick;
    }

    @FXML
    private void salvar() {
        if (entradaValida()) {
            contato.setNome(nomeField.getText());
            contato.setSobrenome(sobrenomeField.getText());
            contato.setRua(ruaField.getText());
            contato.setCidade(cidadeField.getText());
            contato.setCod(Integer.parseInt(codField.getText()));
            contato.setData(ConverterData.passar(dataField.getText()));
            contato.setOrigem(origemField.getText());

            salvarClick = true;
            dialogStage.close();
        }
    }

    @FXML
    private void cancelar() {
        dialogStage.close();
    }

    private boolean entradaValida() {
        String mensagemErro = "";

        if (nomeField.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Nome inválido!!";
        }
        if (sobrenomeField.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Sobrenome inválido!!";
        }
        if (nomeField.getText().equals(sobrenomeField.getText()) || sobrenomeField.getText().equals(nomeField.getText())) {
            mensagemErro = mensagemErro + "Os campos nome e sobrenome devem ser diferentes!!";
        }
        if (ruaField.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Rua inválida!!";
        }
        if (cidadeField.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Cidade inválida!!";
        }
        if (codField.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Código postal inválido!!";
        } else {
            try {
                Integer.parseInt(codField.getText());
            } catch (NumberFormatException e) {
                mensagemErro = mensagemErro + "Código postal inválido deveria ser um número inteiro";
            }
        }
        if (dataField.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Data de nascimento inválida!!";
        } else {
            if (!ConverterData.valiData(dataField.getText())) {
                mensagemErro = mensagemErro + "Data de nascimento inválida use o formato dd.mm.yyyy";
            }
        }

        if (mensagemErro.isEmpty()) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Campos inválidos");
            alert.setHeaderText("Preencha de forma válida");
            alert.setContentText(mensagemErro);

            alert.showAndWait();

            return false;
        }
    }

}
