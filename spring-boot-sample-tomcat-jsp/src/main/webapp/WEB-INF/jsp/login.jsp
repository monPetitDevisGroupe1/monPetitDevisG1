<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Mon Petit Devis : Login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<!--<link href="<c:url value='/jsp/static/favicon.ico'/>" rel="shortcut icon"> -->
	</head>
	<style>
		*, *:before, *:after {
			box-sizing: border-box;
		}

		html {
			overflow-y: scroll;
		}

		body {
			background: #c1bdba;
			font-family: 'Titillium Web', sans-serif;
		}

		a {
			text-decoration: none;
			color: #1ab188;
			-webkit-transition: .5s ease;
			transition: .5s ease;
		}
		a:hover {
			color: #179b77;
		}

		.form {
			background: rgba(19, 35, 47, 0.9);
			padding: 40px;
			max-width: 600px;
			margin: 40px auto;
			border-radius: 4px;
			box-shadow: 0 4px 10px 4px rgba(19, 35, 47, 0.3);
		}

		.tab-group {
			list-style: none;
			padding: 0;
			margin: 0 0 40px 0;
		}
		.tab-group:after {
			content: "";
			display: table;
			clear: both;
		}
		.tab-group li a {
			display: block;
			text-decoration: none;
			padding: 15px;
			background: rgba(160, 179, 176, 0.25);
			color: #a0b3b0;
			font-size: 20px;
			float: left;
			width: 50%;
			text-align: center;
			cursor: pointer;
			-webkit-transition: .5s ease;
			transition: .5s ease;
		}
		.tab-group li a:hover {
			background: #179b77;
			color: #ffffff;
		}
		.tab-group .active a {
			background: #1ab188;
			color: #ffffff;
		}

		.tab-content > div:last-child {
			display: none;
		}

		h1 {
			text-align: center;
			color: #ffffff;
			font-weight: 300;
			margin: 0 0 40px;
		}

		label {
			position: absolute;
			-webkit-transform: translateY(6px);
			transform: translateY(6px);
			left: 13px;
			color: rgba(255, 255, 255, 0.5);
			-webkit-transition: all 0.25s ease;
			transition: all 0.25s ease;
			-webkit-backface-visibility: hidden;
			pointer-events: none;
			font-size: 22px;
		}
		label .req {
			margin: 2px;
			color: #1ab188;
		}

		label.active {
			-webkit-transform: translateY(50px);
			transform: translateY(50px);
			left: 2px;
			font-size: 14px;
		}
		label.active .req {
			opacity: 0;
		}

		label.highlight {
			color: #ffffff;
		}

		input, textarea {
			font-size: 22px;
			display: block;
			width: 100%;
			height: 100%;
			padding: 5px 10px;
			background: none;
			background-image: none;
			border: 1px solid #a0b3b0;
			color: #ffffff;
			border-radius: 0;
			-webkit-transition: border-color .25s ease, box-shadow .25s ease;
			transition: border-color .25s ease, box-shadow .25s ease;
		}
		input:focus, textarea:focus {
			outline: 0;
			border-color: #1ab188;
		}

		textarea {
			border: 2px solid #a0b3b0;
			resize: vertical;
		}

		.field-wrap {
			position: relative;
			margin-bottom: 40px;
		}

		.top-row:after {
			content: "";
			display: table;
			clear: both;
		}
		.top-row > div {
			float: left;
			width: 48%;
			margin-right: 4%;
		}
		.top-row > div:last-child {
			margin: 0;
		}

		.button {
			border: 0;
			outline: none;
			border-radius: 0;
			padding: 15px 0;
			font-size: 2rem;
			font-weight: 600;
			text-transform: uppercase;
			letter-spacing: .1em;
			background: #1ab188;
			color: #ffffff;
			-webkit-transition: all 0.5s ease;
			transition: all 0.5s ease;
			-webkit-appearance: none;
		}
		.button:hover, .button:focus {
			background: #179b77;
		}

		.button-block {
			display: block;
			width: 100%;
		}

		.forgot {
			margin-top: -20px;
			text-align: right;
		}
	</style>
	<body>
		<H1>Bienvenue sur Mon Petit Devis!</H1>

		<div class="form">

			<ul class="tab-group">
				<li class="tab active"><a href="#signup">Inscription</a></li>
				<li class="tab"><a href="#login">Connexion</a></li>
			</ul>

			<div class="tab-content">
				<div id="signup">
					<h1>Inscription gratuite</h1>

					<form action="<c:url value='/inscription'/>" method="GET">
						<c:if test="${not empty param.err}">
							<div class="msg-container error">
								<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
							</div>
						</c:if>
						<c:if test="${not empty param.out}">
							<div class="msg-container logout">
								Vous avez bien &eacute;t&eacute; d&eacute;connect&eacute;.
							</div>
						</c:if>
						<c:if test="${not empty param.time}">
							<div class="msg-container time">
								Vous avez &eacute;t&eacute; d&eacute;connect&eacute; suite &agrave; une trop longue p&eacute;riode d'inactivit&eacute;.
							</div>
						</c:if>


							<div class="field-wrap">
								<label>
									Pseudo <span class="req">*</span>
								</label>
								<input type="text"required autocomplete="off" name = "username"/><br/><br/>
							</div>


						<div class="field-wrap">
							<label>
								Mot de passe <span class="req">*</span>
							</label>
							<input type="text"required autocomplete="off" name = "password"/>
						</div>

						<button type="submit" class="button button-block"/>C'est parti !</button>

					</form>

				</div>

				<div id="login">
					<h1>Bienvenue!</h1>

					<form action="<c:url value='/login.do'/>" method="POST">
						<c:if test="${not empty param.err}">
							<div class="msg-container error">
								<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
							</div>
						</c:if>
						<c:if test="${not empty param.out}">
							<div class="msg-container logout">
								Vous avez bien &eacute;t&eacute; d&eacute;connect&eacute;.
							</div>
						</c:if>
						<c:if test="${not empty param.time}">
							<div class="msg-container time">
								Vous avez &eacute;t&eacute; d&eacute;connect&eacute; suite &agrave; une trop longue p&eacute;riode d'inactivit&eacute; (c'est malin).
							</div>
						</c:if>
						<div class="field-wrap">
							<label>
								Pseudo<span class="req">*</span>
							</label>
							<input type="text" name="username" value="" class="input-text input-email<c:if test="${not empty param.err}"> input-error</c:if>"/><br><br>
						</div>
						<div class="field-wrap">
							<label>
								Mot de passe<span class="req">*</span>
							</label>
							<input type="password" name="password" value="" class="input-text input-pass<c:if test="${not empty param.err}"> input-error</c:if>"/>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<p class="forgot"><a href="#">Mot de passe oubli&eacute;?</a></p>

						<button class="button button-block"/>Connexion</button>

					</>

				</div>

			</div><!-- tab-content -->

		</div> <!-- /form -->

		<script   src="resources/js/jquery-1.7.2.min.js" >
		</script>
		<script src="resources/js/mainJs.js" type="text/javascript">
		</script>
	</body>
</html>
