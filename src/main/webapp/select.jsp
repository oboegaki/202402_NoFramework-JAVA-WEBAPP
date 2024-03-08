<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.oboegakivps.models.bean.Store"%>
<%@ page import="com.oboegakivps.models.bean.Product"%>
<%@ page import="com.oboegakivps.models.bean.Cart"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品一覧画面</title>
<%@include file="layouts/css.jsp"%>
</head>
<body>
    <%@include file="layouts/js.jsp"%>
    <%@include file="layouts/login-header-navi.jsp"%>

    <div class="container w-75 mx-auto">
        <h2>商品一覧画面</h2>
        <div class="progress mb-4">
            <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>

        <!-- カートの合計数をバッチに表示  -->
        <%
        String cartTotal = "0";
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            cartTotal = cart.getListTotalString();
        }
        %>
        <div class="list-group mb-3">
            <div class="ms-auto">
                <a href="cart.jsp" class="btn btn-primary">
                <i class="fa-solid fa-cart-shopping"></i>
                 <span>カートをみる</span> <span class="badge bg-danger rounded-pill ms-2"><%=cartTotal%></span>
                </a>
            </div>
        </div>

        <!-- 商品リストを表示  -->
        <%
        List<Product> listProd;
        Store store = (Store) session.getAttribute("store");
        if (store == null) {
            listProd = new ArrayList<Product>();
        } else {
            listProd = store.getListProd();
        }
        if (listProd.size() > 0) {
        %>
        <table class="table table-hover border table-bordered">
            <thead>
                <tr class="table-defult">
                    <th style="width: 15%" scope="col" class="text-center"></th>
                    <th style="width: 25%" scope="col" class="text-center">商品ID</th>
                    <th style="width: 25%" scope="col" class="text-center">商品名</th>
                    <th style="width: 25%" scope="col" class="text-center">価格</th>
                </tr>
            </thead>
            <tbody>
                <%
                for (int idx = 0; idx < listProd.size(); idx++) {
                    Product prod = listProd.get(idx);
                %>
                <tr>
                    <td class="align-middle text-center">
                        <form class="btn btn-success m-0 p-1 px-2 ms-auto" action="add-prod-servlet" method="POST">
                            <input type="hidden" name="idx" value="<%=idx%>"> 
                            <i class="fas fa-plus"></i>
                            <input class="btn bg-success" type="submit" value="商品追加">
                        </form>
                    </td>
                    <td class="align-middle text-center"><%=prod.getId()%></td>
                    <td class="align-middle text-center"><%=prod.getName()%></td>
                    <td class="align-middle text-center"><%=prod.getPriceString()%></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
        <%
        }
        %>
    </div>
</body>
</html>