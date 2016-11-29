package Controller;

import Model.Cliente;
import Model.DAO.ClienteDAO;
import Model.DAO.ItemDAO;
import Model.DAO.ItemProdutoDAO;
import Model.DAO.ProdutoDAO;
import Model.Item;
import Model.Produto;
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
    @FXML
    private TextField txtPesquisar;
        
    @FXML
    private TextField txtPesquisarItens;
    
    ArrayList<Item> itensProduto;
    private float valorTotalProduto = 0;
    ArrayList<Item> itens;
    boolean produtoCadastrado = true;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        setEditableFalse();
        preencherTableViewItens(new ItemDAO().selectByName(""));
        preencherTableViewProdutos(new ProdutoDAO().selectByName("")); 
        
        txtPesquisarItens.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {                               
                    preencherTableViewItens(new ItemDAO().selectByName(txtPesquisarItens.getText()));                
            }
        });
        
        txtPesquisar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                produtoCadastrado = false;
                setEditableFalse();
                String pesquisa = txtPesquisar.getText();
                int codigo;
                try
                {
                    codigo = Integer.parseInt(pesquisa);
                    ArrayList<Produto> produtos = new ArrayList<Produto>();
                    produtos.add(new ProdutoDAO().selectByCodigo(codigo));
                    preencherTableViewProdutos(produtos);
                }
                catch(Exception e)
                {
                    preencherTableViewProdutos(new ProdutoDAO().selectByName(pesquisa));
                }
            }
        });
    }    

    @FXML
    private void tableViewProdutos_OnClick(MouseEvent event)
    {
        setEditableFalse();        
        
        try{
            Produto produto = tableViewProdutos.getSelectionModel().getSelectedItem();
            itensProduto = produto.getItens();
            lblNumeroCodigoProduto.setText(Integer.toString(produto.getCodigo()));
            txtNomeProduto.setText(produto.getNome());
            preencherTableViewItensProduto(itensProduto);
            setValorTotalProduto(produto.getValor());
            btnNovoProduto.setText("Novo");
            produtoCadastrado = true;
        }catch(Exception e){
            
        }
    }

    @FXML
    private void tableViewItensProduto_OnClick(MouseEvent event)
    {
        btnAdicionarItensProduto.setDisable(true);
        btnRemoverItensProduto.setDisable(false);
        txtQuantidadeItem.setVisible(false);
    }

    @FXML
    private void tableViewItens_OnClick(MouseEvent event)
    {        
        btnAdicionarItensProduto.setDisable(false);
        btnRemoverItensProduto.setDisable(true);
        txtQuantidadeItem.setVisible(true);        
        txtQuantidadeItem.setDisable(false);
        txtQuantidadeItem.setText("0");                        
    }

    @FXML
    private void cadastrarProduto_OnAction(ActionEvent event)
    {        
        if(btnNovoProduto.getText().equals("Novo"))
        {
            setEditableTrue();
            setValorTotalProduto(0f);            
            itensProduto = new ArrayList<Item>();
            itensProduto.clear();                                            
            tableViewItensProduto.getSelectionModel().clearSelection();
            btnNovoProduto.setText("Salvar");
            produtoCadastrado = false;
            clearTextFields();
            lblNumeroCodigoProduto.setText(Integer.toString(new ProdutoDAO().getNextID()));
        }
        else if(btnNovoProduto.getText().equals("Salvar"))
        {
            setEditableFalse();            
            Produto produto = new Produto();
            produto.setItens(itensProduto);
            produto.setCodigo(Integer.parseInt(lblNumeroCodigoProduto.getText()));
            produto.setNome(txtNomeProduto.getText());
            produto.setValor(getValorTotalProduto());
            btnNovoProduto.setText("Novo");
            if(produtoCadastrado == false)
            {
                new ProdutoDAO().create(produto);                
            }
            else
            {
                new ProdutoDAO().update(produto);
            }
        }
        preencherTableViewProdutos(new ProdutoDAO().selectByName(""));
    }

    @FXML
    private void editarProduto_OnAction(ActionEvent event)
    {
        setEditableTrue();         
        btnNovoProduto.setText("Salvar");
    }

    @FXML
    private void removerProduto_OnAction(ActionEvent event)
    {
        new ProdutoDAO().delete(Integer.parseInt(lblNumeroCodigoProduto.getText()));
        preencherTableViewProdutos(new ProdutoDAO().selectByName(""));
        setEditableFalse();
        clearTextFields();
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
        adicionarItensProduto(item);                   
    }

    @FXML
    private void btnRemoverItensProduto_OnAction(ActionEvent event) 
    {           
        Item item = tableViewItensProduto.getSelectionModel().getSelectedItem();
        //new ItemProdutoDAO().delete(Integer.parseInt(lblNumeroCodigoProduto.getText()), item.getCodigo());         
        removerItensProduto(item);                
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
        valor = (valor * 1.3f);
        this.valorTotalProduto -= valor;
        txtValorTotalProduto.setText(Float.toString(this.valorTotalProduto));
    }
    
    private void setEditableFalse(){        
        txtNomeProduto.setEditable(false);
        txtQuantidadeItem.setVisible(false);
        txtValorTotalProduto.setEditable(false);        
        tableViewItens.setEditable(false);
        tableViewItensProduto.setEditable(false);
        btnAdicionarItensProduto.setDisable(true);
        btnRemoverItensProduto.setDisable(true);  
        txtPesquisarItens.setEditable(false);
        tableViewItens.setDisable(true);
        tableViewItensProduto.setDisable(true);
    }
    
    private void setEditableTrue(){        
        txtNomeProduto.setEditable(true);        
        //txtValorTotalProduto.setEditable(true);        
        tableViewItens.setEditable(true);
        tableViewItensProduto.setDisable(false);
        btnAdicionarItensProduto.setDisable(true);
        btnRemoverItensProduto.setDisable(true);  
        txtPesquisarItens.setEditable(true);
        tableViewItens.setDisable(false);
    }
    
    private void clearTextFields(){
        lblNumeroCodigoProduto.setText("");
        txtNomeProduto.setText("");
        setValorTotalProduto(0);
        preencherTableViewItensProduto(new ArrayList<Item>());        
    }
    
    private void adicionarItensProduto(Item item){        
        itensProduto.add(item);
        somarValorTotalProduto(item.getValorCompra() * Float.parseFloat(txtQuantidadeItem.getText()));
        preencherTableViewItensProduto(itensProduto);        
        
    }
    
    private void removerItensProduto(Item item){
        itensProduto.remove(item);
        subtrairValorTotalProduto(item.getValorCompra() * item.getQuantidade());
        preencherTableViewItensProduto(itensProduto);
    }
    
    /*private void observableListItens(ArrayList<Item> itens){
        ObservableList<Item> observableListItens = FXCollections.observableArrayList(itens);
        tableViewItensProduto.setItems(observableListItens);
        preencherTableViewItensProduto(itens);        
        txtQuantidadeItem.setVisible(false);                               
    }*/
}
