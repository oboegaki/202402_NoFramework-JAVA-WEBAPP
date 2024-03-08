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
 * ログアウト処理するコントローラクラス
 */
@WebServlet("/logout-servlet")
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッションオブジェクト取得
        HttpSession session = request.getSession();

        // ログアウト処理
        Operation op = new Operation();
        op.logoutProc(session);

        // 転送先設定
        String url = "login.jsp";

        // 転送
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
