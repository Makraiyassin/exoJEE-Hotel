<%@ page import="com.bxl.javatym.hotel.models.Room" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bxl.javatym.hotel.service.RoomService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <%@include file="assets/include/toADD.jsp"%>
</head>
<body>

<%@include file="assets/include/navBar.jsp"%>

<%
    Room room = (Room) request.getAttribute("room");
%>

<div class="w-75 mx-auto">
    <form action="<%=request.getContextPath()%>/booking/insert" method="post" class="w-50 mx-auto text-center">
        <img src="https://res.cloudinary.com/hzekpb1cg/image/upload/c_fill,h_581,w_1185,f_auto/s3/public/prod/s3fs-public/Chambre-double.png"  class="img-fluid mx-auto" alt="...">
        <h5 class="text-center"><%=room.getType()%> n°<%= room.getId()%></h5>
        <input type="hidden" name="room_id" value="<%=room.getId()%>">
        <input type="hidden" name="type" value="<%=room.getType()%>">
        <div class="w-50 mx-auto">
            <div class="input-group mb-3">
                <span class="input-group-text">firstname</span>
                <input type="text" class="form-control"  name="customerFirstname">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">lastname</span>
                <input type="text" class="form-control"  name="customerLastname">
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text" id="from">from</span>
                <input type="datetime-local" class="form-control"  name="dateBegin">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="to">to</span>
                <input type="datetime-local" class="form-control" name="dateEnd">
            </div>
        </div>
        <div class="col-12 mx-auto">
            <button type="submit" class="btn btn-primary">Book</button>
        </div>
    </form>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>

