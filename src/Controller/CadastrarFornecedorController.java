package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CadastrarFornecedorController implements Initializable {

    @FXML
    private AnchorPane anchorPaneFornecedores;
    @FXML
    private Label lblGerenciamentoFornecedores;
    @FXML
    private Label lblNomeFornecedor;
    @FXML
    private TextField txtNomeFornecedor;
    @FXML
    private Label lblNomeFantasiaFornecedor;
    @FXML
    private TextField txtNomeFantasiaFornecedor;
    @FXML
    private Label lblCepFornecedor;
    @FXML
    private TextField txtCepFornecedor;
    @FXML
    private Label lblRuaFornecedor;
    @FXML
    private TextField txtRuaFornecedor;
    @FXML
    private Label lblNumeroFornecedor;
    @FXML
    private TextField txtNumeroFornecedor;
    @FXML
    private Label lblBairroFornecedor;
    @FXML
    private TextField txtBairroFornecedor;
    @FXML
    private Label lblCidadeFornecedor;
    @FXML
    private TextField txtCidadeFornecedor;
    @FXML
    private Label lblEstadoFornecedor;
    @FXML
    private Label lblComplementoFornecedor;
    @FXML
    private TextField txtComplementoFornecedor;
    @FXML
    private Button btnCadastrarFornecedor;
    @FXML
    private Button btnEditarFornecedor;
    @FXML
    private Button btnRemoverFornecedor;
    @FXML
    private TableView<?> tableViewFornecedor;
    @FXML
    private TableColumn<?, ?> tableColumnFornecedor;
    @FXML
    private Label lblCNPJFornecedor;
    @FXML
    private TextField txtCNPJFornecedor;
    @FXML
    private ComboBox<String> cbxEstadoFornecedor;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencheComboBoxEstado();
    }    
    
    public void preencheComboBoxEstado(){                
        cbxEstadoFornecedor.getItems().add("Acre - AC");
        cbxEstadoFornecedor.getItems().add("Alagoas - AL");
        cbxEstadoFornecedor.getItems().add("Amapá - AP");
        cbxEstadoFornecedor.getItems().add("Amazonas - AM");
        cbxEstadoFornecedor.getItems().add("Bahia - BA");
        cbxEstadoFornecedor.getItems().add("Ceará - CE");
        cbxEstadoFornecedor.getItems().add("Distrito Federal - DF");
        cbxEstadoFornecedor.getItems().add("Espírito Santo - ES");
        cbxEstadoFornecedor.getItems().add("Goiás - GO");
        cbxEstadoFornecedor.getItems().add("Maranhão - MA");
        cbxEstadoFornecedor.getItems().add("Mato Grosso - MT");
        cbxEstadoFornecedor.getItems().add("Mato Grosso do Sul - MS");
        cbxEstadoFornecedor.getItems().add("Minas Gerais - MG");
        cbxEstadoFornecedor.getItems().add("Pará - PA");
        cbxEstadoFornecedor.getItems().add("Paraíba - PB");
        cbxEstadoFornecedor.getItems().add("Paraná - PR");
        cbxEstadoFornecedor.getItems().add("Pernambuco - PE");
        cbxEstadoFornecedor.getItems().add("Piauí - PI");
        cbxEstadoFornecedor.getItems().add("Rio de Janeiro - RJ");
        cbxEstadoFornecedor.getItems().add("Rio Grande do Norte - RN");
        cbxEstadoFornecedor.getItems().add("Rio Grande do Sul - RS");
        cbxEstadoFornecedor.getItems().add("Rondônia - RO");
        cbxEstadoFornecedor.getItems().add("Roraima - RR");
        cbxEstadoFornecedor.getItems().add("Santa Catarina - SC");
        cbxEstadoFornecedor.getItems().add("São Paulo - SP");
        cbxEstadoFornecedor.getItems().add("Sergipe - SE");
        cbxEstadoFornecedor.getItems().add("Tocantins - TO");        
    }
}
