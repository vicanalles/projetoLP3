package Controller;

import Model.Cliente;
import Model.DAO.ConnectionFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;

public class CadastrarClienteController implements Initializable {   

    @FXML
    private AnchorPane anchorPaneCadastroCliente;
    @FXML
    private Label lblCadastroClientes;
    @FXML
    private Label lblNomeCliente;
    @FXML
    private TextField txtNomeCliente;
    @FXML
    private Label lblCpfCliente;
    @FXML
    private TextField txtCpfCliente;
    @FXML
    private Label lblDataNascimentoCliente;
    @FXML
    private TextField txtDataNascimentoCliente;
    @FXML
    private Label lblSexoCliente;
    @FXML
    private RadioButton rbtnClienteMasculino;
    @FXML
    private RadioButton rbtnClienteFeminino;
    @FXML
    private Label lblEmailCliente;
    @FXML
    private TextField txtEmailCliente;
    @FXML
    private Label lblTelefoneCliente;
    @FXML
    private TextField txtTelefoneCliente;
    @FXML
    private Label lblProdutoFavoritoCliente;
    @FXML
    private TextField txtProdutoFavoritoCliente;
    @FXML
    private Label lblRuaCliente;
    @FXML
    private TextField txtRuaCliente;
    @FXML
    private Label lblNumeroCliente;
    @FXML
    private TextField txtNumeroCliente;
    @FXML
    private Label lblBairroCliente;
    @FXML
    private TextField txtBairroCliente;
    @FXML
    private Label lblCidadeCliente;
    @FXML
    private TextField txtCidadeCliente;
    @FXML
    private Label lblEstadoCliente;
    @FXML
    private Label lblComplementoCliente;
    @FXML
    private TextField txtComplementoCliente;
    @FXML
    private Button btnCadastrarCliente;
    @FXML
    private Label lblCepCliente;
    @FXML
    private TextField txtCepCliente;
    @FXML
    private Button btnEditarCliente;
    @FXML
    private Button btnRemoverCliente;
    @FXML
    private TableView<?> tableViewClientes;
    @FXML
    private TableColumn<?, ?> tableColumnClientes;
    @FXML
    private ComboBox<String> cbxEstadoCliente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencheComboBoxEstado();
    }   
    
    public void preencheComboBoxEstado(){                
        cbxEstadoCliente.getItems().add("Acre - AC");
        cbxEstadoCliente.getItems().add("Alagoas - AL");
        cbxEstadoCliente.getItems().add("Amapá - AP");
        cbxEstadoCliente.getItems().add("Amazonas - AM");
        cbxEstadoCliente.getItems().add("Bahia - BA");
        cbxEstadoCliente.getItems().add("Ceará - CE");
        cbxEstadoCliente.getItems().add("Distrito Federal - DF");
        cbxEstadoCliente.getItems().add("Espírito Santo - ES");
        cbxEstadoCliente.getItems().add("Goiás - GO");
        cbxEstadoCliente.getItems().add("Maranhão - MA");
        cbxEstadoCliente.getItems().add("Mato Grosso - MT");
        cbxEstadoCliente.getItems().add("Mato Grosso do Sul - MS");
        cbxEstadoCliente.getItems().add("Minas Gerais - MG");
        cbxEstadoCliente.getItems().add("Pará - PA");
        cbxEstadoCliente.getItems().add("Paraíba - PB");
        cbxEstadoCliente.getItems().add("Paraná - PR");
        cbxEstadoCliente.getItems().add("Pernambuco - PE");
        cbxEstadoCliente.getItems().add("Piauí - PI");
        cbxEstadoCliente.getItems().add("Rio de Janeiro - RJ");
        cbxEstadoCliente.getItems().add("Rio Grande do Norte - RN");
        cbxEstadoCliente.getItems().add("Rio Grande do Sul - RS");
        cbxEstadoCliente.getItems().add("Rondônia - RO");
        cbxEstadoCliente.getItems().add("Roraima - RR");
        cbxEstadoCliente.getItems().add("Santa Catarina - SC");
        cbxEstadoCliente.getItems().add("São Paulo - SP");
        cbxEstadoCliente.getItems().add("Sergipe - SE");
        cbxEstadoCliente.getItems().add("Tocantins - TO");        
    }
}
