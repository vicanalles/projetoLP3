package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class MenuPrincipalController implements Initializable {

    

    @FXML
    private AnchorPane anchorPaneMenuPrincipal;
    @FXML
    private Tab tabMenuClientes;
    @FXML
    private Tab tabMenuFuncionarios;
    @FXML
    private TabPane tabPaneMenuPrincipal;
    @FXML
    private AnchorPane anchorPaneClientes;
    @FXML
    private AnchorPane anchorPaneFuncionarios;
    @FXML
    private Tab tabMenuFornecedores;
    @FXML
    private AnchorPane anchorPaneFornecedores;
    @FXML
    private Tab tabMenuItens;
    @FXML
    private AnchorPane anchorPaneItens;
    @FXML
    private Tab tabMenuProdutos;
    @FXML
    private AnchorPane anchorPaneProdutos;
    @FXML
    private Tab tabMenuPedidos;
    @FXML
    private AnchorPane anchorPanePedidos;
    @FXML
    private Label txtNomeFuncionarioLogado;
    
    private static String nomeFuncionarioLogado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        txtNomeFuncionarioLogado.setText(TelaLoginController.getNomeFuncionario());
    }    
    
    public static String getNomeFuncionarioLogado() {
        return nomeFuncionarioLogado;
    }

    public static void setNomeFuncionarioLogado(String aNomeFuncionarioLogado) {
        nomeFuncionarioLogado = aNomeFuncionarioLogado;
    }

    @FXML
    private void showAnchorPaneClientes(Event event) throws IOException {
        AnchorPane a = FXMLLoader.load(getClass().getResource("/View/CadastrarCliente.fxml"));
        anchorPaneClientes.getChildren().setAll(a);
    }

    @FXML
    private void showAnchorPaneFuncionarios(Event event) throws IOException {
        AnchorPane b = FXMLLoader.load(getClass().getResource("/View/CadastrarFuncionario.fxml"));
        anchorPaneFuncionarios.getChildren().setAll(b);
    }

    @FXML
    private void showAnchorPaneFornecedores(Event event) throws IOException {
        AnchorPane c = FXMLLoader.load(getClass().getResource("/View/CadastrarFornecedor.fxml"));
        anchorPaneFornecedores.getChildren().setAll(c);
    }

    @FXML
    private void showAnchorPaneItens(Event event) throws IOException {
        AnchorPane d = FXMLLoader.load(getClass().getResource("/View/CadastrarItem.fxml"));
        anchorPaneItens.getChildren().setAll(d);
    }

    @FXML
    private void showAnchorPaneProdutos(Event event) throws IOException {
        AnchorPane e = FXMLLoader.load(getClass().getResource("/View/CadastrarProduto.fxml"));
        anchorPaneProdutos.getChildren().setAll(e);
    }            

    @FXML
    private void showAnchorPanePedidos(Event event) throws IOException {
        AnchorPane f = FXMLLoader.load(getClass().getResource("/View/CadastrarPedido.fxml"));
        anchorPanePedidos.getChildren().setAll(f);
    }
}
