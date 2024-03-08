package com.oboegakivps.controllers;

import java.io.IOException;

import com.oboegakivps.models.service.Operation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * ログインを制御するコントローラクラス
 */
@WebServlet("/login-servlet")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        // ログイン処理＋転送先設定
        String url = "select.jsp"; // 転送先の初期化
        try {
            // ログイン処理
            HttpSession session = request.getSession(); // セッションオブジェクト取得
            Operation op = new Operation();
            boolean result = op.loginProc(userId, password, session);

            if (!result) { // 認証失敗の場合にはログイン画面に戻す
                request.setAttribute("errorMsg", "ユーザID または パスワードに 誤りがあります。");
                url = "login.jsp";
            } else if (password.equals("")) { // パスワード未設定の場合 chg-pass.jsp へ
                request.setAttribute("errorMsg", "パスワードを設定しましょう。");
                url = "chg-pass.jsp";
            }

        } catch (Exception e) { // 例外発生時にはログイン画面に戻す
            e.printStackTrace();
            request.setAttribute("errorMsg", "ログイン時にエラーが発生しました。");
            url = "login.jsp";
        }

        // 転送
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
