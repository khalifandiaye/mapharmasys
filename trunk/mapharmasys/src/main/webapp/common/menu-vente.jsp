<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
<div class="nav-collapse collapse">
<ul class="nav nav-tabs nav-stacked">
	<li class="breadcrumb"><fmt:message key="menu.vente.title.vente"/></li>
    <menu:displayMenu name="AddVenteMenu"/>
    <menu:displayMenu name="ListVenteMenu"/>
</ul>

<ul class="nav nav-tabs nav-stacked">
    <li class="breadcrumb"><fmt:message key="menu.vente.title.client"/></li>
    <menu:displayMenu name="AddClientMenu"/>
    <menu:displayMenu name="ListClientMenu"/>
</ul>
</div>
</menu:useMenuDisplayer>
