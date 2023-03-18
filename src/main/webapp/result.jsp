<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    Available Books
</h1>
<%
    out.println("<br>We have <br><br>");
    for(int i=0; i<10; i++) {
        out.println("<br/>book " + i);
    }
%>
</body>
</html>