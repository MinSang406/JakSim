
window.addEventListener('load', function(){
    console.log(window.location.href);
    // 특정 페이지에서만 실행하는 방법. 그 페이지 주소가 맞다면 실행시키면 된다아
    // 굳이 이러는 이유는 console 열어봤더니 너무 지저분해져서
    if(window.location.href==='http://localhost:8080/register'){
        var isIDDup = false;
        var isTelDup = false;
        var isPWCheck = false;
        document.getElementById('dup').onclick=function doAction(){
            var xhr = new XMLHttpRequest();
            var url = "http://localhost:8080/register/check/"; //페이지 자체는 잘 먹힌단다
            url += document.getElementById("input_user_id").value

            console.log(url);

            xhr.open("POST", url);
            xhr.onreadystatechange = function(){
                if(xhr.status===200 || xhr.status === 201){
                    console.log(xhr.responseText);
                    if(xhr.response == ""){

                        document.getElementById("user_id_check").innerHTML="사용가능한 아이디입니다.";
                        document.getElementById("user_id_check").style.color='black';
                        isIDDup = true;

                        if(isTelDup && isIDDup && isPWCheck){
                            fin_button.disabled = false;
                        }
                    }
                    else{
                        isIDDup = false;
                        document.getElementById("user_id_check").innerHTML="이미 등록된 아이디입니다.";
                        document.getElementById("user_id_check").style.color='red';
                    }
                }
            }
            xhr.send();
            document.getElementById("user_id").value = document.getElementById("input_user_id").value;
            console.log(document.getElementById('user_id').value);
        }
        document.getElementById('tel_dup').onclick = function checkTel(){
            var fin_button = document.getElementById('fin_button');
            var xhr = new XMLHttpRequest();
            var url = "http://localhost:8080/find/tel/";
            url += document.getElementById("input_user_tel").value

            console.log(url);

            xhr.open("POST", url);
            xhr.responseType='json';
            xhr.onreadystatechange = function(){
                if(xhr.status===200 || xhr.status === 201){
                    data = xhr.response;
                    console.log(data);
                    if(data === null){
                        document.getElementById("user_tel_check").innerHTML="등록가능한 전화번호입니다.";
                        document.getElementById("user_tel_check").style.color = 'black';
                        isTelDup = true;

                        if(isTelDup && isIDDup && isPWCheck){
                            fin_button.disabled = false;
                        }
                    }
                    else{
                        isTelDup = false;
                        document.getElementById("user_tel_check").innerHTML="이미 등록한 전화번호입니다.";
                        document.getElementById("user_tel_check").style.color = 'red';
                    }
                }
            }
            xhr.send();
            document.getElementById("user_tel").value = document.getElementById("input_user_tel").value;
            console.log(document.getElementById('user_tel').value);
        }
        document.getElementById('pw_dup').onclick = function checkPw(){
            var pwInput = document.getElementById('user_pw_input').value;
            var confirmPw = document.getElementById('user_confirm').value;
            var check = document.getElementById('password_check');
            if(pwInput.length > 3){
                if(pwInput === confirmPw){
                    check.innerHTML = '비밀번호 확인이 완료되었습니다.';
                    check.style.color='black';
                    document.getElementById("user_pw").value = pwInput;
                    isPWCheck = true;
                    if(isTelDup && isIDDup && isPWCheck){
                        fin_button.disabled = false;
                    }
                }else{
                    isPWCheck = false;
                    check.innerHTML = '비밀번호를 다시 확인해주세요';
                    check.style.color='red';
                }
            }else{
                check.innerHTML='최소 4자 이상 작성해주세요';
                check.style.color='red';
            }
            console.log(document.getElementById('user_pw').value);
        }

    }

    if(window.location.href==='http://localhost:8080/find'){
        var answerButton = document.getElementById('find_answer_button');
        answerButton.disabled = true;

        document.getElementById('find_tel_button').onclick = function findByTel(){
            var xhr = new XMLHttpRequest();
            var url = "http://localhost:8080/find/tel/"; //페이지 자체는 잘 먹힌단다
            url += document.getElementById('find_tel').value
            console.log(url);

            xhr.open("POST", url);
            xhr.responseType='json';
            xhr.onreadystatechange = function(){
                if(xhr.status===200 || xhr.status === 201){
                    console.log(xhr.response);
                    data = xhr.response;
                    if(data !== null){
                        document.getElementById("find_question").innerHTML = Question(data.user_question);
                        document.getElementById("find_question").style.color='black';
                        answerButton.disabled=false;
                    }
                    else{
                        var question = document.getElementById("find_question");
                        question.innerHTML= "조회된 데이터가 없습니다";
                        question.style.color='red';
                        answerButton.disabled=true;
                    }
                    console.log(data.user_answer);
                }
            }
            xhr.send();
        }

        document.getElementById('find_answer_button').onclick = function Answer(){
            var xhr = new XMLHttpRequest();
            var url = "http://localhost:8080/find/tel/"; //페이지 자체는 잘 먹힌단다
            url += document.getElementById('find_tel').value
            console.log(url);

            xhr.open("POST", url);
            xhr.responseType='json';
            xhr.onreadystatechange = function(){
                if(xhr.status===200 || xhr.status === 201){
                    console.log(xhr.response);
                    data = xhr.response;
                    var answer = document.getElementById('find_answer');
                    if(data.user_answer === answer.value){
                        document.getElementById('find_id').value = data.user_id;
                        document.getElementById('find_pw').disabled=false;
                        document.getElementById('find_pw_confirm').disabled=false;
                        document.getElementById('find_pw_check').disabled=false;
                    }
                    else{
                        alert('답을 다시 확인해주세요');
                        document.getElementById('find_id').innerHTML = "";
                    }
                }
            }
            xhr.send();
        }

        document.getElementById('find_pw_check').onclick = function checkPw(){
            var pwInput = document.getElementById('find_pw').value;
            var confirmPw = document.getElementById('find_pw_confirm').value;
            var check = document.getElementById('find_password_check');
            if(pwInput.length > 3){
                if(pwInput === confirmPw){
                    check.innerHTML = '비밀번호 확인이 완료되었습니다.';
                    check.style.color='black';
                    document.getElementById('find_change_pw').disabled=false;
                }else{
                    check.innerHTML = '비밀번호를 다시 확인해주세요';
                    check.style.color='red';
                    document.getElementById('find_change_pw').disabled=true;
                }
            }else{
                check.innerHTML='최소 4자 이상 작성해주세요';
                check.style.color='red';
                document.getElementById('find_change_pw').disabled=true;
            }
        }

    }


});

function Question(q){
    switch(q){
        case 0:
            return '당신이 태어난 고향은?';
        case 1:
            return '졸업한 초등학교 이름은?';
        case 2:
            return '가장 소중한 보물 1호는?';
        case 3:
            return '당신의 첫 해외여행지는?';
        case 4:
            return '가장 존경하는 인물은?';
    }
}
