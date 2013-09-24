<%@ include file="/common/taglibs.jsp" %>

<head>
	<meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<c:url value="/images/favicon.ico"/>"/>
    <title><fmt:message key="webapp.name"/></title>

    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-2.3.2.min.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-responsive-2.3.2.min.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/style.css'/>" />

    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-2.3.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/plugins/jquery.cookie.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/script.js'/>"></script>
    
    <title><fmt:message key="login.title"/></title>
    <meta name="menu" content="Login"/>
</head>
<body id="login">

<form method="post" id="loginForm" action="<c:url value='/j_security_check'/>"
    onsubmit="saveUsername(this);return validateForm(this)" class="form-signin" autocomplete="off">
    <h2 class="form-signin-heading">
        <fmt:message key="login.heading"/>
    </h2>
<c:if test="${param.error != null}">
    <div class="alert alert-error fade in">
        <fmt:message key="errors.password.mismatch"/>
    </div>
</c:if>
    <input type="text" name="j_username" id="j_username" class="input-block-level"
           placeholder="<fmt:message key="label.username"/>" required tabindex="1">
    <input type="password" class="input-block-level" name="j_password" id="j_password" tabindex="2"
           placeholder="<fmt:message key="label.password"/>" required>

<c:if test="${appConfig['rememberMeEnabled']}">
    <label class="checkbox" for="rememberMe">
        <input type="checkbox" class="checkbox" name="_spring_security_remember_me" id="rememberMe" tabindex="3"/>
        <fmt:message key="login.rememberMe"/></label>
</c:if>

    <button type="submit" class="btn btn-large btn-primary" name="login" tabindex="4">
        <fmt:message key='button.login'/>
    </button>
</form>

<p>
    <fmt:message key="login.signup">
        <fmt:param><c:url value="/signup"/></fmt:param>
    </fmt:message>
</p>

<c:set var="scripts" scope="request">
<%@ include file="/scripts/login.js"%>
</c:set>

<p><fmt:message key="login.passwordHint"/></p>
</body>