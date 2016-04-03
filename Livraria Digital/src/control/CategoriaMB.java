package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import exception.GenericException;
import model.Categoria;
import persistence.CategoriaDaoImpl;

@ManagedBean
public class CategoriaMB extends GenericBean<Categoria> implements Serializable{
	private static final long serialVersionUID = 1949986787432773393L;
	
	public CategoriaMB() {
		super.listaPesquisa = new ArrayList<Categoria>();
		super.objAtual = new Categoria();
		super.dao = new CategoriaDaoImpl();
	}

	@Override
	public List<Categoria> pesquisar() throws GenericException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inclui() throws GenericException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altera(Categoria selectedObj) throws GenericException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exclui(Categoria selectedObj) throws GenericException, SQLException {
		// TODO Auto-generated method stub
		
	}

}
