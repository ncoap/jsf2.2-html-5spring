package utilidades;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public abstract class ConvertirImagen {
	private static final Logger log = Logger.getLogger(ConvertirImagen.class);
	private static StreamedContent stmImagen;
	private static byte[] bImagen;	
	
	public static byte[] convertImageToByte(FileUploadEvent evt){
		try {
			stmImagen = new DefaultStreamedContent(evt.getFile().getInputstream());
			bImagen= evt.getFile().getContents();
			log.debug("B IMAGEN from ConvertirImagen"+bImagen);
		} catch (IOException ex) {
			log.debug("ConvertirImagen "+ ex.getMessage());
		}
		return bImagen;
	}
	
	public static StreamedContent convertByteToImage(byte[] bImagen){        
		FacesContext context = FacesContext.getCurrentInstance();	    
	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        return new DefaultStreamedContent();
	    }
	    else {
	    	log.debug("byte de imagen"+bImagen);
	    	stmImagen=new DefaultStreamedContent(new ByteArrayInputStream(bImagen));
	        return stmImagen;
	    }
	}			
}
