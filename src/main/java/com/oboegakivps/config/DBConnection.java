package com.oboegakivps.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB接続クラス
 */
public class DBConnection {

    private Connection conn = null;

    /**
     * コネクションの接続を確立
     * @return Connection
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(ENV.JDBC_URL, ENV.DB_USER, ENV.DB_PASS);
        } catch (ClassNotFoundException | SQLException e) {
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
            e.printStackTrace();
        }
        return conn;
    }

}
