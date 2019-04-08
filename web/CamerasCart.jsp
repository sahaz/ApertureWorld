<%-- 
    Document   : CamerasCart
    Created on : Oct 31, 2018, 6:17:41 PM
    Author     : bushmaster
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
     <style>
            .btn-round-lg{
border-radius: 22.5px;
}
        </style> 

    </head>
    
    <body>
        <div class="container-fluid">
            
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <br /> 
            <h1 class="display-4 text-center" >ApertureWorld</h1>
            <h2 class="display-6 text-center">Your Cart</h2>
            <hr />
            <a href="ViewCamera.jsp"><button type="button" class="btn btn-sm btn-outline-secondary btn-round-lg "> Back</button></a>
            <br />
            <br />
            <table class="table">
            <thead class="thead-light">
            <th class="text-center">Image</th>
            <th class="text-center">Camera ID</th>
            <th class="text-center">Model Name</th>
            <th class="text-center">Price</th>        
            <th class="text-center">Options</th>
            </thead>
              <c:choose>
                <c:when test="${empty cameralist or cameralist.size == 0}">
                    <tr><td class="text-center" colspan="5">No cameras added yet</td></tr>
                </c:when>
            <c:otherwise>
            <c:forEach var="camera" items="${cameralist.cameras}">
                
                 <tr>
                    <td class="text-center"><img src="images/${camera.camera_image}" height="80" width="80" border="5" /></td>
                    <td class="text-center">${camera.camera_id} </td>
                    <td class="text-center">${camera.camera_name}</td>
                    <td class="text-center"> $ <fmt:formatNumber pattern="#,##0" value="${camera.camera_price}" /></td>

                    <td class="text-center">
                        <form action="DropCameraServlet">
                            <input type="submit" class="btn btn-sm btn-round-lg btn-outline-danger" value="Drop Item"/>                        
                            <input type="hidden" name="camera_id" 
                                   value="${camera.camera_id}"/>
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </c:otherwise>
            </c:choose>
                
            <thead class="thead-light">
                <th class="text-center" colspan="3">Total Price</th>
                <td class="text-center"><b>$ <fmt:formatNumber pattern="#,##0" value="${cart_total}" /></b></td>
                <td class="text-center"><button type="button" class="btn btn-sm btn-round-lg btn-outline-info">Checkout</button></b></td>
            </thead>
            
            </table></div>
        <div class="col-sm-2">
            <br />
            <br />
            <a href="CamerasCart.jsp"><img src="images/cart.png" class="text-center" height="80" width="80"></a></div>
    </div>
        
   </div>
                      <%@include file="/footer.jsp" %>
         </body>
</html>