package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CadastrarItemController implements Initializable {

    @FXML
    private AnchorPane anchorPaneCadastrarItem;
    @FXML
    private Label lblGerenciamentoItens;
    @FXML
    private Label lblCodigoItens;
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
    private TableView<?> tableViewItens;
    @FXML
    private TableColumn<?, ?> tableColumnItens;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
