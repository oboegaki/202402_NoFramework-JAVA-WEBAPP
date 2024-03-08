package com.oboegakivps.controllers;

import java.io.IOException;
import java.util.List;

import com.oboegakivps.models.bean.Cart;
import com.oboegakivps.models.bean.Sales;
import com.oboegakivps.models.service.Operation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 購入履歴を制御するコントローラクラス
 */
@WebServlet("/get-history-servlet")
public class GetHistoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 転送先設定
        String url = "history.jsp";

        try {
            // ユーザID 取得
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            String userId = cart.getUserId();

            // 売上リスト（購入履歴）取得処理
            Operation op = new Operation();
            List<Sales> salesList = op.getHistory(userId);
            if (!salesList.isEmpty()) {
                request.setAttribute("history", salesList);
            } else {
                request.setAttribute("errorMsg", "購入履歴がありません。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", "購入履歴取得時にエラーが発生しました。");
        }

        // 転送
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
