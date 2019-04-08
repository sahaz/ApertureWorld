<%-- 
    Document   : ViewCamera
    Created on : Oct 25, 2018, 10:23:27 PM
    Author     : bushmaster
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ApertureWorld Camera Inventory</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
     <style>
            .btn-round-lg{
border-radius: 22.5px;
}
 .alert{
width: 100%;
border-radius: 35px;
}
.success{
    font-size: 12px;
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
            <h2 class="display-6 text-center">Camera Inventory</h2>
            
            <hr />
            <a href="AddCamera.jsp"><button type="button" class="btn btn-sm btn-outline-success btn-round-lg">+ Add a new Camera</button></a>
            <br />
            <br />
            <table class="table table-striped table-bordered">
            <thead class="thead-light">
            <th class="text-center">Camera ID</th>
            <th class="text-center">Image</th>
            <th class="text-center">Model Name</th>
            <th class="text-center">Price</th>
            <th class="text-center">Option</th>
            
            
            </thead>
            <c:forEach var="camera" items="${cameraarray.cameras}">
               
                <tr>
                    <td class="text-center">${camera.camera_id}</td>
                    <td class="text-center"><a href="ProductDetailServlet?camera_id=${camera.camera_id}"><img src="images/${camera.camera_image}" height="120" width="120" /></a></td>
                    <td class="text-center"><b>${camera.camera_name}</b></td>
                    <td class="text-center"><b> $ <fmt:formatNumber pattern="#,##0" value="${camera.camera_price}" /></b></td>
                    <td class="text-center"><a href="ProductDetailServlet?camera_id=${camera.camera_id}"><button type="button" class="btn btn-sm btn-outline-info btn-round-lg">View Item</button></a></td>
                </tr>
            </c:forEach>
        </table></div>
        <div class="col-sm-2">
              <br />
            <br />
            <a href="CamerasCart.jsp"><img src="images/cart.png" class="text-center" height="80" width="80"></a>
            <br /><hr />
            <c:if test="${add_success != null}">
                <div class="alert alert-success float-left" role="alert">
                <div class="success text-center">Successfully Added:</div>
                <div class="success text-center"><b>${add_success}</b></div>
                </div>
           </c:if>  
            
    </div>
   </div>
                  <%@include file="/footer.jsp" %>
    </body>
</html>