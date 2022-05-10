// input에 keydown event 발생 시
$('#search').keydown(function(key) {
	let url = $('#search').val();
	
	// case : enter키를 눌렀을 때
	if ( key.keyCode == 13 ) {

		// ajax submit
		urlSearch(url);
	}
	
})

// searchBtn click event 발생 시 
$('#searchBtn').on('click', function() {
	let url = $('#search').val();
	
	// url 값이 없으면 return false
	if(url == '' || url == null) {
		return false;
	}
	
	urlSearch(url);
	
})

function urlSearch(url) {
	
	// step 1. url == null ? return false
	if(url == '' || url == null) {
		return false;
	} 
	
	// step2. url != null ? ajax submit
	else {
	
		$.ajax({
			url: 'embed',
			type: 'post',
			data: {url : url},
			success: function(data) {
				console.log(data.provider_name);
				// case 1 : provider_name이 instagram이거나, wrongURL일 때
				if (data.provider_name == 'instagram' || data.provider_name == 'wrongURL' || data.provider_name == 'serverError') {
					
					// errorBox 생성
					let result1 = errorBox(data);
					$('#result').html(result1);
				} 
				
				// case 2 : provider_name != instagram && provider_name != wrongURL
				else {
					// resultBox 생성
					let result2 = resultBox(data);
					$('#result').html(result2);
					
				}
			},
			error: function() {
				
				data = {
						result : '잘못된 url이거나, oEmbed 정보를 제공하지 않는 사이트입니다.'
				}
				
				// errorBox 생성
				let result3 = errorBox(data);
				$('#result').html(result3);
			}
		})
	}
}

// error일 경우 errorbox를 생성하는 메서
function errorBox(data) {
	let resultBox = '<div class="table-box bg-white p-3 border rounded">';
	resultBox += '<h3 id="error_title" class="text-center">';
	resultBox += '<br/><i class="fa-regular fa-face-sad-tear text-warning"></i><br/><br/>' + data.result;
	resultBox += '</h3>';
	resultBox += '</div>';
	return resultBox;
}

// ajax가 성공했을 경우 resultbox를 생성하는 메서
function resultBox(data) {
	let resultBox = '<div class="table-box bg-white p-3 border rounded">';
	if ( data.title != null ) {
		resultBox += '<h3 id="embed_title" class="text-center">' + data.title + '</h3>';
	} else {
		resultBox += '<h3 id="embed_title" class="text-center"> Twitterer : ' + data.author_name + '</h3>';
	}
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
	
	resultBox += '<td id="html">' + data.html + '</td>';
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