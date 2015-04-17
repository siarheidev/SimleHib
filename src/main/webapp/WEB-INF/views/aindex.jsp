<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 13.04.2015
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

  <script type="text/javascript">
      var a = {"one" : "jn", "two" : "ff"};
      var b = JSON.stringify(a);
    function doAjax() {

//        var a = { one : "inputText", two : "two"};
        var a = {"one" : "jn", "two" : "ff"};
        var b = JSON.stringify(a);

        var inputText = $("#input_str").val();
//      $.post("ajaxtest", b,
//              function (data) {
////                 data = JSON.stringify(data);
//                console.log(data);
//              }
//      );


      $.ajax({
        url : 'ajaxtest/a',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        mimeType: 'application/json',
        data :  b,

        success: function (data) {

          console.log(data);

          var result = data.one +' ' + data.two;
          $("#result_text").text(result);
        },
        failure: function(errorMsg) {
          alert("Ошибка.");
        }
      });


    }
  </script>
    <%--<script type="text/javascript" >--%>
        <%--$(document).ready(function(){--%>
            <%--sendAjax();--%>
        <%--});--%>

        <%--function sendAjax() {--%>

            <%--$.ajax({--%>
                <%--url: "ajaxtest",--%>
                <%--type: 'POST',--%>
                <%--dataType: 'json',--%>
                <%--data:  ({one: "hmkcode", two: "kkk"}),--%>
                <%--contentType: 'application/json',--%>
                <%--mimeType: 'application/json',--%>
                <%--success: function(data) {--%>
                    <%--alert(data.one + " " + data.two);--%>
                <%--},--%>
                <%--error:function(data,status,er) {--%>
                    <%--alert("error: "+data+" status: "+status+" er:"+er);--%>
                <%--}--%>
            <%--});--%>
        <%--}--%>

    <%--</script>--%>

</head>
<body>

<h3>Enter text:</h3>
<input id="input_str" type="text">
<input type="button" value="OK" onclick="doAjax()">
<p id="result_text"></p>

</body>
</html>
