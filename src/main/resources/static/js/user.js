let index = {

    init:function(){
        $("#btn-save").on("click", () =>{ //()=>{} this 바인딩하기 위해
            this.save();
        });
        $("#btn-login").on("click", () =>{ //()=>{} this 바인딩하기 위해
            this.login();
        });
    },

    save:function(){
        //alert("user의 save함수 호출됨");
        //console.log("hello");

        //id값으로 찾은 후에 변수 저장하는 로직
         let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
         }
         //console.log(data);
         //ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해준다.
         $.ajax({
            //회원가입 수행 요청
            type: "POST",
            url: "/blog/api/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴 게 json이라면 ) => javaScript 오브젝트로 변환
         }).done(function(resp){
            //회원가입 응답 데이터 유효
            alert("회원가입이 완료되었습니다");
           // console.log(resp);
            location.href = "/blog";
         }).fail(function(error){
            //회원가입 응답 데이터 유요하지 않음
            alert(JSON.stringify(error));
         }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경해서 inset 요청
    },

     login:function(){
            //alert("user의 save함수 호출됨");
            //console.log("hello");

            //id값으로 찾은 후에 변수 저장하는 로직
             let data = {
                username: $("#username").val(),
                password: $("#password").val()
             }
             //console.log(data);
             //ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해준다.
             $.ajax({
                //회원가입 수행 요청
                type: "POST",
                url: "/blog/api/user/login",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴 게 json이라면 ) => javaScript 오브젝트로 변환
             }).done(function(resp){
                //회원가입 응답 데이터 유효
                alert("로그인이 완료되었습니다");
               // console.log(resp);
                location.href = "/blog";
             }).fail(function(error){
                //회원가입 응답 데이터 유요하지 않음
                alert(JSON.stringify(error));
             }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경해서 inset 요청
        }
}

index.init();