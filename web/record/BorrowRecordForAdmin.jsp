<%@ page import="model.BorrowrecordEntity" %><%--
  Created by IntelliJ IDEA.
  User: laikinmeng
  Date: 2019-01-25
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Borrow Records</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<jsp:useBean id="borrowedRecordList" type="java.util.ArrayList<model.BorrowrecordEntity>" scope="session"/>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="<%out.println(request.getContextPath()+"/index");%>">
        <img src="data:image/jpeg;base64,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"
             width="30" height="30" class="d-inline-block align-top" alt="">
        Borrow Record
    </a>
</nav>

<ul class="nav border nav-pills">
    <li class="nav-item" style="margin: 8px">
        <a class="nav-link <%%>"
           href="<%out.println(request.getContextPath()+"/BorrowRecordForAdmin?userId=1");%>">Check
            undergraduate</a>
    </li>
    <li class="nav-item" style="margin: 8px">
        <a class="nav-link" href="<%out.println(request.getContextPath()+"/BorrowRecordForAdmin?userId=2");%>">Check graduate</a>
    </li>
    <li class="nav-item" style="margin: 8px">
        <a class="nav-link" href="<%out.println(request.getContextPath()+"/BorrowRecordForAdmin?userId=3");%>">Check teacher</a>
    </li>
</ul>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Book id.</th>
        <th scope="col">User id.</th>
        <th scope="col">Borrow Date</th>
        <th scope="col">Should return</th>
        <th scope="col">Return Date</th>
    </tr>
    </thead>
    <tbody>
    <%for (BorrowrecordEntity borrowrecordEntity : borrowedRecordList) { %>
    <tr>
        <th scope="row" class="align-middle">
            <%out.println(borrowrecordEntity.getRid());%>
        </th>
        <td class="align-middle">
            <%out.println(borrowrecordEntity.getBid());%>
        </td>
        <td class="align-middle">
            <%out.println(borrowrecordEntity.getUid());%>
        </td>
        <td class="align-middle">
            <%out.println(borrowrecordEntity.getBorrowdate());%>
        </td>
        <td class="align-middle">
            <%out.println(borrowrecordEntity.getShouldreturndate());%>
        </td>
        <td class="align-middle">
            <%out.println(borrowrecordEntity.getReturndate());%>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
</body>
</html>
