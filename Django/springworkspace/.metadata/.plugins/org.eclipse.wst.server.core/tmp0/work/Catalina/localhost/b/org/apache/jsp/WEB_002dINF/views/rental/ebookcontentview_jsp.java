/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2021-04-15 02:22:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.rental;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.ibatis.reflection.SystemMetaObject;
import java.util.ArrayList;
import com.a.b.dto.*;
import java.util.*;
import com.a.b.dao.EDao;
import com.a.b.dao.MDao;

public final class ebookcontentview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/WEB-INF/views/rental/../bottom.jsp", Long.valueOf(1616634612102L));
    _jspx_dependants.put("/WEB-INF/views/rental/../home.jsp", Long.valueOf(1617171804779L));
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1617064902894L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-3.1.1.RELEASE.jar", Long.valueOf(1611191598157L));
    _jspx_dependants.put("jar:file:/J:/springworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ebook()%20test3/WEB-INF/lib/spring-webmvc-3.1.1.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1329370132000L));
    _jspx_dependants.put("jar:file:/J:/springworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ebook()%20test3/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1064301420000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("com.a.b.dto");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.apache.ibatis.reflection.SystemMetaObject");
    _jspx_imports_classes.add("com.a.b.dao.EDao");
    _jspx_imports_classes.add("com.a.b.dao.MDao");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody;

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
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.release();
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
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\r\n");
      out.write("\tintegrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\"\r\n");
      out.write("\tcrossorigin=\"anonymous\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"\r\n");
      out.write("\tintegrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<title>??? ?????? ??????</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/main_css.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\r\n");
      out.write("\tintegrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\"\r\n");
      out.write("\tcrossorigin=\"anonymous\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"\r\n");
      out.write("\tintegrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");

	String id = (String) session.getAttribute("id");
	if (id == null) {
		id = "GUEST";
	}

      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.8.1.js\"></script> \r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\t$(\".main>li\").mouseover(function() {\r\n");
      out.write("\t\t$(this).children(\".sub\").stop().slideDown(); });\r\n");
      out.write("\t$(\".main>li\").mouseleave(function() {\r\n");
      out.write("\t\t$(this).children(\".sub\").stop().slideUp();\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<link href=\"/css/main_css.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"http://malsup.github.com/jquery.cycle2.js\"></script>\r\n");
      out.write("<script src=\"/script/jquery-3.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>??????</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=wrapper>\r\n");
      out.write("\t\t<header>\r\n");
      out.write("\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t<a href=\"main\" style=\"text-decoration: none\"><img src=\"");
      if (_jspx_meth_spring_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" height=\"100px\" alt=\"??????????????????\"></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"name\">\r\n");
      out.write("\t\t\t<img src=\"");
      if (_jspx_meth_spring_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" height=\"100px\" alt=\"?????????\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"loginmenu\">\r\n");
      out.write("\t\t\t<h3 class=\"y\"><font color=\"white\">");
      out.print(id);
      out.write("</font></h3>\r\n");
      out.write("\t");

 	if (id.equals("GUEST")) { 
      out.write("\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\" onclick=\"location.href='login'\">?????????</button>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\" onclick=\"location.href='memberjoin'\">????????????</button>\r\n");
      out.write("\t\t\t\t");

					} else {
				
      out.write("\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\" onclick=\"location.href='logout'\">????????????</button>\r\n");
      out.write("\t\t\t\t");

					}if (id.equals("admin")){
						
      out.write("\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\" onclick=\"location.href='adminpage'\">????????????</button>\r\n");
      out.write("\t\t\t\t\t\t");

					}else if(!id.equals("GUEST")) {
						
      out.write("\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\" onclick=\"location.href='memdata?bId=");
      out.print(id);
      out.write("'\">????????????</button>\r\n");
      out.write("\t\t\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<nav class=\"mainmenu\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><h3><a href=\"list\">?????? ??????</a></h3>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"sub\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"list\">??????</a>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">?????????/?????????</a>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li><h3><a href=\"rentalinglist\">?????? ??????</a></h3>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"sub\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"rentalinglist\">?????? ?????? ??????</a>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"rentallist\">??? ?????? ??????</a>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><h3><a href=\"boardList\">?????????</a></h3>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"sub\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"boardList\">?????? ?????????</a>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">?????? ?????????</a>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">??? ??? ??????</a>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li><h3><a href=\"cashup\">????????????/??????</a></h3></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write('\r');
      out.write('\n');
  System.out.println("??????????????????????????? ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
	String boo2;
	try
	{long boo1 = (Integer)request.getAttribute("ebook_view3");
	boo2 = String.valueOf(boo1);
	System.out.println("????????? ?????????");
	}
	catch (NullPointerException e)
	{boo2 = "1";
	System.out.println("????????? ?????????");
	}
	
	

      out.write("\t\r\n");
      out.write("\r\n");

	
	Integer coin = (Integer)session.getAttribute("cash");
	
	if(coin == null){
		coin = 0;
	}

	String vo = (String)session.getAttribute("id");
	if (vo == null) {
	vo = "GUEST";
}
	String Rno1 = request.getParameter("Rno");
	System.out.println("?????????:"+Rno1);
	String Rno2 = "Rno";
	
	String Ryes1 = request.getParameter("Ryes");
	String Ryes2 = "Ryes";

	if(Rno1 != null){
	 	if (Rno1.equals(Rno2)) { 
		
      out.write("\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\talert('????????? ???????????? ????????? ??????????????????.');\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t");
}
	 	}
      out.write("\r\n");
      out.write("\t \t\r\n");
      out.write("\t");
 if(Ryes1 != null){
	 	if (Ryes1.equals(Ryes2)) { 
		
      out.write("\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\talert('????????? 3???????????? ????????? ????????????');\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t");
}
	 	}
	

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<p><br></p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border=\"1\" align = \"center\" style =\"width:60%\" class=\"table table-dark table-striped table-hover\">\r\n");
      out.write("\t<tr align = \"center\">\r\n");
      out.write("\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ebook_view.bBookno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t<td>?????? ?????? ?????? : 3</td>\r\n");
      out.write("\t\t<td >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ebook_view.getbBookname()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align = \"center\">\r\n");
      out.write("\t\t\t<td colspan=\"2\" rowspan=\"1\"><img src=\"");
      if (_jspx_meth_spring_005furl_005f2(_jspx_page_context))
        return;
      out.write("\" \r\n");
      out.write("\t\t\t\theight=\"300\"></td>\r\n");
      out.write("\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ebook_view.bContent}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t\t<tr align = \"center\">\r\n");
      out.write("\t\t<td>?????? : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ebook_view.bWriter}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t<td>????????? : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ebook_view.bPublisher}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t<td>?????? : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ebook_view.bCategory}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<div align = \"center\">\r\n");
      out.write("<p>???????????? ???????????? : ");
      out.print( coin );
      out.write("</p>\r\n");
      out.write("<p>??????????????? ?????? ??? ???????????? : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ebook_view2}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" </p>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div align = \"center\">\r\n");
	if (vo.equals("GUEST")) { 
      out.write("\r\n");
      out.write(" \t\t\t<button class=\"btn btn-primary\">???????????? ??????????????? ??????????????????</button>\r\n");
      out.write(" \t\t");
	} else {
					
		if (boo2.equals("0")) {
      out.write("\r\n");
      out.write("\t\t\t<form name = \"rental\" action=\"rentaldo\" method = \"POST\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name = \"bBookno1\" value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ebook_view.bBookno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name = \"bId1\" value = \"");
      out.print( vo );
      out.write("\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name = \"cash1\" value = \"");
      out.print( coin );
      out.write("\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name = \"bBookname1\" value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ebook_view.getbBookname()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">????????????</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t");
	}else {	
      out.write("\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\">?????? ????????? ????????????</button>\r\n");
      out.write("\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t<form name = \"textgo\" action= \"textdo\" method = \"POST\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name = \"bBookno1\" value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ebook_view.bBookno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name = \"bBookname1\" value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ebook_view.bBookname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\" type=\"submit\">????????? ????????????!</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<br><br>\r\n");
      out.write("\t\t\t");
 } } 
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t<footer>\r\n");
      out.write("\t\t<div class=\"fixed\">\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<body >\r\n");
      out.write("\t<table width=\"100%\" bgcolor='black'>\r\n");
      out.write("\t\t<tr height=\"5\">\r\n");
      out.write("\t\t\t<td align=\"center\"> \r\n");
      out.write("\t\t\t<font color=\"white\" size=\"2\">\r\n");
      out.write("\t\t\tAI?????? ????????? ?????? ??? ????????? ?????? 2??? | 3??? | EBook Rental Service | \r\n");
      out.write("\t\t\t?????? : ????????? | ?????? : ????????? | ????????? | ????????? |\r\n");
      out.write("\t\t\tCOPYRIGHT ?? VISION CAPITAL SERVICES. INC. ALL RIGHT RESERVED. \r\n");
      out.write("\t\t\t</font> \r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</footer>\t\t\t\t\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
      // /WEB-INF/views/rental/../home.jsp(42,58) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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

  private boolean _jspx_meth_spring_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_005furl_005f1 = (org.springframework.web.servlet.tags.UrlTag) _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    boolean _jspx_th_spring_005furl_005f1_reused = false;
    try {
      _jspx_th_spring_005furl_005f1.setPageContext(_jspx_page_context);
      _jspx_th_spring_005furl_005f1.setParent(null);
      // /WEB-INF/views/rental/../home.jsp(45,13) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_spring_005furl_005f1.setValue("/resources/img/title.png");
      int[] _jspx_push_body_count_spring_005furl_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_spring_005furl_005f1 = _jspx_th_spring_005furl_005f1.doStartTag();
        if (_jspx_th_spring_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_005furl_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_005furl_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_005furl_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_spring_005furl_005f1);
      _jspx_th_spring_005furl_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_spring_005furl_005f1, _jsp_getInstanceManager(), _jspx_th_spring_005furl_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_005furl_005f2 = (org.springframework.web.servlet.tags.UrlTag) _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    boolean _jspx_th_spring_005furl_005f2_reused = false;
    try {
      _jspx_th_spring_005furl_005f2.setPageContext(_jspx_page_context);
      _jspx_th_spring_005furl_005f2.setParent(null);
      // /WEB-INF/views/rental/ebookcontentview.jsp(104,41) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_spring_005furl_005f2.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("http://121.153.134.167/ebook/${ebook_view.bUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int[] _jspx_push_body_count_spring_005furl_005f2 = new int[] { 0 };
      try {
        int _jspx_eval_spring_005furl_005f2 = _jspx_th_spring_005furl_005f2.doStartTag();
        if (_jspx_th_spring_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_005furl_005f2[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_005furl_005f2.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_005furl_005f2.doFinally();
      }
      _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_spring_005furl_005f2);
      _jspx_th_spring_005furl_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_spring_005furl_005f2, _jsp_getInstanceManager(), _jspx_th_spring_005furl_005f2_reused);
    }
    return false;
  }
}
