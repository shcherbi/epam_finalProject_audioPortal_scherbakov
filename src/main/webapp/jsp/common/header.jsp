<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="properties.content"/>
<jsp:useBean id="orderList" class="java.util.HashSet" scope="session"/>
<header class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/web?command=main">
            <img src="../../images/logogreen.png" height="45px" width="55px">
        </a>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/jsp/user/about.jsp"><fmt:message key="page.header.about"/></a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><b class="allGreen">${orderList.size()}</b>
            </li>
            <li><a href="${pageContext.request.contextPath}/web?command=logout"><fmt:message key="page.header.logout"/></a></li>
        </ul>
        <div class="nav navbar-nav navbar-right">
            <div class="cart-brand">
                <a href="${pageContext.request.contextPath}/web?command=pre_order">
                    <img src="../../images/shoppingcartgreen.png" height="45px" width="55px">
                </a>
            </div>
        </div>
    </div>
</header>


