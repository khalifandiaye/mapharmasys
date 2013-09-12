<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
<div class="nav-collapse collapse">
<ul class="nav nav-tabs nav-stacked">
	<li class="breadcrumb"><fmt:message key="menu.echange.title.echange"/></li>
    <menu:displayMenu name="AddEchangetMenu"/>
    <menu:displayMenu name="ListEchangetMenu"/>
</ul>

<ul class="nav nav-tabs nav-stacked">
    <li class="breadcrumb"><fmt:message key="menu.echange.title.pharmacie"/></li>
    <menu:displayMenu name="AddPharmacieMenu"/>
    <menu:displayMenu name="ListPharmacieMenu"/>
</ul>
</div>
</menu:useMenuDisplayer>
