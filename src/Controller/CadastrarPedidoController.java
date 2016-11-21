package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<?> tableViewItensPedido;
    @FXML
    private TableColumn<?, ?> tableColumnItensPedido;
    @FXML
    private TableView<?> tableViewProdutos;
    @FXML
    private TableColumn<?, ?> tableColumnProdutos;
    @FXML
    private Button btnAdicionarProdutosPedido;
    @FXML
    private Button btnNovoPedido;
    @FXML
    private Button btnEditarPedido;
    @FXML
    private Button btnCancelarPedido;
    @FXML
    private TableView<?> tableViewPedidos;
    @FXML
    private TableColumn<?, ?> tableColumnPedidos;
    @FXML
    private Label lblValorTotalPedido;
    @FXML
    private TextField txtValorTotalPedido;
    @FXML
    private ComboBox<String> cbxSelecaoTipoPedido;
    @FXML
    private Button btnAdicionarCheckPoint;
    @FXML
    private Label lblStatus;
    @FXML
    private Label lblStatusPedido;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxTipoPagamentoPedido.getItems().add("Dinheiro");
        cbxTipoPagamentoPedido.getItems().add("Cartão de Débito");
        cbxTipoPagamentoPedido.getItems().add("Cartão de Crédito");
        cbxTipoPagamentoPedido.getItems().add("Cheque");                
    }    
    
}
