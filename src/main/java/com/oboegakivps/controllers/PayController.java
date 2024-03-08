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
 * 精算するコントローラクラス
 */
@WebServlet("/pay-servlet")
public class PayController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッションオブジェクト取得
        HttpSession session = request.getSession();

        String url = "pay.jsp"; // 転送先の初期化

        // 精算処理
        try {
            Operation op = new Operation();
            op.pay(session);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", "精算処理でエラーが発生しました。");
            url = "cart.jsp"; // 転送先の再設定
        }

        // 転送
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

}
