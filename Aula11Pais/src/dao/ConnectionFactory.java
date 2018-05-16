package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final ThreadLocal<Connection> conn = new ThreadLocal<>();

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Obter conexao com o banco
	public static Connection conexaoPais() throws SQLException {
		if (conn.get() == null) {
			conn.set(DriverManager
					.getConnection("jdbc:mysql://localhost/dados?user=root&password=lucasvale"));
		}
	 return conn.get();
	}
	
	//Fechar Conexao com o banco
	public static void fecharConexao() throws SQLException{
		if (conn.get() != null) {
			conn.get().close();
			conn.set(null);
		}
	}
	
}
