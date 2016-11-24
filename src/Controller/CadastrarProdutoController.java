package Controller;

import Model.Item;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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

public class CadastrarProdutoController implements Initializable {

    @FXML
    private AnchorPane anchorPaneCadastrarProduto;
    @FXML
    private Label lblGerenciamentoProdutos;
    @FXML
    private Label lblCodigoProduto;
    @FXML
    private Label lblNumeroCodigoProduto;
    @FXML
    private Label lblNomeProduto;
    @FXML
    private TextField txtNomeProduto;
    @FXML
    private TableView<?> tableViewProdutos;
    @FXML
    private TableColumn<?, ?> tableColumnProdutos;
    @FXML
    private TableView<?> tableViewItensProduto;
    @FXML
    private TableColumn<?, ?> tableColumnItensProduto;
    @FXML
    private TableView<?> tableViewItens;
    @FXML
    private TableColumn<?, ?> tableColumnItens;
    @FXML
    private Button btnAdicionarItensProduto;
    @FXML
    private Label lblValorTotalProduto;
    @FXML
    private TextField txtValorTotalProduto;
    @FXML
    private Button btnNovoProduto;
    @FXML
    private Button btnEditarProduto;
    @FXML
    private Button btnRemoverProduto;
    
    private ObservableList<Item> observableListItens;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void tableViewProdutos_OnClick(MouseEvent event)
    {
        
    }

    @FXML
    private void tableViewItensProduto_OnClick(MouseEvent event)
    {
    }

    @FXML
    private void tableViewItens_OnClick(MouseEvent event)
    {
    }

    @FXML
    private void cadastrarProduto_OnAction(ActionEvent event)
    {
    }

    @FXML
    private void editarProduto_OnAction(ActionEvent event)
    {
    }

    @FXML
    private void removerProduto_OnAction(ActionEvent event)
    {
    }
    
    public void preencherTableView(ArrayList<Item> itens)
    {        
        tableColumnItens.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        observableListItens = FXCollections.observableArrayList(itens);
        
        tableViewItens.setItems(observableListItens);
    }
}
