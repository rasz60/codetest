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

.table-box {
	overflow-x: auto;
}

#embed_title {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
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

	<div id="result" class="bg-light p-4">

	</div>
</section>

<script>
$('#searchBtn').click(function() {
	let url = $('#search').val();
	
	if(url == '' || url == null ) {
		return false;
	}
	
	console.log(url);
	
	$.ajax({
		url: 'embed',
		type: 'post',
		data: {url : url},
		success: function(data) {
			console.log(data);
			if( data == null || data == '' ) {
				alert('유효하지 않은 url입니다.');
				return false;
			} else {
				let result = resultBox(data);
				$('#result').html(result);
			}
		},
		error: function() {
			alert('유효하지 않은 url입니다.');
			return false;
		}
	
	})
	
})


function resultBox(data) {
	let resultBox = '<div class="table-box bg-white p-3 border rounded">';
	resultBox += '<h3 id="embed_title" class="text-center">' + data.title + '</h3>';
	resultBox += '<hr />';
	resultBox += '<table class="table table-striped">';
	resultBox += '<tr>';
	resultBox += '<td>type</td>';
	resultBox += '<td>' + data.type + '</td>';
	resultBox += '</tr>';
	resultBox += '<tr>';
	resultBox += '<td>version</td>';
	resultBox += '<td>' + data.version + '</td>';
	resultBox += '</tr>';
	resultBox += '<tr>';
	resultBox += '<td>provider_name</td>';
	resultBox += '<td>' + data.provider_name + '</td>';
	resultBox += '</tr>';
	resultBox += '<tr>';
	resultBox += '<td>provider_url</td>';
	resultBox += '<td>' + data.provider_url + '</td>';
	resultBox += '</tr>';
	resultBox += '<tr>';
	resultBox += '<td>author_name</td>';
	resultBox += '<td>' + data.author_name + '</td>';
	resultBox += '</tr>';
	resultBox += '<tr>';
	resultBox += '<td>author_url</td>';
	resultBox += '<td>' + data.author_url + '</td>';
	resultBox += '</tr>';
	
	if( data.is_plus != null ) {
		resultBox += '<tr>';
		resultBox += '<td>is_plus</td>';
		resultBox += '<td>' + data.is_plus + '</td>';
		resultBox += '</tr>';
	}
	
	resultBox += '<tr>';
	if ( data.height != null ) {
		
		resultBox += '<td>html<br />(' + data.width + '/' + data.height + ')</td>';
		
	} else {
		
		resultBox += '<td>html<br />(' + data.width + ')</td>';
	}
	
	resultBox += '<td>' + data.html + '</td>';
	resultBox += '</tr>';
	resultBox += '<tr>';
	resultBox += '<td>width</td>';
	resultBox += '<td>' + data.width + '</td>';
	resultBox += '</tr>';

	resultBox += '<tr>';
	resultBox += '<td>height</td>';
	if ( data.height != null ) {
		
		resultBox += '<td>' + data.height + '</td>';

	} else {
		
		resultBox += '<td>-</td>';
	}
	
	resultBox += '</tr>';
	
	if( data.duration != null ) {
		resultBox += '<tr>';
		resultBox += '<td>duration</td>';
		resultBox += '<td>' + data.duration + '</td>';
		resultBox += '</tr>';
	}
	
	if( data.description != null ) {
		resultBox += '<tr>';
		resultBox += '<td>description</td>';
		resultBox += '<td>' + data.description + '</td>';
		resultBox += '</tr>';
	}
	
	if( data.thumbnail_url != null ) {
		resultBox += '<tr>';
		resultBox += '<td>thumbnail_url<br/>(' + data.thumbnail_width + 'X' + data.thumbnail_height + ')</td>';
		resultBox += '<td><a href="' + data.thumbnail_url + '">' + data.thumbnail_url + '</a><br/> <img src="' + data.thumbnail_url + '"/></td>';
		resultBox += '</tr>';
	}
	
	if( data.thumbnail_width != null ) {
		resultBox += '<tr>';
		resultBox += '<td>thumbnail_width</td>';
		resultBox += '<td>' + data.thumbnail_width + '</td>';
		resultBox += '</tr>';
	}
	
	if( data.thumbnail_height != null ) {
		resultBox += '<tr>';
		resultBox += '<td>thumbnail_height</td>';
		resultBox += '<td>' + data.thumbnail_height + '</td>';
		resultBox += '</tr>';
	}
	
	if( data.thumbnail_url_with_play_button != null ) {
		resultBox += '<tr>';
		resultBox += '<td>thumbnail_url_with<br/>_play_button</td>';
		resultBox += '<td><a href="' + data.thumbnail_url_with_play_button + '">' + data.thumbnail_url_with_play_button + '</a></td>';
		resultBox += '</tr>';
	}
	
	if( data.upload_date != null ) {
		resultBox += '<tr>';
		resultBox += '<td>upload_date</td>';
		resultBox += '<td>' + data.upload_date + '</td>';
		resultBox += '</tr>';
	}
	
	if( data.video_id != null ) {
		resultBox += '<tr>';
		resultBox += '<td>video_id</td>';
		resultBox += '<td>' + data.video_id + '</td>';
		resultBox += '</tr>';
	}
	
	if( data.uri != null ) {
		resultBox += '<tr>';
		resultBox += '<td>uri</td>';
		resultBox += '<td>' + data.uri + '</td>';
		resultBox += '</tr>';
	}
	
	resultBox += '</table>';
	resultBox += '</div>';
	
	return resultBox;
}
</script>


</body>
</html>