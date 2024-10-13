package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao{
	
	private static final String url ="jdbc:mysql://127.0.0.1:3306/projetosalaaula";
    private static final String user= "root";
    private static final String password = "4019";
	
    private static Connection conn = null;
	public static Connection createConnection()   {
		
		try {
			if(conn == null) {
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("Conexão bem-sucedida!");
				return conn;
				}else {
					return conn;
					}
			}catch(SQLException e) {
				System.out.printf("Erro ao conectar ao Banco de Dados %s",e.getMessage());
				return null;
			}
		finally {
			return conn;
		}
		  
	}

}