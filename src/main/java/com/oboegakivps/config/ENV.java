package com.oboegakivps.config;

import java.util.ResourceBundle;

/**
 * ���ݒ���̃w���p�[�N���X
 */
public class ENV {

    /**
     * DB�ڑ��L�[
     */
    private static ResourceBundle rb = ResourceBundle.getBundle("env");

    /**
     * DB�ڑ�������
     */
    public static final String JDBC_URL = rb.getString("JDBC_URL");
    /**
     * DB���[�U��
     */
    public static final String DB_USER = rb.getString("DB_USER");
    /**
     * DB�p�X���[�h��
     */
    public static final String DB_PASS = rb.getString("DB_PASS");

}
