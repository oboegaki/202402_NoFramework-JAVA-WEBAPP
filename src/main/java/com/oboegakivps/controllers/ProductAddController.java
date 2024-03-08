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
 * カートに商品を追加するコントローラクラス
 */
@WebServlet("/add-prod-servlet")
public class ProductAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // パラメータ取得
        request.setCharacterEncoding("UTF-8");
        int idx = Integer.parseInt(request.getParameter("idx"));

        HttpSession session = request.getSession(); // セッションオブジェクト取得

        // カートへの商品追加処理
        Operation op = new Operation();
        op.addProd(idx, session);

        // 転送先設定
        //String url = "cart.jsp";
        String url = "select.jsp";

        // 転送
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
