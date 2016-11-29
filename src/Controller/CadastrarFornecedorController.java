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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private ObservableList<Fornecedor> observableListFornecedores;
    @FXML
    private TextField txtPesquisa;
    
    ArrayList<Fornecedor> fornecedores;
    @FXML
    private TextField txtTelefoneFornecedor;
    @FXML
    private TextArea txtAnotacoes;
    
    boolean fornecedorCadastrado = false;
    String cnpjAntigo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencheComboBoxEstado();
        setEditableFalse();
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
        
        txtAnotacoes.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
            if (txtAnotacoes.getText().length() > 300) {
                String s = txtAnotacoes.getText().substring(0, 300);
                txtAnotacoes.setText(s);
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
        
        setEditableTrue();
        Fornecedor fornecedor = new Fornecedor();
                
        if(btnCadastrarFornecedor.getText().equals("Novo")){
            fornecedorCadastrado = false;
            setTextFieldText();
            btnCadastrarFornecedor.setText("Salvar");
        }else if(btnCadastrarFornecedor.getText().equals("Salvar")){
            fornecedor.setBairro(txtBairroFornecedor.getText());
            fornecedor.setCep(txtCepFornecedor.getText());
            fornecedor.setCidade(txtCidadeFornecedor.getText());
            fornecedor.setCnpj(txtCNPJFornecedor.getText());
            fornecedor.setComplemento(txtComplementoFornecedor.getText());
            fornecedor.setEstado(cbxEstadoFornecedor.getValue());
            fornecedor.setNome(txtNomeFornecedor.getText());
            fornecedor.setNomeFantasia(txtNomeFantasiaFornecedor.getText());
            fornecedor.setNumero(Integer.parseInt(txtNumeroFornecedor.getText()));
            fornecedor.setRua(txtRuaFornecedor.getText());
            fornecedor.setTelefone(txtTelefoneFornecedor.getText());
            fornecedor.setAnotacoes(txtAnotacoes.getText());
            setEditableFalse();
            
            if(fornecedorCadastrado == false){
                new FornecedorDAO().create(fornecedor);
            }else{
                new FornecedorDAO().update(fornecedor, cnpjAntigo);
            }
            btnCadastrarFornecedor.setText("Novo");
        }                              
        preencherTableView(new FornecedorDAO().selectByFantasyName(""));
        
        
    }
    
    private void setEditableFalse(){
        txtCNPJFornecedor.setEditable(false);
        txtNomeFornecedor.setEditable(false);
        txtNomeFantasiaFornecedor.setEditable(false);
        txtCepFornecedor.setEditable(false);
        txtTelefoneFornecedor.setEditable(false);
        txtRuaFornecedor.setEditable(false);
        txtNumeroFornecedor.setEditable(false);
        txtBairroFornecedor.setEditable(false);
        txtCidadeFornecedor.setEditable(false);
        txtComplementoFornecedor.setEditable(false);
        txtAnotacoes.setEditable(false);       
    }
    
    private void setEditableTrue(){
        txtCNPJFornecedor.setEditable(true);
        txtNomeFornecedor.setEditable(true);
        txtNomeFantasiaFornecedor.setEditable(true);
        txtCepFornecedor.setEditable(true);
        txtTelefoneFornecedor.setEditable(true);
        txtRuaFornecedor.setEditable(true);
        txtNumeroFornecedor.setEditable(true);
        txtBairroFornecedor.setEditable(true);
        txtCidadeFornecedor.setEditable(true);
        txtComplementoFornecedor.setEditable(true);
        txtAnotacoes.setEditable(true);       
    }
    
    private void setTextFieldText(){
        txtCNPJFornecedor.setText("");
        txtNomeFornecedor.setText("");
        txtNomeFantasiaFornecedor.setText("");
        txtCepFornecedor.setText("");
        txtTelefoneFornecedor.setText("");
        txtRuaFornecedor.setText("");
        txtNumeroFornecedor.setText("");
        txtBairroFornecedor.setText("");
        txtCidadeFornecedor.setText("");
        txtComplementoFornecedor.setText(""); 
        txtAnotacoes.setText("");        
        cbxEstadoFornecedor.getSelectionModel().clearSelection();
    }

    @FXML
    private void OnMouseClicked_tableViewFornecedor(MouseEvent event) 
    {
        try{            
            Fornecedor fornecedor = tableViewFornecedor.getSelectionModel().getSelectedItem();
            txtAnotacoes.setText(fornecedor.getAnotacoes());
            txtBairroFornecedor.setText(fornecedor.getBairro());
            txtCNPJFornecedor.setText(fornecedor.getCnpj());
            txtCepFornecedor.setText(fornecedor.getCep());
            txtCidadeFornecedor.setText(fornecedor.getCidade());
            txtComplementoFornecedor.setText(fornecedor.getComplemento());
            txtNomeFantasiaFornecedor.setText(fornecedor.getNomeFantasia());
            txtNomeFornecedor.setText(fornecedor.getNome());
            txtNumeroFornecedor.setText(Integer.toString(fornecedor.getNumero()));
            txtRuaFornecedor.setText(fornecedor.getRua());
            txtTelefoneFornecedor.setText(fornecedor.getTelefone());
            cbxEstadoFornecedor.setValue(fornecedor.getEstado());
            btnCadastrarFornecedor.setText("Novo");
            setEditableFalse();
            fornecedorCadastrado = true;
        }
        catch(Exception e)
        {
            
        }
    }

    @FXML
    private void btnEditarFornecedor_OnAction(ActionEvent event) {
        btnCadastrarFornecedor.setText("Salvar");
        setEditableTrue();
        fornecedorCadastrado = true;
        cnpjAntigo = txtCNPJFornecedor.getText();
    }

    @FXML
    private void btnRemoverFornecedor_OnAction(ActionEvent event) {
        new FornecedorDAO().delete(txtCNPJFornecedor.getText());
        preencherTableView(new FornecedorDAO().selectByFantasyName(""));
        setTextFieldText();
    }
}
