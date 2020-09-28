<%--
  Created by IntelliJ IDEA.
  User: 孙阔
  Date: 2020/9/27
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/static/js/jquery-1.12.4.js"></script>
</head>
<body>
<center>
    <form method="post" action="/selectByTypeAndName">
        <h2>图书借阅系统</h2>
        <p>
            图书分类:
            <select name="bookType">
                <c:if test="${bookType==0}">
                    <option value="0" selected>--请选择--</option>
                </c:if>
                <c:if test="${bookType!=0}">
                    <option value="0">--请选择--</option>
                </c:if>
                <c:if test="${bookType==1}">
                    <option value="1" selected>小说</option>
                </c:if>
                <c:if test="${bookType!=1}">
                    <option value="1">小说</option>
                </c:if>
                <c:if test="${bookType==2}">
                    <option value="2" selected>文学</option>
                </c:if>
                <c:if test="${bookType!=2}">
                    <option value="2">文学</option>
                </c:if>
                <c:if test="${bookType==3}">
                    <option value="3" selected>传记</option>
                </c:if>
                <c:if test="${bookType!=3}">
                    <option value="3">传记</option>
                </c:if>
                <c:if test="${bookType==4}">
                    <option value="4" selected>艺术</option>
                </c:if>
                <c:if test="${bookType!=4}">
                    <option value="4">艺术</option>
                </c:if>
                <c:if test="${bookType==5}">
                    <option value="5" selected>少儿</option>
                </c:if>
                <c:if test="${bookType!=5}">
                    <option value="5">少儿</option>
                </c:if>
                <c:if test="${bookType==6}">
                    <option value="6" selected>经济</option>
                </c:if>
                <c:if test="${bookType!=6}">
                    <option value="6">经济</option>
                </c:if>
                <c:if test="${bookType==7}">
                    <option value="7" selected>管理</option>
                </c:if>
                <c:if test="${bookType!=7}">
                    <option value="7">管理</option>
                </c:if>
                <c:if test="${bookType==8}">
                    <option value="8" selected>科技</option>
                </c:if>
                <c:if test="${bookType!=8}">
                    <option value="8">科技</option>
                </c:if>
                <%--<option value="0">--请选择--</option>
                <option value="1">小说</option>
                <option value="2">文学</option>
                <option value="3">传记</option>
                <option value="4">艺术</option>
                <option value="5">少儿</option>
                <option value="6">经济</option>
                <option value="7">管理</option>
                <option value="8">科技</option>--%>
            </select>
            图书名称:
            <input type="text" name="bookName" value="${bookName}">
            是否借阅:
            <select name="isBorrow">
               <c:if test="${isBorrow==0}">
                    <option value="0" selected>未借阅</option>
                </c:if>
                <c:if test="${isBorrow!=0}">
                    <option value="0">未借阅</option>
                </c:if>
                <c:if test="${isBorrow==1}">
                    <option value="1" selected>已借阅</option>
                </c:if>
                <c:if test="${isBorrow!=1}">
                    <option value="1">已借阅</option>
                </c:if>
                <c:if test="${isBorrow==3}">
                    <option value="3" selected>--全部-</option>
                </c:if>
                <c:if test="${isBorrow!=3}">
                    <option value="3">--全部-</option>
                </c:if>
                <%--  <option value="0">--请选择--</option>
                  <option value="1" >已借阅</option>
                  <option value="2">未借阅</option>--%>
            </select>
            <input type="submit" value="查询">
        </p>
        <p>
            <a style="margin-left: 400px">当前用户:${userName}</a>

            <a href="/tuichu">退出</a>
        </p>
        <table border="1px" width="800px">
            <tr style="text-align: center" id="shou">
                <td>图书编号</td>
                <td>图书分类</td>
                <td>图书名称</td>
                <td>作者</td>
                <td>出版社</td>
                <td>操作</td>
            </tr>
            <c:forEach var="book" items="${pageInfo.list}">
                <tr style="text-align: center" class="bian">
                    <td>${book.bookCode}</td>
                    <td><c:if test="${book.bookType==1}">小说</c:if>
                        <c:if test="${book.bookType==2}">文学</c:if>
                        <c:if test="${book.bookType==3}">传记</c:if>
                        <c:if test="${book.bookType==4}">艺术</c:if>
                        <c:if test="${book.bookType==5}">少儿</c:if>
                        <c:if test="${book.bookType==6}">经济</c:if>
                        <c:if test="${book.bookType==7}">管理</c:if>
                        <c:if test="${book.bookType==8}">科技</c:if>
                    </td>
                    <td>${book.bookName}</td>
                    <td>${book.bookAtuthor}</td>
                    <td>${book.publishPress}</td>
                    <td><c:if test="${book.isBorrow==1}"><a href="javascript:void(0)" onclick="setZero(${book.bookId})">已借阅</a></c:if>
                        <c:if test="${book.isBorrow==0}"><a href="javascript:void(0)" onclick="setOne(${book.bookId})">申请借阅</a></c:if>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <div>
                    <a href="selectByTypeAndName?pageIndex=${pageInfo.firstPage}">首页</a>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <a href="selectByTypeAndName?pageIndex=${pageInfo.prePage}">上一页</a>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="i">
                        <a href="selectByTypeAndName?pageIndex=${i}">${i}</a>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}">
                        <a href="selectByTypeAndName?pageIndex=${pageInfo.nextPage}">下一页</a>
                    </c:if>
                </div>
            </tr>
        </table>
    </form>
</center>
<script type="text/javascript">
    $("#shou").css("background-color", "#5B5C60");
    $(".bian:odd").css("background-color", "#7F8084");
    function setZero (id) {
        $.ajax({
            type:"GET",
            url:"/setIsBorrowZero/"+id,
            data:{id:id},
            dataType:"json",
            success:function (data) {
                if(data.result=="true"){
                    alert("成功归还图书");
                    location.href="selectByTypeAndName";
                }else{
                    alert("归还图书失败");
                    location.href="selectByTypeAndName";
                }
            }
        })
    }
    function  setOne(id) {
        $.ajax({
            type:"GET",
            url:"/setIsborrowOne/"+id,
            data:{id:id},
            dataType:"json",
            success:function (data) {
                if(data.result=="true"){
                    alert("成功借阅图书");
                    location.href="selectByTypeAndName";
                }else{
                    alert("借阅图书失败");
                    location.href="selectByTypeAndName";
                }
            }
        })

    }
</script>
</body>
</html>
