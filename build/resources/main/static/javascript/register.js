var isDup = true;
window.addEventListener('load', function(){
    document.getElementById("dup").onclick=function doAction(){
        var xhr = new XMLHttpRequest();
        var url = "http://localhost:8080/register/check/"; //페이지 자체는 잘 먹힌단다
        url += document.getElementById("input_user_id").value
        //1. 아이디 입력 후 데이터베이스 확인

        //2. 체크
        //3. 체크 값에 맞는 결과물 출력

        console.log(url);

        xhr.open("POST", url);
        xhr.onreadystatechange = function(){
            if(xhr.status===200 || xhr.status === 201){
                console.log(xhr.responseText);
                if(xhr.response == ""){
                    isDup = false;
                    document.getElementById("user_id_check").innerHTML="사용가능한 아이디입니다.";
                }
                else{
                    isDup = true;
                    document.getElementById("user_id_check").innerHTML="사용할 수 없는 아이디입니다.";
                }
            }
        }
        xhr.send();
        console.log('isDup: ' + isDup);
    }

    document.getElementById("user_id").value = document.getElementById("input_user_id").value;
    console.log(document.getElementById('user_id').value);
});

var doSomething = function(){
    alert('test');
}
//