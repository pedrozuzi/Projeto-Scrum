package control;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import enumeration.EstadosBrasil;

@ManagedBean
@ViewScoped
public class EstadosBrasilMB {
	
	private List<String> estados;

	public EstadosBrasilMB() {
		estados = new ArrayList<String>();
	}

	public List<String> getEstados() {
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

	
	public List<String> estados(){
		for ( EstadosBrasil e : EstadosBrasil.values() ) {
			estados.add(e.toString());
		}
		return estados;
	}
	

}
