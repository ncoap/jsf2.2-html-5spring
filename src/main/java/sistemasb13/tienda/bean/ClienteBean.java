package sistemasb13.tienda.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.jsf.FacesContextUtils;

import sistemasb13.tienda.domain.Cliente;
import sistemasb13.tienda.services.ClienteService;
import utilidades.ConvertirImagen;

@Component
@Scope("session")
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ClienteBean.class);
	private Cliente cliente;
	private UploadedFile file;
	private List<Cliente> clientes;
	ApplicationContext ctx = FacesContextUtils
			.getWebApplicationContext(FacesContext.getCurrentInstance());

	@Autowired
	private ClienteService clienteService;

	public ClienteBean() {
		log.debug("En el constructor del ClienteBean");
		cliente = new Cliente();
		cliente.setDeNombre("nelson coqchi apaza");
		clientes = new ArrayList<Cliente>();
	}

	public void listarClientes(ActionEvent evt) {
		clientes = clienteService.listarCliente();
	}

	public Cliente getCliente() {

		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public List<Cliente> getClientes() {

		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	// MOSTRAR DIALOGO DE CLIENTE
	public void registrarCliente(ActionEvent evt) {
		RequestContext context = RequestContext.getCurrentInstance();
		cliente = new Cliente();

		// cargar a todos los usuarios
		UsuarioBean usuarioBean = (UsuarioBean) ctx.getBean("usuarioBean");
		usuarioBean.listarUsuarios();

		log.debug("Mostrando dialogo de nuevo cliente");
		context.execute("PF('wvDialogRegistrarCliente').show();");
	}

	public void cargarCliente(ActionEvent evt) {
		UIComponent componente = (UIComponent) evt.getComponent();
		log.debug("CLIENTE DE FILA :"
				+ (Cliente) componente.getAttributes().get("clienteSelect"));
		cliente = (Cliente) componente.getAttributes().get("clienteSelect");
		RequestContext context = RequestContext.getCurrentInstance();
		log.debug("Mostrando dialogo de nuevo cliente");
		context.execute("PF('wvDialogEditarCliente').show();");
	}

	public void actualizarCliente(ActionEvent evt) {

		log.debug("Actualizando Cliente: " + cliente);
		String mensaje = clienteService.actualizarCliente(cliente);
		if (mensaje.equals("OK")) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Cliente Actualizado", ""));
			cliente = new Cliente();
			clientes = clienteService.listarCliente();

		} else if (mensaje.equals("KO")) {

		}
	}

	public void registrarClientee(ActionEvent evt) {

		// UsuarioBean usuarioBean = (UsuarioBean) ctx.getBean("usuarioBean");
		// cliente.setCoUsuario(usuarioBean.getUsuario().getCoUsuario());
		log.debug("Registrando Cliente: " + cliente);
		cliente.setCoUsuario("46435523");
		String mensaje = clienteService.registrarCliente(cliente);
		if (mensaje.equals("OK")) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Cliente Registrado", ""));
			cliente = new Cliente();

			// al obtener los clientes nuevamente debemos actualizar el data
			// table con update
			clientes = clienteService.listarCliente();

		} else if (mensaje.equals("KO")) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Cliente No Registrado", ""));
		}
	}

	public void cargarFotoCliente(FileUploadEvent evt) {
		ArchivoBean archivoBean = (ArchivoBean) ctx.getBean("archivoBean");
		log.debug("EVENTO FILEuPLOAD" + evt);
		log.debug("cargar Foto CLiente archivoBean: " + archivoBean);

		archivoBean.setbImagen(ConvertirImagen.convertImageToByte(evt));
		log.debug("Archivo Bean cargado" + archivoBean.getbImagen());
		archivoBean.setStmImagen(ConvertirImagen.convertByteToImage(archivoBean
				.getbImagen()));
		if (archivoBean.getbImagen() != null) {
			UploadedFile uploadedFile = (UploadedFile) evt.getFile();
			archivoBean.setUploadedFile(uploadedFile);
		}
	}

	public void upload(ActionEvent evt) {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful",
					file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
}
