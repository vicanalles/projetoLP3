package projetolp3;

import java.util.Date;

public class Log {
    
    //variáveis
    private Date horaAberturaPedido;
    private Date horaInicioProducao;
    private Date horaTerminoProducao;
    private Date horaSaidaEntrega;
    private Date horaRetornoEntrega;
    
    //construtor
    public Log(Date horaAberturaPedido){
        this.horaAberturaPedido = horaAberturaPedido;
    }

    public Date getHoraAberturaPedido() {
        return horaAberturaPedido;
    }

    public void setHoraAberturaPedido(Date horaAberturaPedido) {
        this.horaAberturaPedido = horaAberturaPedido;
    }

    public Date getHoraInicioProducao() {
        return horaInicioProducao;
    }

    public void setHoraInicioProducao(Date horaInicioProducao) {
        this.horaInicioProducao = horaInicioProducao;
    }

    public Date getHoraTerminoProducao() {
        return horaTerminoProducao;
    }

    public void setHoraTerminoProducao(Date horaTerminoProducao) {
        this.horaTerminoProducao = horaTerminoProducao;
    }

    public Date getHoraSaidaEntrega() {
        return horaSaidaEntrega;
    }

    public void setHoraSaidaEntrega(Date horaSaidaEntrega) {
        this.horaSaidaEntrega = horaSaidaEntrega;
    }

    public Date getHoraRetornoEntrega() {
        return horaRetornoEntrega;
    }

    public void setHoraRetornoEntrega(Date horaRetornoEntrega) {
        this.horaRetornoEntrega = horaRetornoEntrega;
    }        
    
    public void criarLog(){
        
    }
    
    public void adicionarPontoChecagem(){
        
    }
    
    
    
}
