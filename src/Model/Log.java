package Model;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    
    //variáveis
    //vetor de frases para linkar com o vetor de Dates
    private static final String[] FRASES = 
    {
        "Aguardando iniciar Produção",
        "Em Produção",
        "Produção finalizada",
        "Em entrega",
        "Pedido entregue ",
        "Pedido finalizado"
    };
    private Date horarios[];
    private int tipoPedido;
    /*
    private Date horaAberturaPedido;
    private Date horaInicioProducao;
    private Date horaTerminoProducao;
    private Date horaSaidaEntrega;
    private Date horaRetornoEntrega;
    */
    
    /**
     * @param tipoPedido Pode receber um único inteiro de 0 a 3, que define o tipo do pedido:
     * 0 - Não inclui produção nem entrega
     * 1 - Inclui produção mas não inclui entrega
     * 2 - Não inclui produção mas inclui entrega
     * 3 - Inclui produção e também entrega
     */
    public Log(int tipoPedido){
        //this.horaAberturaPedido = horaAberturaPedido;        
        this.tipoPedido = tipoPedido;
        horarios = new Date[6];
        try {        
            horarios[0] = DataHora.convertStringToHour(DataHora.horaAtual());
        } catch (Exception ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Date[] getHorarios()
    {
        return horarios;
    }

    public void setHorarios(Date[] horarios)
    {
        this.horarios = horarios;
    }
    
    public String[] getFRASES()
    {
        return FRASES;
    }
    
    public int getTipoPedido()
    {
        return tipoPedido;
    }

    public Date getHoraAberturaPedido() {
        return horarios[0];
    }
    
    public void setHoraAberturaPedido(Date horaAberturaPedido) {
        horarios[0] = horaAberturaPedido;
    }
    
    public Date getHoraInicioProducao() {
        return horarios[1];
    }

    public void setHoraInicioProducao(Date horaInicioProducao) {
        horarios[1] = horaInicioProducao;
    }

    public Date getHoraTerminoProducao() {
        return horarios[2];
    }

    public void setHoraTerminoProducao(Date horaTerminoProducao) {
        horarios[2] = horaTerminoProducao;
    }

    public Date getHoraSaidaEntrega() {
        return horarios[3];
    }

    public void setHoraSaidaEntrega(Date horaSaidaEntrega) {
        horarios[3] = horaSaidaEntrega;
    }

    public Date getHoraRetornoEntrega() {
        return horarios[4];
    }

    public void setHoraRetornoEntrega(Date horaRetornoEntrega) {
        horarios[4] = horaRetornoEntrega;
    }
    
    public Date getHoraFinalizacaoPedido() {
        return horarios[5];
    }

    public void setHoraFinalizacaoPedido(Date horaFinalizacaoPedido) {
        horarios[5] = horaFinalizacaoPedido;
    }      
    
    /**
     * Adiciona a data atual do sistema ao log do pedido.
     * A data a ser adicionada é o próximo checkpoint do log.
     * Pedidos que não incluirem produção ou entrega manterão nulas as Dates referentes a cada um.
     * @return A posição do log que foi adicionada. Pode retornar entre 0 e 5 caso o checkpoint seja adicionado, ou -1 caso o pedido já esteja finalizado.
     */
    public int adicionarCheckPoint() throws Exception
    {
        if(VerificarFinalizacao() == true)
            return -1;
        switch(this.tipoPedido)
        {
            case 0:
                for(int i=1;i<6;i++)
                {
                    if(horarios[i]!=null||i==1||i==2||i==3||i==4)
                        continue;
                    horarios[i] = DataHora.convertStringToHour(DataHora.horaAtual());
                    return i;
                }
                break;
            case 1:
                for(int i=1;i<6;i++)
                {
                    if(horarios[i]!=null||i==3||i==4)
                        continue;
                    horarios[i] = DataHora.convertStringToHour(DataHora.horaAtual());
                    return i;
                }
                break;
            case 2:
                for(int i=1;i<6;i++)
                {
                    if(horarios[i]!=null||i==1||i==2)
                        continue;
                    horarios[i] = DataHora.convertStringToHour(DataHora.horaAtual());
                    return i;
                }
                break;
            case 3:
                for(int i=1;i<6;i++)
                {
                    if(horarios[i]!=null)
                        continue;
                    horarios[i] = DataHora.convertStringToHour(DataHora.horaAtual());
                    return i;
                }
                break;
        }
        return -1;
    }
    
    /**
     * Verifica se o pedido foi finalizado ou não
     * @return true se o pedido foi finalizado ou false se ainda não foi finalizado.
     */
    public boolean VerificarFinalizacao()
    {
        return horarios[5]!=null;
    }

    public void setTipoPedido(int tipoPedido) {
        this.tipoPedido = tipoPedido;
    }
}
