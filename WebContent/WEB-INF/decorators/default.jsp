<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %> 
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <jsp:include page="/WEB-INF/layout/head.jsp" />
</head>

<body>

    <div class="d-flex justify-content-between">
        <!-- SIDE BAR -->
        <jsp:include page="/WEB-INF/layout/sidebar.jsp" />

        <div id="admin-wrapper">
            <!-- HEADER -->
            <jsp:include page="/WEB-INF/layout/navbar.jsp" />

            <!-- CONTENT -->
            <dec:body></dec:body>
            
        </div>
    </div>
    <jsp:include page="/WEB-INF/layout/footer.jsp" />
    <dec:getProperty property="page.scripts" />
</body>

</html>