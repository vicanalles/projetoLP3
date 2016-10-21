package projetolp3;

import java.util.Date;
import java.util.Scanner;

public class Log {
    
    //variáveis
    Date horarios[];
    /*
    private Date horaAberturaPedido;
    private Date horaInicioProducao;
    private Date horaTerminoProducao;
    private Date horaSaidaEntrega;
    private Date horaRetornoEntrega;
    */
    //construtor
    public Log(Date horaAberturaPedido, int tamanhoVetor){
        //this.horaAberturaPedido = horaAberturaPedido;
        horarios = new Date[tamanhoVetor];
        horarios[0] = horaAberturaPedido;
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
        System.out.print("Hora de abertura do pedido: " + getHoraAberturaPedido().toString());
        System.out.print("Hora de início da produção: " + getHoraInicioProducao().toString());
        System.out.print("Hora de término da produção: " + getHoraTerminoProducao().toString());
        System.out.print("Hora de saída para entrega: " + getHoraSaidaEntrega().toString());
        System.out.print("Hora de retorno do entregador: " + getHoraRetornoEntrega().toString());
        System.out.print("Hora de finalização do pedido: " + getHoraFinalizacaoPedido().toString());
    }
    
    public void adicionarPontoChecagem(Date data)
    {
        for(int i=1;i<horarios.length;i++)
        {
            if(horarios[i] == null)
            {
                horarios[i] = data;
                switch (i)
                {
                    case 1:
                        System.out.println("Horário de início da produção adicionado.");
                        break;
                    case 2:
                        System.out.println("Horário de término da produção adicionado.");
                        break;
                    case 3:
                        System.out.println("Horário de saída para entrega adicionado.");
                        break;
                    case 4:
                        System.out.println("Horário de retorno do entregador adicionado.");
                        break;
                }
                return;
            }
        }
    }
}
