function initSido(){
	$.ajax({
	    "url" : "/location/sido",
	    "type" : "get",
	    "dataType": "json",
		async: false,
	    "success" : function(data){
			/* 시도 Json Parsing */
			$.each(data, function(index, item){
				if(index==0){
					var newOption = $("<option"+" id='"+item.sidoCode+"' selected>"+item.sidoName+"</option>");
                	$('#sOption1').append(newOption);					
				}else{
			  	var newOption = $("<option"+" id='"+item.sidoCode+"'>"+item.sidoName+"</option>");
                $('#sOption1').append(newOption);
				}
			})
	    },
	    "error" : function(xhr, ajaxSettings, thrownError){
	        alert('문제가 발생했습니다.\n상태코드 : ' + xhr.status+ '\n\n' + xhr.responseText);
	        
	    }
	});
}

function initGugun(){
	$.ajax({
	    "url" : "/location/gugun",
	    "type" : "get",
	    "dataType": "json",
        async: false,
		data: { sido:$("#sOption1 option:selected").attr("id") },
	    "success" : function(data){
			/* 시도 Json Parsing */
			$.each(data, function(index, item){
				var newOption = $("<option"+" id='"+item.gugunCode+"'>"+item.gugunName+"</option>");
                $('#sOption2').append(newOption);
			})
	    },
	    "error" : function(xhr, ajaxSettings, thrownError){
	        alert('문제가 발생했습니다.\n상태코드 : ' + xhr.status+ '\n\n' + xhr.responseText);
	        
	    }
	});
}

function initDong(){
	$.ajax({
	    "url" : "/location/dong",
	    "type" : "get",
	    "dataType": "json",
		async:false,
		data: {gugun:$("#sOption2 option:selected").attr("id") },
	    "success" : function(data){
			/* 시도 Json Parsing */
			$.each(data, function(index, item){
			  	var newOption = $("<option>"+item.dong+"</option>");
                $('#sOption3').append(newOption);
			})
	    },
	    "error" : function(xhr, ajaxSettings, thrownError){
	        alert('문제가 발생했습니다.\n상태코드 : ' + xhr.status+ '\n\n' + xhr.responseText);
	        
	    }
	});
}


$("#sOption1").on("change",function(event){ // 시 변경되었을때 군구 변경되어야함
	$.ajax({
	    "url" : "/location/gugun",
	    "type" : "get",
	    "dataType": "json",
		async:false,
		data: {sido:$("#sOption1 option:selected").attr("id") },
	    "success" : function(data){
			$("#sOption2").empty();
			$("#sOption3").empty();
			/* 시도 Json Parsing */
			$.each(data, function(index, item){
				var newOption = $("<option"+" id='"+item.gugun_code+"'>"+item.gugun_name+"</option>");
                $('#sOption2').append(newOption);
			})
	    },
	    "error" : function(xhr, ajaxSettings, thrownError){
	        alert('문제가 발생했습니다.\n상태코드 : ' + xhr.status+ '\n\n' + xhr.responseText);
	    }
	});
})

$("#sOption2").on("change",function(event){ // 구 군 변경되었을때  동 변경되어야함
	$.ajax({
	    "url" : "/location/dong",
	    "type" : "get",
	    "dataType": "json",
		async:false,
		data: {gugun:$("#sOption2 option:selected").attr("id") },
	    "success" : function(data){
			$("#sOption3").empty();
			/* 시도 Json Parsing */
			$.each(data, function(index, item){
				var newOption = $("<option"+" id='"+item.code+"'>"+item.dong+"</option>");
                $('#sOption3').append(newOption);
			})
	    },
	    "error" : function(xhr, ajaxSettings, thrownError){
	        alert('문제가 발생했습니다.\n상태코드 : ' + xhr.status+ '\n\n' + xhr.responseText);
	    }
	});
})