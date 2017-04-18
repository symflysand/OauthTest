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
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(function () {

            $('#ajax').click(function () {
                var url = "user/getUsers";
                url = 'user/add';
                $.ajax({
                    type:'post',
                    url:url,
                    dataType:'json',
                    //data:'pageIndex=1&pageSize=5',
                    data:'username=admin',
                    success:function(data){
                        if(data.value==true){
                            alert("添加成功");
                            console.log("添加成功");
                        }else{
                            console.log("添加失败");
                        }
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
