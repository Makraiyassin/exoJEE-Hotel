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

<%! private final RoomService service = RoomService.getInstance(); %>

<% String id = request.getParameter("id");
    if (id == null) {
        response.setStatus(404);
        return;
    }

    System.out.println("in the method service");
    Room p = service.getOne(Integer.parseInt(id));

%>

<div class="card" style="width: 18rem;">
    <img src="https://res.cloudinary.com/hzekpb1cg/image/upload/c_fill,h_581,w_1185,f_auto/s3/public/prod/s3fs-public/Chambre-double.png" class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">Room number <%= p.getId()%></h5>
        <p class="card-text">he 5-star Hotel Amigo boasts elegant rooms with designer features, ...</p>
        <a href="#" class="btn btn-primary">Book now</a>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>


<%--<h5 class="card-title">Room number : <%=room.getId()%></h5>--%>
<%--<p class="card-text">type : <%=room.getType()%></p>--%>
<%--<p class="card-text">capacity : <%=room.getCapacity()%></p>--%>
<%--<p class="card-text">price : <%=room.getPrice()%> €</p>--%>

