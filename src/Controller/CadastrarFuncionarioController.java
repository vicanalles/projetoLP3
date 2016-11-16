package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CadastrarFuncionarioController implements Initializable {

    @FXML
    private AnchorPane anchorPaneCadastroFuncionario;
    @FXML
    private Label lblNomeFuncionario;
    @FXML
    private TextField txtNomeFuncionario;
    @FXML
    private Label lblCpfFuncionario;
    @FXML
    private TextField txtCpfFuncionario;
    @FXML
    private Label lblDataNascimentoFuncionario;
    @FXML
    private TextField txtDataNascimentoFuncionario;
    @FXML
    private Label lblSexoFuncionario;
    @FXML
    private RadioButton rbtnFuncionarioMasculino;
    @FXML
    private RadioButton rbtnFuncionarioFeminino;
    @FXML
    private Label lblEmailFuncionario;
    @FXML
    private TextField txtEmailFuncionario;
    @FXML
    private Label lblTelefoneFuncionario;
    @FXML
    private TextField txtTelefoneFuncionario;
    @FXML
    private Label lblFuncaoFuncionario;
    @FXML
    private TextField txtFuncaoFuncionario;
    @FXML
    private Label lblSalarioFuncionario;
    @FXML
    private TextField txtSalarioFuncionario;
    @FXML
    private Label lblCepFuncionario;
    @FXML
    private TextField txtCepFuncionario;
    @FXML
    private Label lblRuaFuncionario;
    @FXML
    private TextField txtRuaFuncionario;
    @FXML
    private Label lblNumeroFuncionario;
    @FXML
    private TextField txtNumeroFuncionario;
    @FXML
    private Label lblBairroFuncionario;
    @FXML
    private TextField txtBairroFuncionario;
    @FXML
    private Label lblCidadeFuncionario;
    @FXML
    private TextField txtCidadeFuncionario;
    @FXML
    private Label lblEstadoFuncionario;
    @FXML
    private Label lblComplementoFuncionario;
    @FXML
    private TextField txtComplementoFuncionario;
    @FXML
    private Button btnCadastrarFuncionario;
    @FXML
    private Label lblGerenciamentoFuncionarios;
    @FXML
    private Button btnEditarFuncionario;
    @FXML
    private Button btnRemoverFuncionario;
    @FXML
    private TableView<?> tableViewFuncionarios;
    @FXML
    private TableColumn<?, ?> tableColumnFuncionarios;
    @FXML
    private ComboBox<String> cbxEstadoFuncionario;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencheComboBoxEstado();
    }
    
    public void preencheComboBoxEstado(){                
        cbxEstadoFuncionario.getItems().add("Acre - AC");
        cbxEstadoFuncionario.getItems().add("Alagoas - AL");
        cbxEstadoFuncionario.getItems().add("Amapá - AP");
        cbxEstadoFuncionario.getItems().add("Amazonas - AM");
        cbxEstadoFuncionario.getItems().add("Bahia - BA");
        cbxEstadoFuncionario.getItems().add("Ceará - CE");
        cbxEstadoFuncionario.getItems().add("Distrito Federal - DF");
        cbxEstadoFuncionario.getItems().add("Espírito Santo - ES");
        cbxEstadoFuncionario.getItems().add("Goiás - GO");
        cbxEstadoFuncionario.getItems().add("Maranhão - MA");
        cbxEstadoFuncionario.getItems().add("Mato Grosso - MT");
        cbxEstadoFuncionario.getItems().add("Mato Grosso do Sul - MS");
        cbxEstadoFuncionario.getItems().add("Minas Gerais - MG");
        cbxEstadoFuncionario.getItems().add("Pará - PA");
        cbxEstadoFuncionario.getItems().add("Paraíba - PB");
        cbxEstadoFuncionario.getItems().add("Paraná - PR");
        cbxEstadoFuncionario.getItems().add("Pernambuco - PE");
        cbxEstadoFuncionario.getItems().add("Piauí - PI");
        cbxEstadoFuncionario.getItems().add("Rio de Janeiro - RJ");
        cbxEstadoFuncionario.getItems().add("Rio Grande do Norte - RN");
        cbxEstadoFuncionario.getItems().add("Rio Grande do Sul - RS");
        cbxEstadoFuncionario.getItems().add("Rondônia - RO");
        cbxEstadoFuncionario.getItems().add("Roraima - RR");
        cbxEstadoFuncionario.getItems().add("Santa Catarina - SC");
        cbxEstadoFuncionario.getItems().add("São Paulo - SP");
        cbxEstadoFuncionario.getItems().add("Sergipe - SE");
        cbxEstadoFuncionario.getItems().add("Tocantins - TO");        
    }
}
