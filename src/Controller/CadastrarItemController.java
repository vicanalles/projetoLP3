package Controller;

import Model.DAO.ItemDAO;
import Model.Item;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class CadastrarItemController implements Initializable {

    @FXML
    private AnchorPane anchorPaneCadastrarItem;
    @FXML
    private Label lblGerenciamentoItens;
    @FXML
    private Label lblNumeroCodigoItens;
    @FXML
    private Label lblNomeItens;
    @FXML
    private TextField txtNomeItens;
    @FXML
    private Label lblQuantidadeItens;
    @FXML
    private TextField txtQuantidadeItens;
    @FXML
    private Label lblValorCompraItens;
    @FXML
    private TextField txtValorCompraItens;
    @FXML
    private Label lblDescricaoItens;
    @FXML
    private TextField txtDescricaoItens;
    @FXML
    private Button btnCadastrarItens;
    @FXML
    private Button btnEditarItens;
    @FXML
    private Button btnRemoverItens;
    @FXML
    private TableView<Item> tableViewItens;
    @FXML
    private TableColumn<Item, String> tableColumnItens;
    
    private ObservableList<Item> observableListItens;
    @FXML
    private TextField txtPesquisar;
    
    ArrayList<Item> itens;
    
    boolean editando = false;
    boolean itemCadastrado = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setEditableFalse();
        txtPesquisar.setPromptText("Nome ou Código");        
        txtPesquisar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                if(btnCadastrarItens.getText().equals("Salvar"))
                {
                    setEditableFalse();
                    btnCadastrarItens.setText("Novo Item");
                }
                String pesquisa = txtPesquisar.getText();
                int codigo;
                try
                {
                    codigo = Integer.parseInt(pesquisa);
                    ArrayList<Item> itens = new ArrayList<Item>();
                    itens.add(new ItemDAO().selectByCodigo(codigo));
                    preencherTableView(itens);
                }
                catch(Exception e)
                {
                    preencherTableView(new ItemDAO().selectByName(pesquisa));
                }
            }
        }); 
        
        preencherTableView(new ItemDAO().selectByName(""));
    }    
    
    public void preencherTableView(ArrayList<Item> itens)
    {        
        tableColumnItens.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        observableListItens = FXCollections.observableArrayList(itens);
        
        tableViewItens.setItems(observableListItens);
    }

    @FXML
    private void cadastrarItem(ActionEvent event) {
        setEditableTrue();
        
        //editando = true;
        Item item = new Item();
        if(btnCadastrarItens.getText().equals("Novo Item")){                            
            itemCadastrado = false;
            lblNumeroCodigoItens.setText(Integer.toString(new ItemDAO().getNextID()));
            txtNomeItens.setText("");
            txtDescricaoItens.setText("");
            txtQuantidadeItens.setText("");
            txtValorCompraItens.setText("");
            //editando = false;
            btnCadastrarItens.setText("Salvar");
            //itemCadastrado = true;
        }else if(btnCadastrarItens.getText().equals("Salvar")){
            item.setCodigo(Integer.parseInt(lblNumeroCodigoItens.getText()));
            item.setNome(txtNomeItens.getText());
            item.setQuantidade(Float.parseFloat(txtQuantidadeItens.getText()));
            item.setValorCompra(Float.parseFloat(txtValorCompraItens.getText()));
            item.setDescricao(txtDescricaoItens.getText());
            setTextFieldText();
            //editando = false;
            //itemCadastrado = true;
            if(itemCadastrado == false){                            
                new ItemDAO().create(item);
            }else{
                new ItemDAO().update(item);
            }   
            btnCadastrarItens.setText("Novo Item");
        }  
        preencherTableView(new ItemDAO().selectByName(""));        
    }

    @FXML
    private void OnMouseClicked_TableViewItens() {
        try{
            Item item = tableViewItens.getSelectionModel().getSelectedItem();
        
            lblNumeroCodigoItens.setText(Integer.toString(item.getCodigo()));
            txtNomeItens.setText(item.getNome());
            txtQuantidadeItens.setText(Float.toString(item.getQuantidade()));
            txtValorCompraItens.setText(Float.toString(item.getValorCompra()));
            txtDescricaoItens.setText(item.getDescricao());

            setEditableFalse();

            itemCadastrado = true;
            btnCadastrarItens.setText("Novo Item");
        }catch(Exception e){
            
        }
        
    }   

    @FXML
    private void OnMouseClicked_BtnEditarItens(MouseEvent event) {
        setEditableTrue();
        btnCadastrarItens.setText("Salvar");
        itemCadastrado = true;
    }

    @FXML
    private void removerItem(ActionEvent event) {        
        new ItemDAO().delete(Integer.parseInt(lblNumeroCodigoItens.getText()));
        setTextFieldText();
        preencherTableView(new ItemDAO().selectByName(""));
    }
    
    private void setEditableFalse()
    {
        txtDescricaoItens.setEditable(false);
        txtNomeItens.setEditable(false);
        txtQuantidadeItens.setEditable(false);
        txtValorCompraItens.setEditable(false);
    }
    
    private void setEditableTrue()
    {
        txtDescricaoItens.setEditable(true);
        txtNomeItens.setEditable(true);
        txtQuantidadeItens.setEditable(true);
        txtValorCompraItens.setEditable(true);
    }
    
    private void setTextFieldText()
    {
        lblNumeroCodigoItens.setText("");
        txtNomeItens.setText("");
        txtDescricaoItens.setText("");
        txtQuantidadeItens.setText("");
        txtValorCompraItens.setText("");
    }
}
