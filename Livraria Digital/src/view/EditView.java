package view;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import control.AutorMB;
import model.Autor;

 
@ManagedBean(name="dtEditView")
@ViewScoped
public class EditView implements Serializable {
     
    private List<Autor> autor;
         
    //@ManagedProperty("#{autorMB}")
    private AutorMB mb;
     
    @PostConstruct
    public void init() {
       autor = mb.getListaPesquisa();
    }
 
    public List<Autor> getAutor() {
        return autor;
    }
 
    public void setMB(AutorMB mb) {
        this.mb = mb;
    }
     
    public void onRowEdit(RowEditEvent event) {
    	mb.altera((Autor) event.getObject());
    	FacesMessage msg = new FacesMessage("Autor editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Autor Cancelled"); //, ((Autor) event.getObject()).getId()
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
