   let index = {

       init:function(){
           $("#btn-save").on("click", () =>{ //()=>{} this 바인딩하기 위해
               this.save();
           });

       },


    save:function(){
        //alert("user의 save함수 호출됨");
        //console.log("hello");

         let data = {
            title: $("#title").val(),
            content: $("#content").val()
         }
         //console.log(data);
         $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
         }).done(function(resp){
            alert("글쓰기가 완료되었습니다");
           // console.log(resp);
            location.href = "/";
         }).fail(function(error){
            //회원가입 응답 데이터 유요하지 않음
            alert(JSON.stringify(error));
         });
        }
    }

index.init();