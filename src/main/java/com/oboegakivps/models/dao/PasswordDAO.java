package com.oboegakivps.models.dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import com.oboegakivps.config.DBConnection;
import com.oboegakivps.models.bean.Password;

/**
 * パスワード情報用のDAO
 */
public class PasswordDAO extends DBConnection {

    /**
     * パスワード変更
     * @param password パスワードオブジェクト
     * @return 処理件数
     * @throws Exception
     */
    public int update(Password password) throws Exception {
        int cnt = 0;

        String sql = " UPDATE m_password " + " SET    password = ? " + " WHERE  user_id = ? ";

        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(2, password.getUserId());
            pstmt.setString(1, password.getPassword());

            cnt = pstmt.executeUpdate(); // レコード更新処理の実行
        }

        return cnt;
    }

    /**
     * ユーザIDよりパスワード取得
     * @param userId
     * @return パスワード（文字列）
     * @throws Exception DB関連のエラー・レコードが存在しない場合
     */
    public String selectById(String userId) throws Exception {

        String password = null; // 戻り値の初期化

        String sql = " SELECT password    " + " FROM m_password    " + " WHERE user_id = ?  ";

        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, userId);

            try (ResultSet res = pstmt.executeQuery()) {

                if (res.next()) {
                    password = res.getString("password");
                } else {
                    throw new Exception();
                }
            }
        }

        return password;
    }

    /**
     * ハッシュ化
     * @param password
     * @return ハッシュ化した結果
     * @throws Exception
     */
    public static String hashPassword(String password) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] digest = md.digest();

        return Base64.getEncoder().encodeToString(digest);
    }

}
