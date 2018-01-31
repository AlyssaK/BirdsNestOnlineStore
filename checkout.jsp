<%-- 
    Document   : checkout
    Created on : Jan 3, 2018, 6:12:38 PM
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
        <link href="CSS/CheckoutCSS.css" rel="stylesheet" type="text/css">
        <title>Home</title>
        <script type="text/javascript" src="https://js.squareup.com/v2/paymentform"></script>
        <script type="text/javascript" src="Javascript/sqpaymentform.js"></script>
        <link rel="stylesheet" type="text/css" href="CSS/sqpaymentform.css">
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
            <div id="wrapper">
                <c:forEach var="d" items="${account.purchases}">
                    <p><span>Item:</span> ${d.name} <span>Price:</span><c:if test="${!d.onSale}">${d.priceF}</c:if><c:if test="${d.onSale}">${d.salesPriceF}</c:if></p>     
                    </c:forEach>    
                </table>
                <p><span>Subtotal:</span> ${subtotalF}</p>
                <p><span>Tax:</span> ${taxF}</p>
                <p><span>Total:</span> ${totalF}</p>
            </div>
            <div id="sq-ccbox">
  
                <form id="nonce-form" novalidate action="PaymentReceived" method="post">
                  Pay with a Credit Card
                  <table>
                  <tbody>
                    <tr>
                      <td>Card Number:</td>
                      <td><div id="sq-card-number"></div></td>
                    </tr>
                    <tr>
                      <td>CVV:</td>
                      <td><div id="sq-cvv"></div></td>
                    </tr>
                    <tr>
                      <td>Expiration Date: </td>
                      <td><div id="sq-expiration-date"></div></td>
                    </tr>
                    <tr>
                      <td>Postal Code:</td>
                      <td><div id="sq-postal-code"></div></td>
                    </tr>
                    <tr>
                      <td colspan="2">
                        <button id="sq-creditcard" class="button-credit-card" onclick="requestCardNonce(event)">
                          Pay with card
                        </button>
                      </td>
                    </tr>
                  </tbody>
                  </table>

                  <!--
                    After a nonce is generated it will be assigned to this hidden input field.
                  -->
                  <input type="hidden" id="subtotal" value="${subtotal}">
                  <input type="hidden" id="tax" value="${tax}">
                  <input type="hidden" id="total" value="${total}">
                  <input type="hidden" id="card-nonce" name="nonce">
                </form>
            </div>

            <div id="sq-walletbox">
              Pay with a Digital Wallet
              <div id="sq-apple-pay-label" class="wallet-not-enabled">Apple Pay for Web not enabled</div>
              <!-- Placeholder for Apple Pay for Web button -->
              <button id="sq-apple-pay" class="button-apple-pay"></button>

              <div id="sq-masterpass-label" class="wallet-not-enabled">Masterpass not enabled</div>
              <!-- Placeholder for Masterpass button -->
              <button id="sq-masterpass" class="button-masterpass"></button>
            </div>
        </main>
    </body>
</html>
