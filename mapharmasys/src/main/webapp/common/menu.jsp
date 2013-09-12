<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
<div class="nav-collapse collapse">
<ul class="nav nav-pills">
    <c:if test="${empty pageContext.request.remoteUser}">
        <li class="active">
            <a href="<c:url value="/login"/>"><fmt:message key="login.title"/></a>
        </li>
    </c:if>
    <menu:displayMenu name="MainMenu"/>
    <menu:displayMenu name="VenteMenu"/>
    <menu:displayMenu name="EchangeMenu"/>
    <menu:displayMenu name="StockMenu"/>
    <menu:displayMenu name="AdminMenu"/>
</ul>
</div>
<div class="btn-group pull-right" >
	<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
		<i class="icon-user"></i><span class="hidden-phone"> 
			<c:if test="${pageContext.request.remoteUser != null}">
             ${pageContext.request.remoteUser}
            </c:if></span>
		<span class="caret"></span>
	</a>
	<ul class="dropdown-menu">
		<li class="divider"></li>
		<li>
			<a href="<c:url value="/editProfile"/>"><fmt:message key="menu.user"/></a>
		</li>
		<li class="divider"></li>
		<li>
			<a href="<c:url value="/logout"/>"><fmt:message key="user.logout"/></a>
		</li>
	</ul>
</div>
</menu:useMenuDisplayer>
