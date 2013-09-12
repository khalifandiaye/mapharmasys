<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
<div class="nav-collapse collapse">
<ul class="nav nav-tabs nav-stacked">
	<li class="breadcrumb"><fmt:message key="menu.stock.title.medicament"/></li>
    <menu:displayMenu name="AddMedicamentMenu"/>
    <menu:displayMenu name="ListMedicamentMenu"/>
</ul>

<ul class="nav nav-tabs nav-stacked">
    <li class="breadcrumb"><fmt:message key="menu.stock.title.bl"/></li>
    <menu:displayMenu name="AddBLMenu"/>
    <menu:displayMenu name="ListBLMenu"/>
</ul>

<ul class="nav nav-tabs nav-stacked">
    
    <li class="breadcrumb"><fmt:message key="menu.stock.title.fournisseur"/></li>
    <menu:displayMenu name="AddFournisseurMenu"/>
    <menu:displayMenu name="ListFournisseurMenu"/>
</ul>
</div>
</menu:useMenuDisplayer>