<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Anasayfa</title>
</head>
<body>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="collg-6 col-md-6 col-sm-6">
                <h5>Hoş geldiniz</h5>
                <p>${test}</p>
            </div>
            <div class="collg-6 col-md-6 col-sm-6">
                <a class="nav-link" href="<c:url value="/logout" />" title="Çıkış Yap">
                    <i class="fas fa-sign-out-alt"></i>
                    <span>Çıkış Yap</span>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>