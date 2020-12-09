
$("#hospitalBtn").on("click",function(){
	getHospital($("#currentDong").html())
})

function getHospital(dongName){
	$.ajax({
		    "url" : "/safetyhospital",
		    "type" : "get",
		    "dataType": "json",
			data: { dong: dongName},
		    "success" : function(data){
		    	console.log(data)
				$("#h_table").empty();
				$thead_th1=$("<th>병원명</th>");
				$thead_th2=$("<th>주소</th>");
				$thead_th3=$("<th>전화번호</th>");
				$thead_tr=$("<tr></tr>");
				$thead_tr.append($thead_th1).append($thead_th2).append($thead_th3)						
				$thead=$("<thead></thead>");
				$thead.append($thead_tr);
				$tbody=$("<tbody></tbody>");
				$.each(data, function(index,item){
					$tbody_tr=$("<tr></tr>");
					$tbody_td1=$("<td class='filterable-cell'>"+item.hospital+"</td>");
					$tbody_td2=$("<td class='filterable-cell'>"+item.address+"</td>");
					$tbody_td3=$("<td class='filterable-cell'>"+item.phonenumber+"</td>");
					$tbody_tr.append($tbody_td1).append($tbody_td2).append($tbody_td3)
					$tbody.append($tbody_tr);
				})
				$("#h_table").append($thead)
				$("#h_table").append($tbody)
		    },
		    "error" : function(xhr){
		        alert('병원정보를 가져오는중 문제가 발생했습니다.\n상태코드 : ' + xhr.status+ '\n\n' + xhr.statusText);
		        
		    }
		})
}
/* 병원보기 버튼클릭시 발동할 이벤트 */
function hospitalClick(dongName){
	geocoder.addressSearch(juso, function(result, status) {
		// 정상적으로 검색이 완료됐으면 
		if (status === kakao.maps.services.Status.OK) {
			for (var i = 0; i < markers.length; i++) {
				infowindows[i].close();
				markers[i].setMap(null);
				console.log(infowindows[i])
				console.log(markers[i])
			}
			infowindows = []
			markers = []
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			// 결과값으로 받은 위치를 마커로 표시합니다
			var marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});
			// 인포윈도우로 장소에 대한 설명을 표시합니다
			infowindow = new kakao.maps.InfoWindow({
				content: "<div style='width:150px;text-align:center;padding:6px 0;'>" + item.aptName + "</div>"
			});

			infowindow.open(map, marker);
			infowindows.push(infowindow);
			markers.push(marker);
			// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			map.setCenter(coords);
		}
	})
}