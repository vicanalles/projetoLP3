package Controller;

import Model.Cliente;
import Model.DAO.ClienteDAO;
import Model.DAO.FuncionarioDAO;
import Model.DataHora;
import Model.Funcionario;
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
    private TableView<Funcionario> tableViewFuncionarios;
    @FXML
    private TableColumn<Funcionario, String> tableColumnFuncionarios;
    @FXML
    private ComboBox<String> cbxEstadoFuncionario;
    
    private ObservableList<Funcionario> observableListFuncionarios;
    @FXML
    private TextField txtPesquisa;
    
    ArrayList<Funcionario> funcionarios;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencheComboBoxEstado();
        
        preencherTableView(new FuncionarioDAO().selectByName(""));
        
        ToggleGroup toggleGroup = new ToggleGroup();
        
        rbtnFuncionarioMasculino.setToggleGroup(toggleGroup);
        rbtnFuncionarioFeminino.setToggleGroup(toggleGroup);
        
        txtPesquisa.setPromptText("Nome ou CPF");
        
        txtPesquisa.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                String pesquisa = txtPesquisa.getText();
                long cpf;
                try
                {
                    cpf = Long.parseLong(pesquisa);
                    ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
                    funcionarios.add(new FuncionarioDAO().selectByCpf(pesquisa));
                    preencherTableView(funcionarios);
                }
                catch(Exception e)
                {
                    preencherTableView(new FuncionarioDAO().selectByName(pesquisa));
                }
            }
        });
    }
    
    public void preencherTableView(ArrayList<Funcionario> funcionarios)
    {        
        tableColumnFuncionarios.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        observableListFuncionarios = FXCollections.observableArrayList(funcionarios);
        
        tableViewFuncionarios.setItems(observableListFuncionarios);
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

    @FXML
    private void cadastrarFuncionario(ActionEvent event) {
        
        Funcionario funcionario = new Funcionario();
        
        funcionario.setBairro(txtBairroFuncionario.getText());
        funcionario.setCep(txtCepFuncionario.getText());
        funcionario.setCidade(txtCidadeFuncionario.getText());
        funcionario.setComplemento(txtComplementoFuncionario.getText());
        funcionario.setCpf(txtCpfFuncionario.getText());
        try
        {
            funcionario.setDataNasc(DataHora.converterData(txtDataNascimentoFuncionario.getText()));
        }
        catch (Exception ex)
        {
            Logger.getLogger(CadastrarFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        funcionario.setEmail(txtEmailFuncionario.getText());
        funcionario.setEstado(Utilities.converterEstado(cbxEstadoFuncionario.getValue()));
        funcionario.setNome(txtNomeFuncionario.getText());
        funcionario.setNumero(Integer.parseInt(txtNumeroFuncionario.getText()));
        funcionario.setFuncao(txtFuncaoFuncionario.getText());
        funcionario.setSalario(Float.parseFloat(txtSalarioFuncionario.getText()));
        funcionario.setRua(txtRuaFuncionario.getText());
        if(rbtnFuncionarioMasculino.isSelected())
            funcionario.setSexo("M");
        if(rbtnFuncionarioFeminino.isSelected())
            funcionario.setSexo("F");
        funcionario.setTelefone(txtTelefoneFuncionario.getText());
        
        new FuncionarioDAO().create(funcionario);
        
        preencherTableView(new FuncionarioDAO().selectByName(""));
    }
}
