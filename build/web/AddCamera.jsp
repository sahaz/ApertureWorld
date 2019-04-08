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
        <script src="//cdn.ckeditor.com/4.11.1/standard/ckeditor.js"></script>
     <style>
 .btn-round-lg{
border-radius: 22.5px;
}
 .alert{
  width: 100%;
  height: 50%;
  margin: 5px 2px 2px 5px;
  padding: 5px 5px 5px 5px;
}
.error{
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
            <h2 class="display-6 text-center">Add New Camera</h2>
            <hr />
             <a href="ViewCamera.jsp"><button type="button" class="btn btn-sm btn-round-lg"> Back</button></a>
             <c:if test="${errors.cameraAlreadyExists}">
        <div class="alert-danger float-right" role="alert">
            <p class="error">ERROR !! - Camera with that ID already exists. Please enter a new ID for camera.</p>
        </div>
           </c:if>
            <br />
            <br />
            <div class="row">
               
                <div class="col-lg-12">
                    <div class="container">
                        <form action="ValidateCameraServlet" method="POST">
    <div class="form-group row">
      <label for="inputId" class="col-sm-4 col-form-label text-right">PRODUCT ID :</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="inputId" name="camera_id" placeholder="Inventory Product id (AWXX)" value="${param.camera_id}">
      </div>
      <div class="col-sm-4">
           <c:if test="${errors.idMissing}">
        <div class="alert alert-danger" role="alert">
            <p class="error"> * ID must be entered.</p>
        </div>
           </c:if>
           <c:if test="${errors.idIllegal}">
        <div class="alert alert-danger" role="alert">
            <p class="error"> * ID Format Error !! Format: AWXXX where X is a number</p>
        </div>
           </c:if>
          </div>
    </div>
    <div class="form-group row">
      <label for="inputCategory" class="col-sm-4 col-form-label text-right">CATEGORY :</label>
      <div class="col-sm-4">
      <select name="camera_category" id="inputCategory" placeholder="Category" class="form-control form-control-sm">
         <option value="Default">Choose the camera category</option>
         <option value="DSLR" <c:if test="${param.camera_category == 'DSLR'}">selected="true"</c:if> >DSLR</option>
         <option value="Mirrorless" <c:if test="${param.camera_category == 'Mirrorless'}">selected="true"</c:if> >Mirrorless</option>
         <option value="Digital handheld" <c:if test="${param.camera_category == 'Digital handheld'}">selected="true"</c:if> >Digital Handheld</option>
      </select>
      </div>
       <div class="col-sm-4">
      <c:if test="${errors.categoryMissing}">
        <div class="alert alert-danger" role="alert">
            <p class="error"> * Choose one category.</p>  
        </div>
        </c:if>
      </div>
    </div>
     <div class="form-group row">
      <label for="inputName" class="col-sm-4 col-form-label text-right">PRODUCT NAME :</label>
      <div class="col-sm-4">
        <input type="text" name="camera_name" class="form-control" id="inputName" placeholder="Camera model name" value="${param.camera_name}">
      </div>
       <div class="col-sm-4">
       <c:if test="${errors.nameMissing}">
      <div class="alert alert-danger" role="alert">
          <p class="error"> * Camera Name must be entered.</p>  
</div>
      </c:if>
          </div>
    </div>
     <div class="form-group row">
      <label for="inputPrice" class="col-sm-4 col-form-label text-right">PRODUCT PRICE :</label>
      <div class="col-sm-4">
          <div class="input-group">
          <div class="input-group-prepend">
          <div class="input-group-text">$</div>
        </div>
              
        <input type="text" name="camera_price" class="form-control" id="inputPrice" placeholder="Camera's Price" value="${param.camera_price}">
      </div>
          </div>
       <div class="col-sm-4">
           <c:if test="${errors.priceMissing}">
      <div class="alert alert-danger" role="alert">
          <p class="error"> * Camera Price must be entered.</p>  
</div>
           </c:if> 
           <c:if test="${errors.priceNotNumeric}">
      <div class="alert alert-danger" role="alert">
          <p class="error"> * Enter only numeric values for Price.</p>  
</div>
           </c:if> 
          </div>
    </div>
    <div class="form-group row">
      <label for="inputDescription" class="col-sm-4 col-form-label text-right">PRODUCT DESCRIPTION :</label>
      <div class="col-sm-7">
        <textarea rows="5" cols="30" name="camera_description"  id="inputDescription" class="form-control"  placeholder="Camera's specification here ...">${param.camera_description}</textarea>
        <script>
			CKEDITOR.replace( 'camera_description' );
	</script>
      </div>
       <div class="col-sm-1">
           <c:if test="${errors.descriptionMissing}">
          <p class="error" style="color: red;">* Required.</p>  
           </c:if>
          </div>
    </div>
    <div class="form-group row">
      <label for="inputImage" class="col-sm-4 col-form-label text-right">PRODUCT IMAGE:</label>
      <div class="col-sm-8">
        <input type="file" name="camera_image" id="inputImage" />
         <p class="help-block">upload product image </p>
      </div>
    </div>
      <hr />
       <div class="form-group row">
           <label for="inputEmail" class="col-sm-4 col-form-label text-right"><i>Please enter your administrator email:<br />(For verification purpose)</i></label>
     <div class="col-sm-4">
        <input type="text" name="camera_email" class="form-control" id="inputEmail" placeholder="Your admin email" value="${param.camera_email}">
      </div>
       <div class="col-sm-4">
            <c:if test="${errors.emailMissing}">
      <div class="alert alert-danger" role="alert">
          <p class="error"> * Email must be entered.</p>  
</div>
            </c:if>
            <c:if test="${errors.emailIllegal}">
      <div class="alert alert-danger" role="alert">
          <p class="error"> * Email format error. Enter a valid email address</p>  
</div>
            </c:if>
          </div>
    </div>
      <div class="form-group row">
          <div class="col-sm-4"></div>
        <div class="col-sm-6 control-label">
  <input type="submit" class="btn btn-md btn-round-lg btn-info" id="submit" name="submit" value="Add Product" /><br><br>
        </div>
          <div class="col-sm-2"></div>
        </div>
  </form>
                        <br ><br ><br ><br >
            </div>
                </div>
               
            </div>
            
            </div>
        <div class="col-sm-2">
              <br />
            <br />
            <a href="CamerasCart.jsp"><img src="images/cart.png" class="text-center" height="80" width="80"></a>           
    </div>
        
   </div>
         <%@include file="/footer.jsp" %>
    </body>
</html>