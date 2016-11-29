package Controller;

import Model.DAO.PedidoDAO;
import Model.Item;
import Model.Pedido;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class CadastrarPedidoController implements Initializable {
    
    @FXML
    private AnchorPane anchorPanePedidos;
    @FXML
    private Label lblGerenciamentoPedidos;
    @FXML
    private Label lblCodigoPedido;
    @FXML
    private Label lblNumeroCodigoPedido;
    @FXML
    private Label lblTipoPagamentoPedido;
    @FXML
    private ComboBox<String> cbxTipoPagamentoPedido;
    @FXML
    private TableView<Item> tableViewItensPedido;
    @FXML
    private TableView<Produto> tableViewProdutos;
    @FXML
    private TableColumn<String, Produto> tableColumnProdutos;
    @FXML
    private Button btnAdicionarProdutosPedido;
    @FXML
    private Button btnNovoPedido;
    @FXML
    private Button btnEditarPedido;
    @FXML
    private Button btnCancelarPedido;
    @FXML
    private Label lblValorTotalPedido;
    @FXML
    private TextField txtValorTotalPedido;
    @FXML
    private Button btnAdicionarCheckPoint;
    @FXML
    private Label lblStatus;
    @FXML
    private Label lblStatusPedido;
    @FXML
    private Label lblNomeCliente;
    @FXML
    private TextField txtPesquisa;
    @FXML
    private TableView<Pedido> tableViewPedidos;
    @FXML
    private TableColumn<Integer, Pedido> tableColumnNumeroPedido;
    @FXML
    private TableColumn<String, Pedido> tableColumnNomeCliente;
    @FXML
    private TableColumn<String, Produto> tableColumnProdutosPedido;
    @FXML
    private TextField txtPesquisarProduto;
    @FXML
    private TextField txtQuantidadeProduto;
    @FXML
    private Button btnRemoverProdutosPedido;
    @FXML
    private TableColumn<Integer, Produto> tableColumnQuantidadeProdutoPedido;
    
    private ObservableList<Pedido> observableListPedidos;
    
    private ArrayList<Pedido> pedidos;
    @FXML
    private TextField txtCpfCliente;
        

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherTableViewPedidos(new PedidoDAO().selectAll());
    }    

    @FXML
    private void tableViewItensPedido_OnClick(ContextMenuEvent event)
    {
    }

    @FXML
    private void tableViewProdutos_OnClick(ContextMenuEvent event)
    {
    }

    @FXML
    private void cadastrarItem_OnAction(ActionEvent event)
    {
    }

    @FXML
    private void editarItem_OnAction(ActionEvent event)
    {
    }

    @FXML
    private void removerItem_OnAction(ActionEvent event)
    {
    }

    @FXML
    private void tableViewPedidos_OnClick(MouseEvent event)
    {
    }
    
    private void preencherComboBoxPagamento(){
        cbxTipoPagamentoPedido.getItems().add("Dinheiro");
        cbxTipoPagamentoPedido.getItems().add("Cartão de Débito");
        cbxTipoPagamentoPedido.getItems().add("Cartão de Crédito");
        cbxTipoPagamentoPedido.getItems().add("Cheque");                
    }
    
    private void preencherTableViewPedidos(ArrayList<Pedido> pedidos){
        tableColumnNumeroPedido.setCellValueFactory(new PropertyValueFactory<>("getNumero"));        
        tableColumnNomeCliente.setCellValueFactory(new PropertyValueFactory<>("getNomeCliente"));
        
        observableListPedidos = FXCollections.observableArrayList(pedidos);
        
        tableViewPedidos.setItems(observableListPedidos);
    }
}
