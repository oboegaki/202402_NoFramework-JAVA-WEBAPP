<%@ page pageEncoding="UTF-8"%>
<%@ page import="com.oboegakivps.models.bean.Cart"%>
<%@ page import="com.oboegakivps.models.bean.Store"%>

<%
Store storeHdr = (Store) session.getAttribute("store");
Cart cartHdr = (Cart) session.getAttribute("cart");
if ((storeHdr == null) || cartHdr == null) {
    request.setAttribute("errorMsg", "再ログインをお願いします。");
    request.getRequestDispatcher("login.jsp").forward(request, response);
} else {
%>

<%-- ナビ表示 --%>
<nav class="navbar navbar-expand-lg bg-dark mb-4" data-bs-theme="dark">
    <div class="container-fluid">
        <div id="navbarColor02">
            <ul class="navbar-nav mx-auto pe-4">
                <li class="nav-item text-white">TODO-1-No1(MVC-SHOP)</li>
            </ul>
        </div>
        <div class="collapse navbar-collapse" id="navbarColor02">
            <ul class="navbar-nav me-auto">
                <li class="nav-item"><a class="nav-link text-decoration-underline" href="select.jsp"><i class="fa-solid fa-shop pe-1"></i>商品一覧</a></li>
                <li class="nav-item"><a class="nav-link text-decoration-underline" href="cart.jsp"><i class="fa-solid fa-cart-shopping pe-1"></i>カート</a></li>
                <li class="nav-item"><a class="nav-link text-decoration-underline" href="get-history-servlet"><i class="fa-solid fa-money-check-dollar pe-1"></i>購入履歴</a></li>
                <!-- <li class="nav-item"><a class="nav-link text-decoration-underline" href="chg-pass.jsp">パスワード変更</a></li>  -->
            </ul>
            <div>
                <div class="text-white pb-0 mb-0">
                    ユーザID：<%=cartHdr.getUserId()%>
                </div>
                <div>
                    <a class="nav-link text-white text-decoration-underline text-end" href="logout-servlet"><i class="fa-solid fa-right-from-bracket pe-1"></i>ログアウト</a>
                </div>
            </div>
            <!-- 
                <form class="d-flex">
                    <input class="form-control me-sm-2" type="search" placeholder="商品検索">
                    <button class="btn btn-secondary my-2 my-sm-0" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </form>
            -->
        </div>
    </div>
</nav>
<%
}
%>