package com.oboegakivps.config;

import java.util.ResourceBundle;

/**
 * 環境設定情報のヘルパークラス
 */
public class ENV {

    /**
     * DB接続キー
     */
    private static ResourceBundle rb = ResourceBundle.getBundle("env");

    /**
     * DB接続文字列
     */
    public static final String JDBC_URL = rb.getString("JDBC_URL");
    /**
     * DBユーザ名
     */
    public static final String DB_USER = rb.getString("DB_USER");
    /**
     * DBパスワード名
     */
    public static final String DB_PASS = rb.getString("DB_PASS");

}
