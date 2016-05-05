package view;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

@ManagedBean
public class FileUploadView {
	
	public void uploadResumo(FileUploadEvent event) throws IOException {
		byte[] arquivo = event.getFile().getContents();
		String caminho = "C:\\Users\\Pedro\\git\\Projeto-Scrum\\Livraria Digital\\WebContent\\resumo\\" + event.getFile().getFileName();
		
		FileOutputStream fos = new FileOutputStream(caminho);
        fos.write(arquivo);
        fos.close();
        
        System.out.println("caminho da imagem salva é  = " + caminho);
		
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " carregado.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void uploadSumario(FileUploadEvent event) throws IOException {
		byte[] arquivo = event.getFile().getContents();
		String caminho = "C:\\Users\\Pedro\\git\\Projeto-Scrum\\Livraria Digital\\WebContent\\sumario\\" + event.getFile().getFileName();
		
		FileOutputStream fos = new FileOutputStream(caminho);
        fos.write(arquivo);
        fos.close();
        
        System.out.println("caminho da imagem salva é  = " + caminho);
		
        FacesMessage message = new FacesMessage("Sucesso", event.getFile().getFileName() + " carregado");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
