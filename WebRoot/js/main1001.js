function createTime(){ 
	var dateTime = new Date();
	var hh = dateTime.getHours();
	var mm = dateTime.getMinutes();
	var ss = dateTime.getSeconds();
	
	var yy = dateTime.getFullYear();
	var MM = dateTime.getMonth()+1;//因为1月返回值是0，所以加1
	var dd = dateTime.getDate();//日期
	
	if(!((hh-10)>0)){
		hh = "0"+hh;
	}
	if(!((mm-10)>0)){
		mm = "0"+mm;
	}
	if(!((ss-10)>0)){
		ss = "0"+ss;
	}
	if(!((MM-10)>0)){
		MM = "0"+MM;
	}
	if(!((dd-10)>0)){
		dd = "0"+dd;
	}
	
	document.getElementById("date").innerHTML=yy+"年"+MM+"月"+dd+"日 ";
	
	document.getElementById("time").innerHTML=hh+"时"+mm+"分"+ss+"秒";
	
	setTimeout(createTime,1000);
}
