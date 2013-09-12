<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>
<html lang="en">
<head>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<c:url value="/images/favicon.ico"/>"/>
    <title><decorator:title/> | <fmt:message key="webapp.name"/></title>

    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-2.3.2.min.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-responsive-2.3.2.min.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/style.css'/>" />
    <decorator:head/>

    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-2.3.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/plugins/jquery.cookie.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/script.js'/>"></script>
</head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>
    <c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>

    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <%-- For smartphones and smaller screens --%>
                <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="brand" href="<c:url value='/'/>"><fmt:message key="webapp.name"/></a>
                <%@ include file="/common/menu.jsp" %>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <%@ include file="/common/messages.jsp" %>
        <div class="row-fluid">
       		<div class="span3">
	        	<c:if test="${currentMenu == 'AdminMenu'}">
	                <%@ include file="/common/menu-admin.jsp" %>
	            </c:if>
	            <c:if test="${currentMenu == 'VenteMenu'}">
	                <%@ include file="/common/menu-vente.jsp" %>
	            </c:if>
	            <c:if test="${currentMenu == 'EchangeMenu'}">
	                <%@ include file="/common/menu-echange.jsp" %>
	            </c:if>
	            <c:if test="${currentMenu == 'StockMenu'}">
	                <%@ include file="/common/menu-stock.jsp" %>
	            </c:if>
            </div>
            <div class="span9">
            	<decorator:body/>
            </div>
        </div>
    </div>

    <div id="footer">
        <span class="left"><fmt:message key="webapp.version"/>
            <c:if test="${pageContext.request.remoteUser != null}">
            | <fmt:message key="user.status"/> ${pageContext.request.remoteUser}
            </c:if>
        </span>
        <span class="right">
            &copy; <fmt:message key="copyright.year"/> <a href="<fmt:message key="company.url"/>"><fmt:message key="company.name"/></a>
        </span>
    </div>
<%= (request.getAttribute("scripts") != null) ?  request.getAttribute("scripts") : "" %>
</body>
</html>
