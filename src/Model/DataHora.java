package Model;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class DataHora {
    
    /**
     * 
     * @return A hora atual do sistema é retornada no tipo Java.Util.Date
     */
    public static Date getDate(){                
        Calendar c = Calendar.getInstance();
        return c.getTime();        
    }       
    
    /**
     * 
     * @return Uma String contendo data e hora atual do sistema no formato dd/mm/yyyy hh:mm:ss
     */
    public static String getHora(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    /**
     * Converte String contendo uma data em Date
     * @param data Recebe uma String no formato dd/MM/yyyy
     * @return A data é retornada no tipo Java.Util.Date
     * @throws Exception Se a String recebida não estiver no formato especificado acima
     */
    public static Date converterData(String data) throws Exception
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.parse(data);
    }
}