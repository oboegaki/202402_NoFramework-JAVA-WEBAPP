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
<title>清算完了画面</title>
<%@include file="layouts/css.jsp"%>
</head>
<body>
    <%@include file="layouts/js.jsp"%>
    <%@include file="layouts/login-header-navi.jsp"%>
    <div class="container w-75 mx-auto">
        <h2>清算完了画面</h2>
        <div class="progress mb-4">
            <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <p>お買い上げ ありがとうございました。</p>

        <!-- 商品リストを表示  -->
        <%
        List<Product> listProd;
        Cart payData = (Cart) session.getAttribute("pay");
        if (payData == null) {
            listProd = new ArrayList<Product>();
        } else {
            listProd = payData.getListProd();
        }
        if (listProd.size() > 0) {
        %>
        <table class="table table-hover border table-bordered">
            <thead>
                <tr class="table-defult">
                    <th scope="col"></th>
                    <th scope="col">商品ID</th>
                    <th scope="col">商品名</th>
                    <th scope="col">価格</th>
                </tr>
            </thead>
            <tbody>
                <%
                for (Product prod : listProd) {
                %>
                <tr>
                    <td class="align-middle"><%=prod.getId()%></td>
                    <td class="align-middle"><%=prod.getName()%></td>
                    <td class="align-middle"><%=prod.getPriceString()%></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
        <br>
        <p>
            合計：<%=payData.getTotalPriceString()%>
            になります。
        </p>

        <%
        session.removeAttribute("pay"); // 精算済情報の削除
        }
        %>
    </div>
</body>
</html>