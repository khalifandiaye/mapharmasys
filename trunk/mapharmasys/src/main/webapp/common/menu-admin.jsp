<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
<div class="nav-collapse collapse">
<ul class="nav nav-tabs nav-stacked">
	<li class="breadcrumb"><fmt:message key="menu.admin.title.user"/></li>
    <menu:displayMenu name="AddUserMenu"/>
    <menu:displayMenu name="ListUserMenu"/>
    <menu:displayMenu name="ListActiveUserMenu"/>
    <menu:displayMenu name="ReloadOptionMenu"/>
</ul>
</div>
</menu:useMenuDisplayer>
