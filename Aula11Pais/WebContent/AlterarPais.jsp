
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Alterar Pais</title>
            
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
    	<h3 class="page-header">Alterar Pais #${pais.id }</h3>
        <!-- Formulario para alteração do pais -->
      
        <form action="controller.do" method="post">
        <!-- area de campos do form -->
        <input type="hidden" name="id" value="${pais.id }" />
        <div class="row">
        	<div class="form-group col-md-12">
            	<label for="nome">Nome</label>
                <input type="text" class="form-control" name="nome" id="nome" maxlength="100" placeholder="Nome Do Pais" value="${pais.nome }">
           	</div>
       </div>
       <div class="row">
       	<div class="form-group col-md-6">
        	<label for="fone">Populacao</label>
            	<input type="number" class="form-control" name="populacao" id="populacao" maxlength="15" value="${pais.populacao}">
        </div>

        <div class="form-group col-md-6">
        	<label for="email">Area</label>
            <input type="number" class="form-control" name="area" id="area" maxlength="10" value="${pais.area}">
        </div>
       </div>
       <hr />
       <div id="actions" class="row">
       	<div class="col-md-12">
        	<button type="submit" class="btn btn-primary" name="command" value="AlterarPais">Salvar</button>
            <a href="ListarPais.jsp" class="btn btn-default">Cancelar</a>
        </div>
      </div>
      </form>
      
      </div>
      <script src="js/jquery.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
</body>
</html>