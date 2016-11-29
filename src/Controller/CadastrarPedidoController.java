package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.LogDAO;
import Model.DAO.PedidoDAO;
import Model.DAO.ProdutoDAO;
import Model.Log;
import Model.Pedido;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Pedido> tableViewPedidos;
    @FXML
    private TableColumn<Pedido, Integer> tableColumnNumeroPedido;
    @FXML
    private TableColumn<Pedido, String> tableColumnNomeCliente;
    @FXML
    private TableColumn<Produto, String> tableColumnProdutosPedido;
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
    @FXML
    private TableView<Produto> tableViewProdutosPedido;
    
    private ArrayList<Produto> produtosPedido;    
    
    boolean pedidoCadastrado = false;
    
    private ObservableList<Produto> observableListProdutos;
    private ObservableList<Produto> observableListProdutosPedido;
    
    private float valorTotalPedido = 0;
    @FXML
    private TextField txtPesquisar;                
    @FXML
    private CheckBox chkEntrega;
    @FXML
    private CheckBox chkProducao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        pedidos = new PedidoDAO().selectAll();        
        setEditableFalse();
        preencherComboBoxPagamento();
        preencherTableViewPedidos(new PedidoDAO().selectAll());
        preencheTableViewProdutos(new ProdutoDAO().selectByName(""));
        
        txtPesquisarProduto.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {                               
                    preencheTableViewProdutos(new ProdutoDAO().selectByName(txtPesquisarProduto.getText()));                
            }
        });
        
        txtPesquisar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {                               
                    preencherTableViewPedidos(new PedidoDAO().selectByCpfCliente(txtPesquisar.getText()));                
            }
        });
    }       

    @FXML
    private void editarItem_OnAction(ActionEvent event)
    {
        setEditableTrue();
        btnNovoPedido.setText("Salvar");
        btnAdicionarCheckPoint.setDisable(true);
    }

    @FXML
    private void removerItem_OnAction(ActionEvent event)
    {
        new PedidoDAO().delete(Integer.parseInt(lblNumeroCodigoPedido.getText()));
        preencherTableViewPedidos(new PedidoDAO().selectAll());
        setEditableFalse();
        clearTextFields();
    }

    @FXML
    private void tableViewPedidos_OnClick(MouseEvent event)
    {
        btnAdicionarCheckPoint.setDisable(false);
        setEditableFalse();
        
        try
        {
            Pedido pedido = tableViewPedidos.getSelectionModel().getSelectedItem();
            
            produtosPedido = pedido.getProdutos();
            
            lblNumeroCodigoPedido.setText(Integer.toString(pedido.getNumero()));
            txtCpfCliente.setText(pedido.getCliente().getCpf());
            cbxTipoPagamentoPedido.setValue(pedido.getPagamento());
            setValorTotalPedido(pedido.getValorPedido());
            preencheTableViewProdutosPedido(produtosPedido);
            System.out.println(pedido.getLog().getTipoPedido());
            if(pedido.getLog().getTipoPedido() == 0){
                chkEntrega.setSelected(false);
                chkProducao.setSelected(false);           
            }
            if(pedido.getLog().getTipoPedido() == 1){
                chkEntrega.setSelected(false);
                chkProducao.setSelected(true);           
            }
            if(pedido.getLog().getTipoPedido() == 2){
                chkEntrega.setSelected(true);
                chkProducao.setSelected(false);           
            }
            if(pedido.getLog().getTipoPedido() == 3){
                chkEntrega.selectedProperty().setValue(true);
                chkProducao.selectedProperty().setValue(true);           
            }
            
            int i = 5;
            while(i >= 0){
                if(pedido.getLog().getHorarios()[i] != null)
                    break;
                i--;
                System.out.println(pedido.getLog().getFRASES()[i]);
            }
            lblStatusPedido.setText(pedido.getLog().getFRASES()[i]);
            
            btnNovoPedido.setText("Novo");
            pedidoCadastrado = true;
        }
        catch(Exception e)
        {
            
        }
        
                                                       
    }
    
    private void preencherComboBoxPagamento(){
        cbxTipoPagamentoPedido.getItems().add("Dinheiro");
        cbxTipoPagamentoPedido.getItems().add("Cartão de Débito");
        cbxTipoPagamentoPedido.getItems().add("Cartão de Crédito");
        cbxTipoPagamentoPedido.getItems().add("Cheque");                
    }
    
    private void preencherTableViewPedidos(ArrayList<Pedido> pedidos){
        tableColumnNumeroPedido.setCellValueFactory(new PropertyValueFactory<>("numero"));        
        tableColumnNomeCliente.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
        
        observableListPedidos = FXCollections.observableArrayList(pedidos);
        
        tableViewPedidos.setItems(observableListPedidos);
    }
    
    private void preencheTableViewProdutos(ArrayList<Produto> produtos)
    {        
        tableColumnProdutos.setCellValueFactory(new PropertyValueFactory<>("nome"));
        observableListProdutos = FXCollections.observableArrayList(produtos);
        tableViewProdutos.setItems(observableListProdutos);        
    }
    
    private void preencheTableViewProdutosPedido(ArrayList<Produto> produtos)
    {        
        tableColumnProdutosPedido.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnQuantidadeProdutoPedido.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        observableListProdutosPedido = FXCollections.observableArrayList(produtosPedido);
        tableViewProdutosPedido.setItems(observableListProdutosPedido);        
    }

    @FXML
    private void cadastrarPedido_OnAction(ActionEvent event) 
    {
        if(btnNovoPedido.getText().equals("Novo"))
        {            
            btnAdicionarCheckPoint.setDisable(true);
            setEditableTrue();
            produtosPedido = new ArrayList<Produto>();
            produtosPedido.clear();
            txtCpfCliente.setText("");
            tableViewProdutosPedido.getSelectionModel().clearSelection();
            btnNovoPedido.setText("Salvar");
            pedidoCadastrado = false;
            clearTextFields();
            lblNumeroCodigoPedido.setText(Integer.toString(new PedidoDAO().getNextID()));
        }else if(btnNovoPedido.getText().equals("Salvar"))
        {
            btnAdicionarCheckPoint.setDisable(false);
            setEditableFalse();
            Pedido pedido = new Pedido();
            pedido.setProdutos(produtosPedido);
            pedido.setNumero(Integer.parseInt(lblNumeroCodigoPedido.getText()));                        
            pedido.setCliente(new ClienteDAO().selectOneByCpf(txtCpfCliente.getText()));
            pedido.setFuncionario(TelaLoginController.getFuncionario());            
            pedido.setPagamento(cbxTipoPagamentoPedido.getSelectionModel().getSelectedItem());
            pedido.setValorPedido(getValorTotalPedido());
            
            if(chkEntrega.isSelected() == false && chkProducao.isSelected() == false)
            {
                pedido.setLog(new Log(0));
            }
            if(chkEntrega.isSelected() == false && chkProducao.isSelected() == true){
                pedido.setLog(new Log(1));
            }
            if(chkEntrega.isSelected() == true && chkProducao.isSelected() == false){
                pedido.setLog(new Log(2));
            }
            if(chkEntrega.isSelected() == true && chkProducao.isSelected() == true){
                pedido.setLog(new Log(3));
            }
            btnNovoPedido.setText("Novo");
            
            if(pedidoCadastrado == false)
            {
                new PedidoDAO().create(pedido);
            }
            else
            {
                new PedidoDAO().update(pedido);
            }
            preencherTableViewPedidos(new PedidoDAO().selectAll());
        }
    }
    
    private void setEditableTrue(){        
        txtCpfCliente.setEditable(true);                        
        cbxTipoPagamentoPedido.setDisable(false);
        tableViewProdutos.setDisable(false);
        btnAdicionarProdutosPedido.setDisable(true);
        btnRemoverProdutosPedido.setDisable(true);  
        txtPesquisarProduto.setEditable(true);
        tableViewProdutosPedido.setDisable(false);
    }
    
    private void setEditableFalse(){        
        txtCpfCliente.setEditable(false);                        
        cbxTipoPagamentoPedido.setDisable(true);
        tableViewProdutos.setDisable(true);
        btnAdicionarProdutosPedido.setDisable(false);
        btnRemoverProdutosPedido.setDisable(false);  
        txtPesquisarProduto.setEditable(false);
        tableViewProdutosPedido.setDisable(true);
        txtQuantidadeProduto.setEditable(false);
        btnAdicionarProdutosPedido.setDisable(true);
        btnRemoverProdutosPedido.setDisable(true);
        txtValorTotalPedido.setEditable(false);        
    }
    
    private void clearTextFields(){        
        txtCpfCliente.setText("");
        cbxTipoPagamentoPedido.getSelectionModel().clearSelection();
        chkEntrega.setSelected(false);
        chkProducao.setSelected(false);
        setValorTotalPedido(0f);
        txtQuantidadeProduto.setText("");
        txtPesquisarProduto.setText("");
        lblNumeroCodigoPedido.setText("");
        lblStatusPedido.setText("");
        produtosPedido.clear();        
        preencheTableViewProdutosPedido(produtosPedido);
    }


    public float getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(float valorTotalPedido) {        
        this.valorTotalPedido = valorTotalPedido;
        txtValorTotalPedido.setText(Float.toString(valorTotalPedido));
    }

    @FXML
    private void tableViewProdutos_OnClick(MouseEvent event) 
    {
        txtQuantidadeProduto.setEditable(true);
        txtQuantidadeProduto.setText("");
        btnAdicionarProdutosPedido.setDisable(false);
        btnRemoverProdutosPedido.setDisable(true);
    }

    @FXML
    private void tableViewProdutosPedido_OnClick(MouseEvent event) 
    {
        txtQuantidadeProduto.setEditable(false);
        txtQuantidadeProduto.setText("");
        btnAdicionarProdutosPedido.setDisable(true);
        btnRemoverProdutosPedido.setDisable(false);
    }

    @FXML
    private void btnAdicionarProdutosPedido_OnAction(ActionEvent event) 
    {
        Produto produto = tableViewProdutos.getSelectionModel().getSelectedItem();
        produto.setQuantidade(Integer.parseInt(txtQuantidadeProduto.getText()));
        adicionarProdutosPedido(produto);
    }
    
    private void adicionarProdutosPedido(Produto produto)
    {
        produtosPedido.add(produto);
        somarValorTotalPedido(produto.getValor() * Integer.parseInt(txtQuantidadeProduto.getText()));
        preencheTableViewProdutosPedido(produtosPedido);
    }
    
    private void removerProdutosPedido(Produto produto)
    {
        produtosPedido.remove(produto);
        subtrairValorTotalPedido(produto.getValor() * produto.getQuantidade());
        preencheTableViewProdutosPedido(produtosPedido);
    }
    
    private void somarValorTotalPedido(float valor)
    {
        valor = (valor * 1.3f);
        this.valorTotalPedido += valor;
        txtValorTotalPedido.setText(Float.toString(this.valorTotalPedido));
    }
    
    private void subtrairValorTotalPedido(float valor)
    {
        valor = (valor * 1.3f);
        this.valorTotalPedido -= valor;
        txtValorTotalPedido.setText(Float.toString(this.valorTotalPedido));
    }

    @FXML
    private void btnRemoverProdutosPedido_OnAction(ActionEvent event) 
    {
        Produto produto = tableViewProdutosPedido.getSelectionModel().getSelectedItem();
        removerProdutosPedido(produto);
    }

    @FXML
    private void btnAdicionarCheckPoint_OnAction(ActionEvent event) throws Exception 
    {
        Log log = new LogDAO().selectByNumeroPedido(Integer.parseInt(lblNumeroCodigoPedido.getText()));
        log.adicionarCheckPoint();
        System.out.println(log.getHoraAberturaPedido());
        System.out.println(log.getHoraInicioProducao());
        System.out.println(log.getHoraTerminoProducao());
        new LogDAO().update(Integer.parseInt(lblNumeroCodigoPedido.getText()), log);
        pedidos = new PedidoDAO().selectAll();
        preencherTableViewPedidos(pedidos);
    }
}
