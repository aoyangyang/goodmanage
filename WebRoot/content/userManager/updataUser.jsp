<%@ page language="java" import="java.util.*,net.hunau.goodsmanager.bean.User,net.hunau.goodsmanager.bean.Roles" pageEncoding="utf-8" %>
<%@page import="net.hunau.goodsmanager.bean.Roles"%>
<%@page import="net.hunau.goodsmanager.dao.RolesDao" %>
<%@page import="net.hunau.goodsmanager.dao.UserDao" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	RolesDao ud = new RolesDao();
	List<Roles> rolesAll = ud.getRoles();
	String path = request.getContextPath();
	
	session.setAttribute("rolesAll", rolesAll);
	
	String userName = request.getParameter("userName");
	UserDao userDao = new UserDao();
	User user = userDao.getUser(userName);
	
	
	Roles temp = new Roles();
	int i = 0;
	
	for(Roles ros:rolesAll){
		if(ros.getId()==user.getRoles()){
			temp = rolesAll.get(0);
			rolesAll.add(0, ros);
			rolesAll.add(i, temp);
			break;
		}	
		i++;
	}
 %>

<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../../css/biz.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>
<SCRIPT type=text/javascript>
</SCRIPT>
<DIV>
<form action='<%=path %>/servlet/UpdateUserServlet' method='post'>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR  class="bg_header"  height=47>
        <TD width=10><SPAN class="main_hl"></SPAN></TD>
        <TD>
        <SPAN class="main_hl2"></SPAN>
        <SPAN class="main_hb">编辑用户 </SPAN>
        <SPAN class="main_hr"></SPAN>
      	</TD>
        <TD  class="main_rc " width=10></TD>
      </TR>
      <TR>
        <TD class="main_ls">&nbsp;</TD>
        <TD class="main_nu" vAlign=top align=middle>
          <DIV>
            <TABLE class=gridView style="WIDTH: 80%; BORDER-COLLAPSE: collapse"  cellSpacing=0 rules=all  border=1>
              <TBODY>
                <TR>
                  <TH class=gridViewHeader  colspan="5" >用户信息</TH>
                </TR>
                <TR>
                  <TD class=gridViewItem>用户名 </TD>
                  <TD class=gridViewItem><input  type="text" value="<%=user.getUsername() %>" name="userName" readonly="readonly"></TD>
                  <TD class=gridViewItem>有效标识</TD>
                  <TD class=gridViewItem >
                  <input type='radio' name='validateFlag' value='0'  <%=user.getValidateFlag()==0?"checked":"" %>>注销
				   <input type='radio' name='validateFlag'    value='1'  <%=user.getValidateFlag()==0?"":"checked" %> >有效
                   </TD>
                </TR>
                <TR>
                  <TD class=gridViewItem>密码 </TD>
                  <TD  class=gridViewItem><input type='password' name='password' value='<%=user.getPassword() %>'></TD>
                  <TD class=gridViewItem >用户类型 </TD>
                  <TD class=gridViewItem>
						<select name="roleType" style="WIDTH:45% ;color:#566984" >
							<c:forEach items='${rolesAll }' var="roles">
						    	<option value="${roles.id }">${roles.roleName }</option>  			
						    </c:forEach>
						</select>  
				  </TD>
                	</tr>
                <TR>
                  <TD class=gridViewItem  colspan="4" >
                <input class=cmdField type="submit" value="提交">&nbsp;&nbsp;&nbsp;
                  </Td>
                </TR>
              </TBODY>
            </TABLE>
          </DIV>
        </TD>
        <TD class="main_rs"></TD>
      </TR>
      <TR class="main_fs" height=10>
        <TD class="main_lf"></TD>
        <TD class="main_fs"></TD>
        <TD class="main_rf"></TD>
      </TR>
    </TBODY>
  </TABLE>
  </form>
</DIV>
</BODY>
</HTML>
