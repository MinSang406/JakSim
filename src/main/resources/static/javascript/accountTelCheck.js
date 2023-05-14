
window.addEventListener('load', function(){
    console.log(window.location.href);
    // 특정 페이지에서만 실행하는 방법. 그 페이지 주소가 맞다면 실행시키면 된다아
    // 굳이 이러는 이유는 console 열어봤더니 너무 지저분해져서
    if(window.location.href==='http://localhost:8080/myPage'){
        var isTelDup = false;

        document.getElementById('mypage_tel_dup').onclick = function checkTel(){
            var fin_button = document.getElementById('save-button');
            var xhr = new XMLHttpRequest();
            var url = "http://localhost:8080/find/tel/";
            url += document.getElementById("phoneNumber").value

            console.log(url);

            xhr.open("POST", url);
            xhr.responseType='json';
            xhr.onreadystatechange = function(){
                console.log('before data');
                if(xhr.status===200 || xhr.status === 201){
                    data = xhr.response;
                    console.log('data'+data);
                    if(data === null){
                        document.getElementById("mypage_user_tel_check").innerHTML="등록가능한 전화번호입니다.";
                        document.getElementById("mypage_user_tel_check").style.color = 'black';
                        isTelDup = true;

                        if(isTelDup){
                            fin_button.disabled = false;
                        }
                    }
                    else{
                        isTelDup = false;
                        document.getElementById("mypage_user_tel_check").innerHTML="이미 등록한 전화번호입니다.";
                        document.getElementById("mypage_user_tel_check").style.color = 'red';
                    }
                }
            }
            xhr.send();
            //document.getElementById("phone-number").value = document.getElementById("phoneNumber").value;
            //console.log(document.getElementById('phone-number').value);
        }


    }


});

