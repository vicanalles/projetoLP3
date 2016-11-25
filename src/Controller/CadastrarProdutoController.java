package Controller;

import Model.DAO.ItemDAO;
import Model.DAO.ProdutoDAO;
import Model.Item;
import Model.Produto;
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
    private Label lblNumeroCodigoProduto;
    @FXML
    private Label lblNomeProduto;
    @FXML
    private TextField txtNomeProduto;
    @FXML
    private TableView<Produto> tableViewProdutos;
    @FXML
    private TableColumn<Produto, String> tableColumnProdutos;
    @FXML
    private TableView<Item> tableViewItensProduto;
    @FXML
    private TableColumn<Item, String> tableColumnItensProduto;
    @FXML
    private TableView<Item> tableViewItens;
    @FXML
    private TableColumn<Item, String> tableColumnItens;
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
    private ObservableList<Produto> observableListProdutos;
    private ObservableList<Item> observableListItensProduto;
    @FXML
    private TableColumn<Item, Float> tableColumnQuantidadeItemProduto;
    private TableColumn<Item, Float> tableColumnQuantidadeItem;
    @FXML
    private Button btnRemoverItensProduto;
    @FXML
    private TextField txtQuantidadeItem;
    
    private float valorTotalProduto = 0;
    ArrayList<Item> itens;
    boolean produtoCadastrado = true;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherTableViewItens(new ItemDAO().selectByName(""));
        preencherTableViewProdutos(new ProdutoDAO().selectByName(""));
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
        txtQuantidadeItem.setVisible(true);
        txtQuantidadeItem.setText("0");        
    }

    @FXML
    private void cadastrarProduto_OnAction(ActionEvent event)
    {
        txtValorTotalProduto.setText("0");
        if(btnNovoProduto.getText().equals("Novo"))
        {
            itens = new ArrayList<Item>();
            itens.clear();            
            lblNumeroCodigoProduto.setText(Integer.toString(new ProdutoDAO().getNextID()));
            txtNomeProduto.setText("");
            txtValorTotalProduto.setText("");
            tableViewItensProduto.getSelectionModel().clearSelection();
            btnNovoProduto.setText("Salvar");
            produtoCadastrado = false;
        }
        else if(btnNovoProduto.getText().equals("Salvar"))
        {
            Produto produto = new Produto();
            produto.setItens(itens);
            produto.setCodigo(Integer.parseInt(lblNumeroCodigoProduto.getText()));
            produto.setNome(txtNomeProduto.getText());
            produto.setValor(getValorTotalProduto());
            btnNovoProduto.setText("Novo");
            if(produtoCadastrado == false){
                new ProdutoDAO().create(produto);
            }else{
                new ProdutoDAO().update(produto);
            }
        }
        preencherTableViewProdutos(new ProdutoDAO().selectByName(""));
    }

    @FXML
    private void editarProduto_OnAction(ActionEvent event)
    {
        
    }

    @FXML
    private void removerProduto_OnAction(ActionEvent event)
    {
        new ProdutoDAO().delete(Integer.parseInt(lblNumeroCodigoProduto.getText()));
    }
    
    public void preencherTableViewItens(ArrayList<Item> itens)
    {        
        tableColumnItens.setCellValueFactory(new PropertyValueFactory<>("nome"));        
        
        observableListItens = FXCollections.observableArrayList(itens);
        
        tableViewItens.setItems(observableListItens);
    }
    
    public void preencherTableViewProdutos(ArrayList<Produto> produtos)
    {        
        tableColumnProdutos.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        observableListProdutos = FXCollections.observableArrayList(produtos);
        
        tableViewProdutos.setItems(observableListProdutos);
    }
    
    public void preencherTableViewItensProduto(ArrayList<Item> itensProduto)
    {        
        tableColumnItensProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));        
        tableColumnQuantidadeItemProduto.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        
        observableListItensProduto = FXCollections.observableArrayList(itensProduto);
        
        tableViewItensProduto.setItems(observableListItensProduto);
    }

    @FXML
    private void btnAdicionarItensProduto_OnAction(ActionEvent event) 
    {
        Item item = tableViewItens.getSelectionModel().getSelectedItem();        
        item.setQuantidade(Float.parseFloat(txtQuantidadeItem.getText()));
        itens.add(item);
        ObservableList<Item> observableListItens = FXCollections.observableArrayList(itens);
        tableViewItensProduto.setItems(observableListItens);
        preencherTableViewItensProduto(itens);        
        txtQuantidadeItem.setVisible(false);                       
        somarValorTotalProduto(item.getValorCompra() * Float.parseFloat(txtQuantidadeItem.getText()));
    }

    @FXML
    private void btnRemoverItensProduto_OnAction(ActionEvent event) 
    {
        
    }

    public float getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(float valorTotalProduto) {
        txtValorTotalProduto.setText(Float.toString(valorTotalProduto));
        this.valorTotalProduto = valorTotalProduto;
    }
    
    private void somarValorTotalProduto(float valor)
    {
        valor = (valor * 1.3f);
        this.valorTotalProduto += valor;
        txtValorTotalProduto.setText(Float.toString(this.valorTotalProduto));
    }
    
    private void subtrairValorTotalProduto(float valor)
    {
        this.valorTotalProduto -= valor;
        txtValorTotalProduto.setText(Float.toString(this.valorTotalProduto));
    }
}
