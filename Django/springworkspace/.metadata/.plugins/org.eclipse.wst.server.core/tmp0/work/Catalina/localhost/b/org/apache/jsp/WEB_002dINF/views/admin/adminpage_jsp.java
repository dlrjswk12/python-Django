/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2021-04-14 05:38:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.a.b.service.*;

public final class adminpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/WEB-INF/views/admin/foot.jsp", Long.valueOf(1617158347219L));
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1617064902894L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-3.1.1.RELEASE.jar", Long.valueOf(1611191598157L));
    _jspx_dependants.put("jar:file:/J:/springworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ebook()%20test3/WEB-INF/lib/spring-webmvc-3.1.1.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1329370132000L));
    _jspx_dependants.put("jar:file:/J:/springworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ebook()%20test3/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1064301420000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("com.a.b.service");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<meta name=\"description\" content=\"adminpage.jsp\">\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write(".h1 {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("} \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");

	String id = (String) session.getAttribute("id");
	

      out.write("\r\n");
      out.write("\r\n");
 if (id =="admin"){ 
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\talert('????????? ?????????');\r\n");
      out.write("\t\tdocument.location.href=\"main\";\r\n");
      out.write("\t</script>\r\n");
      out.write("\t");
}
      out.write("\r\n");
      out.write("<!-- <link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\r\n");
      out.write("\tintegrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\"\r\n");
      out.write("\tcrossorigin=\"anonymous\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"\r\n");
      out.write("\tintegrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script> -->\r\n");
      out.write("\t<title>Home</title>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<link href=\"/b/css1/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"/b/css1/bootstrap-theme.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"/b/css1/plugins/metisMenu/metisMenu.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"/b/css1/plugins/dataTables.bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"/b/css1/sb-admin-2.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"/b/css1/morris.css\" rel=\"stylesheet\">\t \r\n");
      out.write("\t\r\n");
      out.write("<!-- <script src=\"http://code.jquery.com/jquery-latest.js\"></script>\t\r\n");
      out.write("<script src=\"https://code.highcharts.com/highcharts.js\"></script>\r\n");
      out.write("<script src=\"https://code.highcharts.com/highcharts-3d.js\"></script>\r\n");
      out.write("<script src=\"https://code.highcharts.com/modules/exporting.js\"></script>\r\n");
      out.write("<script src=\"https://code.highcharts.com/modules/export-data.js\"></script>\r\n");
      out.write("<script src=\"https://code.highcharts.com/modules/accessibility.js\"></script>\t -->\r\n");
      out.write("\t\r\n");
      out.write("<script src=\"/b/js/jquery-1.9.1.js\"></script>\r\n");
      out.write("<script src=\"/b/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"/b/js/plugins/metisMenu/metisMenu.min.js\"></script>\r\n");
      out.write("<script src=\"/b/js/plugins/dataTables/jquery.dataTables.js\"></script>\r\n");
      out.write("<script src=\"/b/js/sb-admin-2.js\"></script>\r\n");
      out.write("<script src=\"/b/js/plugins/dataTables/dataTables.bootstrap.js\"></script>\r\n");
      out.write("<script src=\"/b/js/morris.min.js\"></script>\r\n");
      out.write("<script src=\"/b/js/raphael.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type = \"text/javascript\">\t\r\n");
      out.write("\t\r\n");
      out.write("\tvar sort;\r\n");
      out.write("\tvar url;\r\n");
      out.write("\t\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\tvar objDonut = JSON.parse('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${objDonut}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("');\r\n");
      out.write("    \tvar objBar = JSON.parse('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${objBar}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("');\r\n");
      out.write("\t\tsort = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sort}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\t\r\n");
      out.write("\tif('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sort}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("' != null) $(\"#sort\").val(sort);\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#sort\").change(function(){\r\n");
      out.write("\t\tsort = $(\"#sort\").val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(sort == 'category'){\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}else if(sort == 'publisher'){\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t}else if(sort == 'author'){\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t location.href = sort+\"?sort=\"+sort;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t \r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t Morris.Donut({\r\n");
      out.write("            element: 'donutChart',\r\n");
      out.write("            data: objDonut,\r\n");
      out.write("            resize: true\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        Morris.Bar({\r\n");
      out.write("            element: 'barChart',\r\n");
      out.write("            data: objBar,\r\n");
      out.write("            xkey: 'y',\r\n");
      out.write("            ykeys: ['a'],\r\n");
      out.write("            labels: ['????????? ??????'],\r\n");
      out.write("            hideHover: 'auto',\r\n");
      out.write("            resize: true\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\t</script>\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<form  action = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sort}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\t<table width=\"100%\" border=\"0\">\r\n");
      out.write("\t\t<tr>\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t<td><a href=\"adminpage\" style=\"text-decoration: none\"><img src=\"");
      if (_jspx_meth_spring_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" height=\"100\" alt=\"??????????????????\"></a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</td>\t\t\r\n");
      out.write("\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div align =\"center\">\r\n");
      out.write("\t\t\t\t\t<h1>????????? ?????????</h1>\r\n");
      out.write("\t\t\t\t</div>\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td align=\"center\" ><h3 class=\"y\">");
      out.print(id);
      out.write("???</h3>\r\n");
      out.write("\t");

 	if (id.equals("admin")) { 
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");

					}  {
				
      out.write("\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\" onclick=\"location.href='logout'\">????????????</button>\r\n");
      out.write("\t\t\t\t");

						
				
      out.write("\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\" onclick=\"location.href='main'\">?????????</button>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t<td colspan=\"3\"><hr/></td>\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr height=\"50\" colspan=\"3\">\r\n");
      out.write("\t\t\t<td align=\"center\"><h2><a href=\"AdminBookList\">?????? ??????</a></h2></td>\t\r\n");
      out.write("\t\t\t<td align=\"center\"><h2><a href=\"adminboardList\">?????? ?????????</a></h2></td>\r\n");
      out.write("\t\t\t<td align=\"center\"><h2><a href=\"AdminMemberList\">????????????</a></h2></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"jumbotron jumbotron-info\" style=\"background-color: white;\">\r\n");
      out.write("\t\t\t<h1><font color=\"black\"><strong>??????</strong>&nbsp;<span class=\"glyphicon glyphicon glyphicon-pencil\"></span></font></h1>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t   \t\t<h1 class=\"page-header\">\r\n");
      out.write("\t\t\t    \t<label class=\"glyphicon glyphicon-list-alt fa-lg\"></label>&nbsp;<i><b>??????</b></i>\r\n");
      out.write("\t\t        </h1>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t\t <div class=\"row\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"col-md-2\">\r\n");
      out.write("\t\t\t\t<select class=\"form-control\" id=\"sort\" name=\"sort\" type = \"submit\">\r\n");
      out.write("\t\t\t\t\t <option value=\"category\" >????????????</option>\t\r\n");
      out.write("\t\t\t\t\t<option value=\"publisher\" >????????????</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</form >\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div> \r\n");
      out.write("\t    <div class=\"row\">\r\n");
      out.write("\t\t\t<div id=\"donutChart\"></div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div id=\"barChart\"></div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\r\n");
      out.write("\t\t <<!-- div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-1 col-md-offset-11\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-success btn-lg\"  style=\"float:right;\" onclick=\"fn_back()\">????????????</button>\r\n");
      out.write("\t\t\t</div> \r\n");
      out.write("\t\t</div> -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      boolean _jspx_th_c_005fset_005f0_reused = false;
      try {
        _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fset_005f0.setParent(null);
        // /WEB-INF/views/admin/foot.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fset_005f0.setVar("context");
        int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
        if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = org.apache.jasper.runtime.JspRuntimeLibrary.startBufferedBody(_jspx_page_context, _jspx_th_c_005fset_005f0);
          }
          do {
            out.print(request.getContextPath());
            int evalDoAfterBody = _jspx_th_c_005fset_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.popBody();
          }
        }
        if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.reuse(_jspx_th_c_005fset_005f0);
        _jspx_th_c_005fset_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
      }
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<footer style=\"text-align: center;\">\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t<h4>\r\n");
      out.write("\t\t<p>??????????????? ?????? TEL. 010-1111-7777 / FAX. 02-2321-5819</p>\r\n");
      out.write("\t\t<p>Copyright &copy;2015 ?????? LIBRARY. Allright Reserved.</p>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t</h4>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_spring_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_005furl_005f0 = (org.springframework.web.servlet.tags.UrlTag) _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    boolean _jspx_th_spring_005furl_005f0_reused = false;
    try {
      _jspx_th_spring_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_spring_005furl_005f0.setParent(null);
      // /WEB-INF/views/admin/adminpage.jsp(130,67) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_spring_005furl_005f0.setValue("/resources/img/LOGO2.png");
      int[] _jspx_push_body_count_spring_005furl_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_spring_005furl_005f0 = _jspx_th_spring_005furl_005f0.doStartTag();
        if (_jspx_th_spring_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_005furl_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_005furl_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_005furl_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_spring_005furl_005f0);
      _jspx_th_spring_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_spring_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_spring_005furl_005f0_reused);
    }
    return false;
  }
}
