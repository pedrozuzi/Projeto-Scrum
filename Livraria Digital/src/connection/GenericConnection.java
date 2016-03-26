package connection;

import java.sql.Connection;

/**
 * Interface que possui os métodos de conexão.
 * @author 
 *
 */
public interface GenericConnection {

	/**
	 * Método que abre a conexão com o banco
	 * @return conexao com o banco
	 */
	public Connection getConnection();
	
	/**
	 * Método que fecha a conexão com o banco
	 * @param conexao do banco
	 */
	public void fechaConexao(Connection con);
	
}