<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.oboegakivps.models.bean.Sales"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>購入履歴画面</title>
<%@include file="layouts/css.jsp"%>
</head>
<body>
    <%@include file="layouts/js.jsp"%>
    <%@include file="layouts/login-header-navi.jsp"%>

    <div class="container w-75 mx-auto">
        <h2>購入履歴画面</h2>
        <div class="progress mb-4">
            <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>

        <!-- 購入履歴一覧  -->
        <%
        List<Sales> list = (List<Sales>) request.getAttribute("history");
        if (list != null) {
        %>
        <table class="table table-hover border table-bordered">
            <thead>
                <tr class="table-defult">
                <!--     <th class="text-center">売上ID</th>  -->
                    <th class="text-center">商品ID</th>
                    <th class="text-center">商品名</th>
                    <th class="text-center">単価</th>
                    <th class="text-center">数量</th>
                    <th class="text-center">購入日</th>
                </tr>
            </thead>
            <tbody>
                <%
                for (Sales sales : list) {
                %>
                <tr>
                    <!-- <td class="align-middle text-center"><%=sales.getSalesId()%></td> -->
                    <td class="align-middle text-center"><%=sales.getProductId()%></td>
                    <td class="align-middle text-center"><%=sales.getProductName()%></td>
                    <td class="align-middle text-center"><%=sales.getPriceString()%></td>
                    <td class="align-middle text-center"><%=sales.getQuantity()%></td>
                    <td class="align-middle text-center"><%=sales.getSalesDate()%></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
        <%
        }
        %>
        <%@include file="layouts/error-message.jsp"%>
    </div>
</body>
</html>