package Controller;

public abstract class Utilities {
    
    protected static String converterEstado(String estadoCompleto)
    {
        char[] siglaEstado = new char[2];
        estadoCompleto.getChars(estadoCompleto.length()-2, estadoCompleto.length(), siglaEstado, 0);
        return new String(siglaEstado);
    }
}
