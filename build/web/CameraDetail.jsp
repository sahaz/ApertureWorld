<%-- 
    Document   : CameraDetail
    Created on : Oct 30, 2018, 11:18:14 PM
    Author     : bushmaster
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${currentcamera.camera_name}</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <style>
            .btn-round-lg{
border-radius: 22.5px;
margin-top: 5px;
}
.breaking{    
    word-wrap: break-word;
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
            <h2 class="display-6 text-center">Product Detail </h2>
            <hr />
            <a href="ViewCamera.jsp"><button type="button" class="btn btn-sm btn-outline-secondary btn-round-lg"> Back</button></a><br>
            <div class="row">   
            <div class="col-sm-6 text-center">
                <br /><br />
                <img src="images/${currentcamera.camera_image}" class="rounded float-center" height="400" width="400" border="5">
                <br /><br />
                <form action="AddCameraServlet">
                    <input type="submit" class="btn btn-md btn-outline-info btn-round-lg" value="Add to Cart"/>                        
                    <input type="hidden" name="camera_id" value="${currentcamera.camera_id}"/>
                </form>
            </div>
            <div class="col-sm-6">
                      <br /><br />
            <table class="table table-borderless float-left">
                <tr>
                    <td><h2 class="display-4">${currentcamera.camera_name}</h2></td>
                </tr>
                <tr>
                  <td><h3 class="display-5">Price: $ <fmt:formatNumber pattern="#,##0" value="${currentcamera.camera_price}" /></h3></td>
                </tr>
                <tr>
                  <td><h6 class="display-6">Added by: ${currentcamera.camera_email}</h6></td>
                </tr>
                <tr>
                    <td><hr><p class="text-justify font-weight-light breaking">${currentcamera.camera_description}</p></td>
                </tr>
                
            </table>
            </div>
            </div>
           </div>
                <div class="col-sm-2">
                    <br />
                    <br />
                    <a href="CamerasCart.jsp"><img src="images/cart.png" height="80" width="80"></a>
                </div>
    </div>
        
   </div>
                 <%@include file="/footer.jsp" %>
    </body>
           
</html>
