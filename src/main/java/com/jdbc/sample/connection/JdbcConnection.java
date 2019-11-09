package com.jdbc.sample.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/codenation"; //Nome da base de dados
            String user = "root"; //nome do usuário do MySQL
            String password = "root@123"; //senha do MySQL

            Connection conexao = null;
            conexao = DriverManager.getConnection(url, user, password);

            return conexao;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


}
