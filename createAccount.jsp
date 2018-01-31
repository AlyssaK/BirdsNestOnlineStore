<%-- 
    Document   : createAccount
    Created on : Nov 28, 2017, 3:58:59 PM
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
        <link href="CSS/createCSS.css" rel="stylesheet" type="text/css">
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
                        </li>
                    </ul>
                </div>
            </div>
            <a href="manageAccount.jsp">My Account</a>
            <a href="myCart.jsp">My Cart</a>
        </nav>
        <main>
            <h1>Create Your Account!</h1>
            <s:form action="AccountCreate" cssClass="accountForm" theme="simple" method="post">         
                <table>
                    <tr>                            
                        <td><span class="accountLabel">First Name:</span></td>
                        <td><s:textfield name="firstName" cssClass="accountEntry" required="true" /></td>
                    </tr>
                    <tr>
                        <td><span class="accountLabel">Last Name:</span></td>
                        <td><s:textfield name="lastName" cssClass="accountEntry" required="true" /></td>
                    </tr>
                    <tr>
                        <td><span class="accountLabel">Email:</span></td>
                        <td><s:textfield name="email" cssClass="accountEntry" required="true" /></td>
                    </tr>
                     <tr>
                        <td><span class="accountLabel">Address:</span></td>
                        <td><s:textfield name="address" cssClass="accountEntry" required="true" /></td>
                    </tr>
                     <tr>
                        <td><span class="accountLabel">Address 2:</span></td>
                        <td><s:textfield name="address2" cssClass="accountEntry" required="false" /></td>
                    </tr>
                     <tr>
                        <td><span class="accountLabel">City:</span></td>
                        <td><s:textfield name="city" cssClass="accountEntry" required="true" /></td>
                    </tr>
                     <tr>
                        <td><span class="accountLabel">State:</span></td>
                        <td><s:textfield name="state" cssClass="accountEntry" required="true" /></td>
                    </tr> 
                    <tr>
                        <td><span class="accountLabel">Zipcode:</span></td>
                        <td><s:textfield name="zipcode" cssClass="accountEntry" required="true" /></td>
                    </tr>
                    <tr>
                        <td><span class="accountLabel">Password:</span></td>
                        <td><s:password name="password1" cssClass="accountEntry" required="true" /></td>
                    </tr>
                    <tr>
                        <td><span class="accountLabel">Password:</span></td>
                        <td><s:password name="password2" cssClass="accountEntry" required="true" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><s:submit id="login_button" value="Sign Up!" /></td>
                    </tr>                              
            </s:form>   
             <p>${msg}</p>
        </main>
                     
    </body>
</html>
