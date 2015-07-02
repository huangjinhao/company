		var code="" ; 
		function createCode(){ 
			code = "";
			var codeLength = 6;
			var checkCode = document.getElementById("checkCode");
			checkCode.value = "";
			var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
			for(var i=0;i<codeLength;i++) {   
				var charIndex = Math.floor(Math.random()*32);   
				code +=selectChar[charIndex];
			}
			if(code.length != codeLength){   
				createCode();
			}
			document.getElementById("checkCode").innerHTML = code;
		}
