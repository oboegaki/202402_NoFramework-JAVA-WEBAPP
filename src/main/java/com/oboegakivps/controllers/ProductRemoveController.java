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
 * カートから商品を削除するコントローラクラス
 */
@WebServlet("/remove-prod-servlet")
public class ProductRemoveController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // パラメータの取得
        request.setCharacterEncoding("UTF-8");
        int idx = Integer.parseInt(request.getParameter("idx"));

        // セッションオブジェクト取得
        HttpSession session = request.getSession();

        // カートからの商品削除処理
        Operation op = new Operation();
        op.removeProd(idx, session);

        // 転送先設定
        String url = "cart.jsp";

        // 転送
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

}
