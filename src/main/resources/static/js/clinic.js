
$("#clinicBtn").on("click",function(){
	getClinic($("#currentDong").html())
})

function getClinic(dongName){
	$.ajax({
		    "url" : "/clinicbydong",
		    "type" : "get",
		    "dataType": "json",
			data: { dong: dongName},
		    "success" : function(data){
		    	console.log(data)
				$("#h_table").empty();
				$thead_th1=$("<th>진료소명</th>");
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