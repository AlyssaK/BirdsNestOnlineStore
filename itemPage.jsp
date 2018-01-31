<%-- 
    Document   : itemPage
    Created on : Dec 13, 2017, 3:41:56 PM
    Author     : Alyssa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="Javascript/angular.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/mainCSS.css" rel="stylesheet" type="text/css">
        <link href="CSS/itemCSS.css" rel="stylesheet" type="text/css">
        <title>Home</title>
    </head>
    <body>
        <header>
            <a href="main.jsp">
                <img src="pictures/newlogo.png" width="150" height="104" />          
                <h1>The Bird's Nest 
                    <p>Antiques and Vintage Treasures</p>
                </h1>               
            </a>                        
            <s:form id="search" action="SearchMerchandise" method="post">
                <s:textfield name="searchEntry" label="Search" required="true" />
                <s:submit id="search_button" value="Search!" />
            </s:form>
            <c:if test="${account.online}">
                <h2>Welcome, ${account.firstName}!</h2>
            </c:if>   
        </header>
        <div id="loginBox">                
            <s:form action="CustomerLogin" method="post">         
                <s:textfield name="email" label="Email" required="true" />
                <br>
                <s:password name="pattempt" id="password" label="Password" required="true" />
                <br>                
                <s:submit id="login_button" value="Log In!" />
                <a href="createAccount.jsp">Not a Member? Click Here!</a>                
            </s:form>                       
        </div>
        <nav>
            <div class="dropdown">
                <span>Shop By Department</span>
                <div class="dropdown-content">
                    <ul>
                        <c:forEach var="d" items="${departments}">
                        <li>
                            <s:form action="LoadDepartment" method="post">
                                <input type="hidden" name="departmentID" value="${d.ID}" />
                                <input type="submit" class="departmentSelect" value="${d.name}" />
                            </s:form>
                        </li>         
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <a href="manageAccount.jsp">My Account</a>
            <a href="myCart.jsp">My Cart</a>
        </nav>
        <main>
            <img src="${viewItem.picture}" id="picture" width="250" height="250" />
            <img src="${viewItem.picture2}" id="picture2" width="250" height="250" />
            <h1>${viewItem.name}</h1>
            <p>${viewItem.description}</p>
            <p>${viewItem.priceF}</p>
            <c:if test="${viewItem.onSale}">
                <p>${viewItem.salesPriceF}}</p>
            </c:if>
            <s:form action="AddToCart" method="post">
                <input type="hidden" name="itemID" value="${viewItem.ID}" />               
                <br>
                <input type="submit" value="Add To Cart" />
            </s:form>
        </main>
    </body>
</html>