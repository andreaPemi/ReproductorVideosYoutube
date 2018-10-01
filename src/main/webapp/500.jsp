<!DOCTYPE html>
<%@page import="com.andrea.perez.pojo.Usuario"%>
<%@page import="com.andrea.perez.pojo.Alert"%>
<%@page import="com.andrea.perez.controller.HomeController"%>
<%@page import="com.andrea.perez.pojo.Video"%>
<%@page import="java.util.ArrayList"%>
<html lang="es">

<head>

<!-- Comienza todas las URLs desde el href indicado -->
<base href="<%=request.getContextPath()%>/">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="videos youtube">
<meta name="author" content="Adriana">

<link rel="stylesheet" href="css/500.css">

<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<body>
<div class="container">
  <div class="row">
    <div class="span12">
      <div class="hero-unit center">
          <h1>Error interno del servidor <small><font face="Tahoma" color="red">Error 500</font></small></h1>
          <br />
          <p>El servidor ha detectado un error inesperado que le impide acceder a esta p�gina. Usa el bot�n <b>Volver</b> de tu navegador para regresar a la p�gina anterior.</p>
          <p>Si el error persiste, <a href="mailto:example@example.com"> contacte con nuestros t�cnicos de soporte</a>.</p>
          <p><b>O puedes volver a la p�gina principal pulsando el siguiente bot�n:</b></p>
          
          <a href="#" class="btn btn-large btn-info"><i class="icon-home icon-white"></i> Volver a la p�gina principal</a>
        </div>
    </div>
  </div>
</div>
</body>

</html>