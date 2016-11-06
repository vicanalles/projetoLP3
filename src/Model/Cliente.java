package Model;

public class Cliente extends Pessoa {
    
    private String produtoFavorito;
    
    public Cliente()
    {
        
    }
        
    /**
     * Retorna o produto favorito do cliente
     * @return produto favorito do cliente
     */
    public String getProdutoFavorito() {
        return produtoFavorito;
    }

    /**
     * Altera o produto favorito  do cliente 
     * @param produtoFavorito Nome do produto favorito do cliente
     */
    public void setProdutoFavorito(String produtoFavorito) {
        this.produtoFavorito = produtoFavorito;
    }   
}
