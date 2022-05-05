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
header>p.display-4 {
	font-size: 30px;
	font-style: italic;
	font-weight: 500;
}

input#search, input#search:focus {
	outline: none;
}

.table td {
	border: none;
}
</style>

</head>
<body>
<section class="container">
	
	<header class="bg-info text-center">
		<p class="display-4 text-white pt-4">oEmbed Test</p>
	
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

	<div class="bg-light p-4">
		<div class="table-box bg-white p-3">
			<table class="table table-striped">
				<thead>
					<tr>
						<td class="col-1">title</td>
						<td class="col-10"></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>type</td>
						<td></td>
					</tr>
					<tr>
						<td>version</td>
						<td></td>
					</tr>
					<tr>
						<td>provider_name</td>
						<td></td>
					</tr>
					<tr>
						<td>provider_url</td>
						<td></td>
					</tr>
					<tr>
						<td>author_name</td>
						<td></td>
					</tr>
					<tr>
						<td>author_url</td>
						<td></td>
					</tr>
					<tr>
						<td>is_plus</td>
						<td></td>
					</tr>
					<tr>
						<td>html<br />(640/480)</td>
						<td></td>
					</tr>
					<tr>
						<td>width</td>
						<td></td>
					</tr>
					<tr>
						<td>height</td>
						<td></td>
					</tr>
					<tr>
						<td>duration</td>
						<td></td>
					</tr>
					<tr>
						<td>description</td>
						<td></td>
					</tr>
					<tr>
						<td>thumbnail_url<br/>(640X480)</td>
						<td></td>
					</tr>
					<tr>
						<td>thumbnail_width</td>
						<td></td>
					</tr>
					<tr>
						<td>thumbnail_height</td>
						<td></td>
					</tr>
					<tr>
						<td>thumbnail_url_with<br/>_play_button</td>
						<td></td>
					</tr>
					<tr>
						<td>upload_date</td>
						<td></td>
					</tr>
					<tr>
						<td>video_id</td>
						<td></td>
					</tr>
					<tr>
						<td>uri</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</section>
</body>
</html>