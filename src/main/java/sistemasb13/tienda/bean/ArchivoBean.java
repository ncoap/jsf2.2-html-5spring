package sistemasb13.tienda.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ArchivoBean implements Serializable {

	private UploadedFile uploadedFile;
	private static final long serialVersionUID = 1L;
	private StreamedContent stmImagen;
	private boolean archivoCargado;
	private byte[] bImagen;
	private String directorio;
	private String nombreArchivo;

	public ArchivoBean() {
		this.archivoCargado = false;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getDirectorio() {
		return directorio;
	}

	public void setDirectorio(String directorio) {
		this.directorio = directorio;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public boolean isArchivoCargado() {
		return archivoCargado;
	}

	public void setArchivoCargado(boolean archivoCargado) {
		this.archivoCargado = archivoCargado;
	}

	public StreamedContent getStmImagen() {
		return stmImagen;
	}

	public void setStmImagen(StreamedContent stmImagen) {
		this.stmImagen = stmImagen;
	}

	public byte[] getbImagen() {
		return bImagen;
	}

	public void setbImagen(byte[] bImagen) {
		this.bImagen = bImagen;
	}

	@PostConstruct
	public void init() {
		// Map<String, Object> session = FacesContext.getCurrentInstance()
		// .getExternalContext().getSessionMap();
		// byte[] b = (byte[]) session.get("reportBytes");
		// if (b != null) {
		// stmArchivo = new DefaultStreamedContent(
		// new ByteArrayInputStream(b), "application/pdf");
		// }
	}

}
