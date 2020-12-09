


/* 관심지역은document가 로딩될때, user_id를 확인한다 */
$(document).ready(function() {
	console.log('<c:out value="${sessionScope.user_id}"/>')
	if(sessionStorage.getItem("user_id")!='null'){
		var id_string=sessionStorage.getItem("user_id")
		$.ajax({
		    "url" : "localhost:8080/attention",
		    "type" : "post",
		    "dataType": "json",
			data: { user_id: id_string},
		    "success" : function(data){
				$("#attentionDiv").empty();
				$.each(data, function(item){
					$newAttention=$("<a class='btn btn-info my-1 text-white'>"+item.dong+"</a>")
					$("#attentionDiv").append($newAttention)
				})
		    },
		    "error" : function(xhr){
		        alert('관심지역을 가져오는중 문제가 발생했습니다.\n상태코드 : ' + xhr.status+ '\n\n' + xhr.statusText);
		        
		    }
		})
	}
})