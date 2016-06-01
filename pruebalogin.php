<?php
	
	//Definimos variables principales
	$server = "mysql17.000webhost.com";
	$user = "a6794339_yojhan";
	$contraseña = "password";
	$bd = "a6794339_health";

	//Creamos la conexión
	$conexion = mysqli_connect($server,$user,$contraseña,$bd) or die("Ha ocurrido un error en la conexión");

	//Recibimos parámetros por $_POST
	$username = $_POST["username"];
	$password = $_POST["password"];

	//Creamos un statement
	$statement = mysqli_prepare($conexion,"SELECT * FROM usuario WHERE usuario_username = ? AND usuario_password = ?")
	or die (mysqli_error($conexion));

	//Ejecutamos statement
	mysqli_stmt_bind_param($statement,"ss",$username,$password);
	mysqli_stmt_execute($statement);

	//Agrupamos el resultado
	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $id, $nombre, $apellido, $fechanac, $username, $password);

	//Guardamos la variable

	$Usuario = array();

	while (mysqli_stmt_fetch($statement)) {
		$Usuario['id'] = $id;
		$Usuario['nombre'] = $nombre;
		$Usuario['apellido'] = $apellido;
		$Usuario['fechanac'] = $fechanac;
		$Usuario['username'] = $username;
		$Usuario['password'] = $password;
	}

	//Enviamos JSON

	echo json_encode($Usuario);
	mysqli_stmt_close($statement);
	mysqli_close($conexion);
	exit;

?>