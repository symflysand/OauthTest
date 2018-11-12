<%--
  Created by IntelliJ IDEA.
  User: jianyi
  Date: 2017年4月18日 0018
  Time: 14:51:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">

        $(function(){
            var url = "user/login";
            var data = "username="+$('#username').val()+"&password=123456";
            $.ajax({
                type:'post',
                url:url,
                data:data,
                success:function(data){
                    console.log(data);
                }

            });

        });
    </script>
</head>
<body>

    <input type="text" name="username" id="username" value="flysand"/>
    <input type="password" name="password" id="password"/>

</body>
</html>
