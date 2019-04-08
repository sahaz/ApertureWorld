package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CameraDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("         <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <style>\n");
      out.write("            .btn-round-lg{\n");
      out.write("border-radius: 22.5px;\n");
      out.write("}\n");
      out.write("        </style> \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("                                           ");
      out.write(" \n");
      out.write("     <body>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            \n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-sm-2\"></div>\n");
      out.write("        <div class=\"col-sm-8\">\n");
      out.write("            <br /> \n");
      out.write("            <h1 class=\"display-4 text-center\" >ApertureWorld</h1>\n");
      out.write("            <h2 class=\"display-6 text-center\">Camera Inventory</h2>\n");
      out.write("            <hr />\n");
      out.write("            \n");
      out.write("            <a href=\"ViewCamera.jsp\"><button type=\"button\" class=\"btn btn-sm \"> Back</button></a><br>\n");
      out.write("            <div class=\"row\">   \n");
      out.write("            <div class=\"col-sm-6 text-center\">\n");
      out.write("                <img src=\"images/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentcamera.camera_image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"rounded float-right\" height=\"400\" width=\"400\">\n");
      out.write("                <br /><br />\n");
      out.write("                <button type=\"button\" class=\"btn btn-lg btn-round-lg\"> <span class=\"glyphicon glyphicon-shopping-cart\" aria-hidden=\"true\"></span> Add to Cart </button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-6\">\n");
      out.write("                \n");
      out.write("            <table class=\"table table-borderless float-left\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentcamera.camera_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                  <td><p>Price: $ ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentcamera.camera_price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                  <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentcamera.camera_description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("           </div>\n");
      out.write("        <div class=\"col-sm-2\"></div>\n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("   </div>\n");
      out.write("    </body>\n");
      out.write("             <!--<link href=\"//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css\" rel=\"stylesheet\">-->\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
