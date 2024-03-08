<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.oboegakivps.models.bean.Cart"%>
<%@ page import="com.oboegakivps.models.bean.Product"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>カート一覧画面</title>
<%@include file="layouts/css.jsp"%>
</head>
<body>
    <%@include file="layouts/js.jsp"%>
    <%@include file="layouts/login-header-navi.jsp"%>

    <div class="container w-75 mx-auto">
        <h2>カート一覧画面</h2>
        <div class="progress mb-4">
            <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>

        <!-- カート一覧表示  -->
        <%
        List<Product> listProd;
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            listProd = new ArrayList<Product>();
        } else {
            listProd = cart.getListProd();
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
                    <td class="text-center">
                        <form action="remove-prod-servlet" method="POST">
                            <input type="hidden" name="idx" value="<%=idx%>"> <input class="btn btn-danger m-0 p-1 px-3" type="submit" value="削除">
                        </form>
                    </td>
                    <td class="text-center"><%=prod.getId()%></td>
                    <td class="text-center"><%=prod.getName()%></td>
                    <td class="text-center"><%=prod.getPriceString()%></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
        <form action="pay-servlet" method="post">
            <input class="btn btn-success m-3 p-3 px-3" type="submit" value="清算する">
        </form>
        <%
        } else {
        %>
        <p>カートの中は空です。</p>
        <%
        }
        %>
        <%@include file="layouts/error-message.jsp"%>
    </div>
</body>
</html>