package com.oboegakivps.models.bean;

/**
 * パスワードを表すクラス(DTO/Entity)
 */
public class Password {

    /**
     * ユーザID
     */
    private String userId;

    /**
     * パスワード
     */
    private String password;

    public Password() {
    }

    /**
     * コンストラクタ
     * @param userId
     * @param password
     */
    public Password(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    /**
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId セットする userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password セットする password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
