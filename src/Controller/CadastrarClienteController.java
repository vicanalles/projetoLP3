package Controller;

import Model.Cliente;
import Model.DAO.ClienteDAO;
import Model.DataHora;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

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
    private TableView<Cliente> tableViewClientes;
    @FXML
    private TableColumn<Cliente, String> tableColumnClientes;
    @FXML
    private ComboBox<String> cbxEstadoCliente;
    
    private ObservableList<Cliente> observableListClientes;
    @FXML
    private TextField txtPesquisar;
    
    ArrayList<Cliente> clientes;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencheComboBoxEstado();                
        
        preencherTableView(new ClienteDAO().selectByName(""));
        
        ToggleGroup toggleGroup = new ToggleGroup();
        
        rbtnClienteMasculino.setToggleGroup(toggleGroup);
        rbtnClienteFeminino.setToggleGroup(toggleGroup);
        
        txtPesquisar.setPromptText("Nome ou CPF");
        
        txtPesquisar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                String pesquisa = txtPesquisar.getText();
                long cpf;
                try
                {
                    cpf = Long.parseLong(pesquisa);
                    preencherTableView(new ClienteDAO().selectByCpf(pesquisa));
                }
                catch(Exception e)
                {
                    preencherTableView(new ClienteDAO().selectByName(pesquisa));
                }
            }
        });
    }   
    
    public void preencherTableView(ArrayList<Cliente> clientes)
    {        
        tableColumnClientes.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        observableListClientes = FXCollections.observableArrayList(clientes);
        
        tableViewClientes.setItems(observableListClientes);
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

    @FXML
    private void btnCadastrarCliente_OnAction(ActionEvent event)
    {
        Cliente cliente = new Cliente();
        
        cliente.setBairro(txtBairroCliente.getText());
        cliente.setCep(txtCepCliente.getText());
        cliente.setCidade(txtCidadeCliente.getText());
        cliente.setComplemento(txtComplementoCliente.getText());
        cliente.setCpf(txtCpfCliente.getText());
        try
        {
            cliente.setDataNasc(DataHora.converterData(txtDataNascimentoCliente.getText()));
        }
        catch (Exception ex)
        {
            Logger.getLogger(CadastrarClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cliente.setEmail(txtEmailCliente.getText());
        cliente.setEstado(Utilities.converterEstado(cbxEstadoCliente.getValue()));
        cliente.setNome(txtNomeCliente.getText());
        cliente.setNumero(Integer.parseInt(txtNumeroCliente.getText()));
        cliente.setProdutoFavorito(txtProdutoFavoritoCliente.getText());
        cliente.setRua(txtRuaCliente.getText());
        if(rbtnClienteMasculino.isSelected())
            cliente.setSexo("M");
        if(rbtnClienteFeminino.isSelected())
            cliente.setSexo("F");
        cliente.setTelefone(txtTelefoneCliente.getText());
        
        new ClienteDAO().create(cliente);
        
        preencherTableView(new ClienteDAO().selectByName(""));
    }
}
