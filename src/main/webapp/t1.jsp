<%--
  Created by IntelliJ IDEA.
  User: jianyi
  Date: 2017年3月31日 0031
  Time: 13:47:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="_csrf" content="${_csrf.token}">
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(function () {

            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            $('#ajax').click(function () {
                var url = "user/getUsers";
                url = 'oauth/token';
                $.ajax({
                    type:'post',
                    url:url,
                    dataType:'json',
                    data:'client_id=test&client_secret=123456&grant_type=password&username=user&password=123',
                    //data:'pageIndex=1&pageSize=10',
                    success:function(data){
                        console.log(data)
                    },
                    error:function (data) {
                        console.log("系统异常");
                    }/*,
                     complete:function (data) {
                     console.log(data);
                     }*/

                });

            });
        });
    </script>
</head>
<body>
mytest

<input id="ajax" type="button" value="测试ajax"/>
</body>
</html>
