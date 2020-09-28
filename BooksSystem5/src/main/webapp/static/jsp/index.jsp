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
    <form method="post" action="/index">
    <h2>图书借阅系统</h2>
    <p>
        图书分类:
        <select name="bookType">
            <option value="0">--请选择--</option>
            <option value="1">小说</option>
            <option value="2">文学</option>
            <option value="3">传记</option>
            <option value="4">艺术</option>
            <option value="5">少儿</option>
            <option value="6">经济</option>
            <option value="7">管理</option>
            <option value="8">科技</option>
        </select>&nbsp;&nbsp;&nbsp;
        图书名称:
        <input type="text" name="title">&nbsp;&nbsp;&nbsp;
        是否借阅:
        <select name="isBorrow">
            <option value="2">--请选择--</option>
            <option value="1">已借阅</option>
            <option value="0">未借阅</option>
        </select>&nbsp;&nbsp;&nbsp;
        <input type="submit" value="查询">
    </p>
    </form>
    <p>
        <a style="margin-left: 500px">当前用户:${users.userCode}</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/logout">退出</a>
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
        <c:if test="${PageInfo.list.size()==0}">
            <tr>
                <td colspan="6" align="center">对不起，没有符合查询的条件</td>
            </tr>
        </c:if>
        <c:if test="${PageInfo.list.size()>0}">
            <c:forEach items="${PageInfo.list}" var="item">
                <tr style="text-align: center" class="bian">
                    <td>${item.bookCode}</td>
                    <td>
                        <c:if test="${item.bookType==1}">
                            <a>小说</a>
                        </c:if>
                        <c:if test="${item.bookType==2}">
                            <a>文学</a>
                        </c:if>
                        <c:if test="${item.bookType==3}">
                            <a>传记</a>
                        </c:if>
                        <c:if test="${item.bookType==4}">
                            <a>艺术</a>
                        </c:if>
                        <c:if test="${item.bookType==5}">
                            <a>少儿</a>
                        </c:if>
                        <c:if test="${item.bookType==6}">
                            <a>经济</a>
                        </c:if>
                        <c:if test="${item.bookType==7}">
                            <a>管理</a>
                        </c:if>
                        <c:if test="${item.bookType==8}">
                            <a>科技</a>
                        </c:if>
                    </td>
                    <td>${item.bookName}</td>
                    <td>${item.bookAtuthor}</td>
                    <td>${item.publishPress}</td>
                    <td>
                        <c:if test="${item.isBorrow==0}">
                            <a>未借阅</a>
                        </c:if>
                        <c:if test="${item.isBorrow==1}">
                            <a>已借阅</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
<c:if test="${PageInfo.list.size()>0}">
        <div>
            <a href="/index?pageNumStr=${PageInfo.firstPage}">首页</a>
            <c:if test="${PageInfo.hasPreviousPage}">
                <a href="/index?pageNumStr=${PageInfo.prePage}">上一页</a>
            </c:if>
            <c:if test="${PageInfo.hasNextPage}">
                <a href="/index?pageNumStr=${PageInfo.nextPage}">下一页</a>
            </c:if>
            <a href="/index?pageNumStr=${PageInfo.lastPage}">末页</a>
            <span>第${PageInfo.pageNum}页/共${PageInfo.pages}页</span>
        </div>
</c:if>
</center>
<script type="text/javascript">
    $("#shou").css("background-color","#5B5C60");
    $(".bian:odd").css("background-color","#7F8084");
</script>
</body>
</html>
