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
    public static Date convertStringToDate(String data) throws Exception
    {
        try{
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            return formato.parse(data);
        }catch(Exception e){
            return null;
        }
        
    }   
    
    public static String horaAtual(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return sdf.format(new Date());
    }
    
    public static Date convertStringToHour(String data) throws Exception
    {
        try{
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            return formato.parse(data);
        }catch(Exception e){
            return null;
        }        
    }
    
    public static String convertDateToString(Date data) throws Exception
    {
        //java.util.Date d = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
         //vai te retorna uma String
        return f.format(data);
    }
}