package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.GenericException;
import model.Livro;
import persistence.LivroDao;
import persistence.LivroDaoImpl;

public class Teste {

	public static void main(String[] args) {
		LivroDao ldao = new LivroDaoImpl();
		Livro livro = null;
		List<Livro> lista = new ArrayList<Livro>();
		
		try {
			lista=ldao.pesquisa(livro);
			livro=lista.get(0);
			System.out.println(livro.getTitulo());
		} catch (GenericException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
