package Controller;

import Model.DAO.FornecedorDAO;
import Model.Fornecedor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Fornecedor> tableViewFornecedor;
    @FXML
    private TableColumn<Fornecedor, String> tableColumnFornecedor;
    @FXML
    private Label lblCNPJFornecedor;
    @FXML
    private TextField txtCNPJFornecedor;
    @FXML
    private ComboBox<String> cbxEstadoFornecedor;
    @FXML
    private ObservableList<Fornecedor> observableListFornecedores;
    @FXML
    private TextField txtPesquisa;
    
    ArrayList<Fornecedor> fornecedores;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencheComboBoxEstado();
        
        preencherTableView(new FornecedorDAO().selectByFantasyName(""));
        
        txtPesquisa.setPromptText("NomeFantasia ou CNPJ");
        txtPesquisa.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                String pesquisa = txtPesquisa.getText();
                long cnpj;
                try
                {
                    cnpj = Long.parseLong(pesquisa);
                    ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
                    fornecedores.add(new FornecedorDAO().selectOneByCnpj(pesquisa));
                    preencherTableView(fornecedores);
                }
                catch(Exception e)
                {
                    preencherTableView(new FornecedorDAO().selectByFantasyName(pesquisa));
                }
            }
        });
     }
          
    
    public void preencherTableView(ArrayList<Fornecedor> fornecedores)
    {        
        tableColumnFornecedor.setCellValueFactory(new PropertyValueFactory<>("nomeFantasia"));
        
        observableListFornecedores = FXCollections.observableArrayList(fornecedores);
        
        tableViewFornecedor.setItems(observableListFornecedores);
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

    @FXML
    private void cadastrarFornecedor(ActionEvent event) {
        
        Fornecedor fornecedor = new Fornecedor();
                
        fornecedor.setBairro(txtBairroFornecedor.getText());
        fornecedor.setCep(txtCepFornecedor.getText());
        fornecedor.setCidade(txtCidadeFornecedor.getText());
        fornecedor.setCnpj(txtCNPJFornecedor.getText());
        fornecedor.setComplemento(txtComplementoFornecedor.getText());
        fornecedor.setEstado(Utilities.converterParaSigla(cbxEstadoFornecedor.getValue()));
        fornecedor.setNome(txtNomeFornecedor.getText());
        fornecedor.setNomeFantasia(txtNomeFantasiaFornecedor.getText());
        fornecedor.setNumero(Integer.parseInt(txtNumeroFornecedor.getText()));
        fornecedor.setRua(txtRuaFornecedor.getText());
        
        new FornecedorDAO().create(fornecedor);        
        
        preencherTableView(new FornecedorDAO().selectByFantasyName(""));
        
        
    }
    
    
}
