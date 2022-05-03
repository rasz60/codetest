<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/b4e02812b5.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style>
input#search, input#search:focus {
	outline: none;
}
</style>

</head>
<body>
<section class="container">
	
	<header class="bg-info text-center">
		<p class="display-4 text-white pt-2">oEmbed Test</p>
	
		<div class="pb-2">
			<div class="form-group mx-2 p-2 row mx-0 bg-white rounded">
				<label for="search" class="col-1 text-secondary my-1">
					<i class="fa-solid fa-link"></i>
				</label>
				<input type="text" id="search" placeholder="URL" name="url" class="col-10" style="border:none" />
				<button id="searchBtn" class="btn btn-sm btn-warning col-1">확인</button>
			</div>
		</div>	
	</header>

	<div class="bg-light" style="height: 800px;">
		
	</div>
</section>
</body>
</html>