<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script src="Javascript/angular.js"></script>

<html ng-app="">
    <head>
        <title>Welcome to Online Store!</title>
    </head>

    <body>
        <div ng-init="myname='Alyssa'">
            <h1> My name is {{myname}}</h1>
            <label> Change Your Name </label>
            <input type="text" ng-model="myname" />            
        </div>
        <br>
        <div ng-init="hospitals=[
            {name:'St. Anthonys',area:'South County',patients:200},
            {name:'Barnes Jewish',area:'St. Louis City',patients:300},
            {name:'St. Marys',area:'St. Louis City',patients:250}]">           
            <table border="1">
                <tr ng-repeat="hospital in hospitals">
                    <td>{{hospital.name}}</td>
                    <td>{{hospital.area}}</td>
                    <td>{{hospital.patients}}</td>
                </tr>
            </table>
        
        </div>       
    </body>
</html>

