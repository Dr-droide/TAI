<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="Style/connexionStyle.css" type="text/css">
		<title>Connexion</title>
		<script type="text/javascript">
			function TogglePopupMdp() {
				document.getElementById("popup-1").classList.toggle("active");
			}
		</script>
	</head>

	<body>
		<div class="popup" id="popup-1">
			<div class="overlay"></div>
			<div class="content">
				<div class="close-btn" onclick="TogglePopupMdp()">&times;</div>
				<p>Veuillez vous rapprocher de votre administrateur informatique pour reinitialiser votre mot de passe</p><br>
			</div>
		</div>
		<form action="Connexion" method="post">
			<input type="text" name="matricule" required><br>
			<input type="password" name="mdp" required><br>
			<a onclick="TogglePopupMdp();return false;" href="#">Mot de passe oublie ?</a><br>
			<input type="submit" value="Connexion">
		</form>
	</body>

	</html>