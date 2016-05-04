package view;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class FileDownloadView {
	
	private StreamedContent file;
	
	public StreamedContent downloadResumo(String arquivo) {
		InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resumo/" + arquivo);
		file =  new DefaultStreamedContent(stream, "application/pdf", arquivo);
		return file;
	}
	
	public StreamedContent downloadSumario(String arquivo){
		InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/sumario/" + arquivo);
		file =  new DefaultStreamedContent(stream, "application/pdf", arquivo);
		return file;
	}
	
	public StreamedContent getFile() {
		return file;
	}

}
