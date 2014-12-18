package utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Varios {

	public static String dateToString(Date fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha);
    }
	
	
}
