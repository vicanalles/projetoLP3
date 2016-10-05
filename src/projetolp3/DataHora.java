package projetolp3;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class DataHora {
    
    public static Date getDate(){                
        Calendar c = Calendar.getInstance();
        return c.getTime();        
    }       
    
    public static String getHora(Date d){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}