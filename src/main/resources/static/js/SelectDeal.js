
$(document).ready(function(){
	selectDeals()
})


function dealSelectByAttentionList(dongname){
	$.ajax({
	    "url" : "/deal/dong",
	    "type" : "post",
	    "dataType": "json",
		data: { dong: dongname},
	    "success" : function(data){
			/* 시도 Json Parsing */
			$("#dealRow").empty();
			$.each(data, function(index, item){
				console.log(item)
				$("#currentDong").html(dongname)
				$newCard=$("<div class='col-lg-6 col-md-6 mb-3'>"+
							"<div class='card h-100'>"+
								"<div class='card-body'>"+
									"<h4 class='card-title'>"+item.aptName+"</h3>"+
									"<p style='font-size:0.7rem;color:#818a91;' class='card-text'>"+
										$("#sOption1 option:selected").html()+" "+
										$("#sOption2 option:selected").html()+" "+
										$("#sOption3 option:selected").html()+" "+
										item.jibun+
									"</p>"+
									"<p class='card-text'><strong>거래금액 </strong>"+item.dealAmount+"</p>"+
									"<p class='card-text'><strong>면적 </strong>"+item.area+"</p>"+
									"<p class='card-text'><strong>층수 </strong>"+item.floor+"</p>"+
									"<p class='card-text'><strong>거래 일시 </strong>"+item.dealYear+"년"+item.dealMonth+"월"+item.dealDay+"일</p>"
				)
				$newCard.on("click",function(){
					var juso=$("#sOption1 option:selected").html()+$("#sOption2 option:selected").html()+" "+
										$("#sOption3 option:selected").html()+" "+item.jibun;

					geocoder.addressSearch(juso, function(result, status) {
				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {
						for(var i=0;i<markers.length;i++){
							infowindows[i].close();
							markers[i].setMap(null);
							console.log(infowindows[i])
							console.log(markers[i])
						}
						infowindows=[]
						markers=[]
				        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new kakao.maps.Marker({
				            map: map,
				            position: coords
				        });
				        // 인포윈도우로 장소에 대한 설명을 표시합니다
				        infowindow = new kakao.maps.InfoWindow({
				            content: "<div style='width:150px;text-align:center;padding:6px 0;'>"+item.aptName+"</div>"
				        });
						
				        infowindow.open(map, marker);
						infowindows.push(infowindow);
						markers.push(marker);
				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        map.setCenter(coords);
				    	} 
					});    
				})
				$("#dealRow").append($newCard)
				console.log(item)
			})
	    },
	    "error" : function(xhr, textStatus, thrownError){
	        alert('문제가 발생했습니다.\n상태코드 : ' + xhr.status+ '\n\n' + xhr.statusText);
	        
	    }
	});
}

function selectDeals(){
	console.log($("#sOption3 option:selected").html())
	$.ajax({
	    "url" : "/deal/"+$("#sOption3 option:selected").html(),
	    "type" : "get",
	    "dataType": "json",	    
		"data": { dong: $("#sOption3 option:selected").html()},
	    "success" : function(data){
			/* 시도 Json Parsing */
			$("#dealRow").empty();
			$.each(data, function(index, item){
				$("#currentDong").html($("#sOption3 option:selected").html())
				$newCard=$("<div class='col-lg-6 col-md-6 mb-3'>"+
							"<div class='card h-100'>"+
								"<div class='card-body'>"+
									"<h4 class='card-title'>"+item.aptName+"</h3>"+
									"<p style='font-size:0.7rem;color:#818a91;' class='card-text'>"+
										$("#sOption1 option:selected").html()+" "+
										$("#sOption2 option:selected").html()+" "+
										$("#sOption3 option:selected").html()+" "+
										item.jibun+
									"</p>"+
									"<p class='card-text'><strong>거래금액 </strong>"+item.dealAmount+"</p>"+
									"<p class='card-text'><strong>면적 </strong>"+item.area+"</p>"+
									"<p class='card-text'><strong>층수 </strong>"+item.floor+"</p>"+
									"<p class='card-text'><strong>거래 일시 </strong>"+item.dealYear+"년"+item.dealMonth+"월"+item.dealDay+"일</p>"
				)
				$newCard.on("click",function(){
					var juso=$("#sOption1 option:selected").html()+$("#sOption2 option:selected").html()+" "+
										$("#sOption3 option:selected").html()+" "+item.jibun;

					geocoder.addressSearch(juso, function(result, status) {
				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {
						for(var i=0;i<markers.length;i++){
							infowindows[i].close();
							markers[i].setMap(null);
							console.log(infowindows[i])
							console.log(markers[i])
						}
						infowindows=[]
						markers=[]
				        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new kakao.maps.Marker({
				            map: map,
				            position: coords
				        });
				        // 인포윈도우로 장소에 대한 설명을 표시합니다
				        infowindow = new kakao.maps.InfoWindow({
				            content: "<div style='width:150px;text-align:center;padding:6px 0;'>"+item.aptName+"</div>"
				        });
						
				        infowindow.open(map, marker);
						infowindows.push(infowindow);
						markers.push(marker);
				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        map.setCenter(coords);
				    	} 
					});    
				})
				$("#dealRow").append($newCard)
				console.log(item)
			})
	    },
	    "error" : function(xhr, textStatus, thrownError){
	        alert('문제가 발생했습니다.\n상태코드 : ' + xhr.status+ '\n\n' + xhr.statusText);
	        
	    }
	});
}


$("#sBtn").on("click", function(event) {
	selectDeals()
	$("#h_table").empty();
});
/*
div class="col-lg-6 col-md-6 mb-3">
            <div class="card h-100">
              <div class="card-body">
                <h4 class="card-title">청담 자이</h3>
                  <p style="font-size:0.7rem;color:#818a91;" class="card-text">서울특별시 강남구 청담동 영동대로138길 12</p>
                  <p class="card-text"><strong>거래금액</strong> 700,000.000원</p>
                  <p class="card-text"><strong>면적</strong> 110.82 (m^2)</p>
                  <p class="card-text"><strong>최근거래일시</strong> 2020.09.21</p>
              </div>
              <div class="card-footer text-right">
                <button type="button" id="detailBtn1" class="btn btn-primary">자세히 보기</button>
              </div>
            </div>
          </div>*/