package projetolp3;

import java.util.Date;
import java.util.Scanner;

public class Log {
    
    //variáveis
    //vetor de frases para linkar com o vetor de Dates
    private static final String[] FRASES = 
    {
        "Hora de abertura do pedido: ",
        "Hora de início da produção: ",
        "Hora de término da produção: ",
        "Hora de saída para entrega: ",
        "Hora de retorno do entregador: ",
        "Hora de finalização do pedido: "
    };
    
    Date horarios[];
    int tipoPedido;
    /*
    private Date horaAberturaPedido;
    private Date horaInicioProducao;
    private Date horaTerminoProducao;
    private Date horaSaidaEntrega;
    private Date horaRetornoEntrega;
    */
    
    //construtor
    /**
     *if(comProducao == false && comEntrega == false)
            tipoPedido = 0;
        else if(comProducao == true && comEntrega == false)
            tipoPedido = 1;
        else if(comProducao == false && comEntrega == true)
            tipoPedido = 2;
        else if(comProducao == true && comEntrega == true)
            tipoPedido = 3;
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
        horarios[0] = DataHora.getDate();
    }

    public Date getHoraAberturaPedido() {
        //return horaAberturaPedido;
        return horarios[0];
    }
    
    public Date getHoraInicioProducao() {
        //return horaInicioProducao;
        return horarios[1];
    }

    public void setHoraInicioProducao(Date horaInicioProducao) {
        //this.horaInicioProducao = horaInicioProducao;
        horarios[1] = horaInicioProducao;
    }

    public Date getHoraTerminoProducao() {
        //return horaTerminoProducao;
        return horarios[2];
    }

    public void setHoraTerminoProducao(Date horaTerminoProducao) {
        //this.horaTerminoProducao = horaTerminoProducao;
        horarios[2] = horaTerminoProducao;
    }

    public Date getHoraSaidaEntrega() {
        //return horaSaidaEntrega;
        return horarios[3];
    }

    public void setHoraSaidaEntrega(Date horaSaidaEntrega) {
        //this.horaSaidaEntrega = horaSaidaEntrega;
        horarios[3] = horaSaidaEntrega;
    }

    public Date getHoraRetornoEntrega() {
        //return horaRetornoEntrega;
        return horarios[4];
    }

    public void setHoraRetornoEntrega(Date horaRetornoEntrega) {
        //this.horaRetornoEntrega = horaRetornoEntrega;
        horarios[4] = horaRetornoEntrega;
    }
    
    public Date getHoraFinalizacaoPedido() {
        //return horaRetornoEntrega;
        return horarios[5];
    }

    public void setHoraFinalizacaoPedido(Date horaFinalizacaoPedido) {
        //this.horaRetornoEntrega = horaRetornoEntrega;
        horarios[5] = horaFinalizacaoPedido;
    }  
    
    /**
     *Exibe os horários contidos no Log
     */
    public void exibirDados()
    {
        for(int i=0;i<6;i++)
        {
            if(horarios[i] == null)
                continue;
            System.out.println(FRASES[i] + horarios[i].toString());
        }
    }
    
    /**
     * Adiciona uma data ao log de um determinado pedido.
     * A data a ser adicionada é o próximo checkpoint do log.
     * Pedidos que não incluirem produção ou entrega manterão nulas as Dates referentes a cada um .
     * @param data
     */
    public void adicionarPontoChecagem()
    {
        switch(this.tipoPedido)
        {
            case 0:
                for(int i=1;i<6;i++)
                {
                    if(horarios[i]!=null||i==1||i==2||i==3||i==4)
                        continue;
                    horarios[i] = DataHora.getDate();
                    return;
                }
                break;
            case 1:
                for(int i=1;i<6;i++)
                {
                    if(horarios[i]!=null||i==3||i==4)
                        continue;
                    horarios[i] = DataHora.getDate();
                    return;
                }
                break;
            case 2:
                for(int i=1;i<6;i++)
                {
                    if(horarios[i]!=null||i==1||i==2)
                        continue;
                    horarios[i] = DataHora.getDate();
                    return;
                }
                break;
            case 3:
                for(int i=1;i<6;i++)
                {
                    if(horarios[i]!=null)
                        continue;
                    horarios[i] = DataHora.getDate();
                    return;
                }
                break;
        }
    }
}
