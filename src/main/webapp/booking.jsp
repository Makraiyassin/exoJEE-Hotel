<%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 15-07-22
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
    <%@include file="WEB-INF/assets/toADD.jsp"%>
</head>
<body>

<%@include file="WEB-INF/assets/navBar.jsp"%>

<div class="input-group mb-3">
    <form action="<%= request.getContextPath() %>/maman" method="post">
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Check-In</label>
            <input type="datetime-local" class="form-control" id="formGroupExampleInput" placeholder="Auto-Increment" name="datein">
        </div>
        <div class="mb-4">
            <label for="formGroupExampleInput" class="form-label">Check-Out</label>
            <input type="datetime-local" class="form-control" id="formGroupExampleInput" placeholder="Auto-Increment" name="dateout">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Capacity</label>
            <input type="number" class="form-control" id="formGroupExampleInput2" placeholder="Enter name" name="capacity">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Type</label>
            <input type="text" class="form-control" id="formGroupExampleInput3" placeholder="Enter Brand" name="type">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Category</label>
            <input type="text" class="form-control" id="formGroupExampleInput4" placeholder="Enter Category" name="category">
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
            <label class="form-check-label" for="flexCheckDefault">
                50$ to 70$
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
            <label class="form-check-label" for="flexCheckChecked">
                70 to 90$
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
            <label class="form-check-label" for="flexCheckChecked">
                90$ to 150$
            </label>
        </div>
        <div class="mb-3">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="autoSizingCheck">
                <label class="form-check-label" for="autoSizingCheck">
                    Agree to terms and conditions
                </label>
                <div class="invalid-feedback">
                    You must agree before submitting.
                </div>
            </div>
            <br>
        <button class="btn btn-outline-secondary" type="submit" id="button-addon1">Send</button>
    </form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>
