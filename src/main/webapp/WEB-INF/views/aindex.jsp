<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title></title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

    <script type="text/javascript">
        var a;
        var b;
        function doAjax() {

            var inputText = $("#input_str").val();
            a = {"one" : inputText};
            b = JSON.stringify(a);

            $.ajax({
                url : 'ajaxtest',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                mimeType: 'application/json',
                data :  b,

                success: function (data) {
                    console.log(data);
                    var result = data.id +' ' + data.name + ' ' + data.birthday;
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
