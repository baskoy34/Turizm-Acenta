<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html dir="ltr" lang="en">
<head>
    <meta name="_csrf" content="${_csrf.token}" />
    <meta name="_csrf_header" content="${_csrf.headerName}" />
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1" >
    <meta name="description" content="">
    <meta name="author" content="">


    <!-- Custom CSS -->
    <link href="../../resources/css/style.min.css" rel="stylesheet">
    <link href="../../resources/css/toastr.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">

    <![endif]-->
</head>


<body>
<%--  <div>--%>
<%--    <div id="header">--%>
<%--        <h2>CRM - Customer Relationship Manager</h2>--%>
<%--    </div>--%>

<%--    <div id="container">--%>
<%--        <h3> Save Customer </h3>--%>

<%--        <form:form action="updateUser" modelAttribute="users" method="post">--%>

<%--            <table>--%>
<%--                <tbody>--%>
<%--                <tr>--%>
<%--                    <td><label>First Name:</label></td>--%>
<%--                    <td><form:input path="username" /></td>--%>
<%--                </tr>--%>

<%--                <tr>--%>
<%--                    <td><label>Last Name:</label></td>--%>
<%--                    <td><form:input path="password" /></td>--%>
<%--                </tr>--%>

<%--                <tr>--%>
<%--                    <td><label>Email:</label></td>--%>
<%--                    <td><form:input path="userType" /></td>--%>
<%--                </tr>--%>

<%--                <tr>--%>
<%--                    <td><label></label></td>--%>
<%--                    <td><input type="submit" value="Save" class="save"/></td>--%>
<%--                </tr>--%>

<%--                </tbody>--%>
<%--            </table>--%>


<%--        </form:form>--%>

<%--        <div style="clear: both"></div>--%>

<%--        <p>--%>
<%--            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>--%>
<%--        </p>--%>
<%--  </div>--%>
<%--  </div>--%>

  <div id="main-wrapper">
      <!-- ============================================================== -->
      <!-- Topbar header - style you can find in pages.scss -->
      <!-- ============================================================== -->
      <jsp:include page="topHeader.jsp"></jsp:include>
      <!-- ============================================================== -->
      <!-- End Topbar header -->
      <!-- ============================================================== -->
      <!-- ============================================================== -->
      <!-- Left Sidebar - style you can find in sidebar.scss  -->
      <!-- ============================================================== -->
      <jsp:include page="leftSideBar.jsp"></jsp:include>


      <div class="page-wrapper">
          <!-- ============================================================== -->
          <!-- Bread crumb and right sidebar toggle -->
          <!-- ============================================================== -->
          <div class="page-breadcrumb">
              <div class="row">
                  <div class="col-5 align-self-center">
                      <h4 class="page-title">Dashboard</h4>
                  </div>
                  <div class="col-7 align-self-center">
                      <div class="d-flex align-items-center justify-content-end">
                          <nav aria-label="breadcrumb">
                              <ol class="breadcrumb">
                                  <li class="breadcrumb-item">
                                      <a href="#">Home</a>
                                  </li>
                                  <li class="breadcrumb-item active" aria-current="page">Kullanıcı Oluştur</li>
                              </ol>
                          </nav>
                      </div>
                  </div>
              </div>
              <div class="container-fluid mt-3">
                  <div class="row">
                      <div class="col-lg-12">
                          <div class="card">
                              <div class="card-header bg-info">
                                  <h4 class="m-b-0 text-white">Kullanıcı tanımlama ve yetkilendirme</h4>
                              </div>
                              <div class="card-body">
                                  <h4 class="card-title">Kulanıcı Bilgileri</h4>
                              </div>
                              <hr>

                             <form:form action="updateUser" modelAttribute="users" method="post">
                              <form:hidden path="id" />
                               <div class="form-body">
                                  <div class="card-body">
                                      <div class="row p-t-20">
                                          <div class="col-md-6">
                                              <div class="form-group">
                                                  <label class="control-label">Username</label>
                                                  <form:input path="username" type="text" class="form-control"/>
                                                      <%--                                                    <small class="form-control-feedback"> This is inline help </small> --%>
                                              </div>
                                          </div>
                                          <!--/span-->
                                          <div class="col-md-6">
                                              <div class="form-group has-danger">
                                                  <label class="control-label">password</label>
                                                  <form:input path="password" type="password" id="password" name="password" class="form-control form-control-danger" />
                                                      <%--                                                    <small class="form-control-feedback"> This field has error. </small> --%>
                                              </div>
                                          </div>
                                          <!--/span-->
                                      </div>
                                      <!--/row-->
                                      <div class="row">
                                          <div class="col-md-12">
                                              <div class="form-group has-success">
                                                  <label class="control-label">Kullanıcı Rolu</label>
                                                  <select class="form-control custom-select" name="userType">
                                                      <c:forEach items="${userRoles}" var="role">
                                                          <option value="${role}">${users.userType}</option>
                                                      </c:forEach>
                                                  </select>
                                              </div>
                                          </div>
                                      </div>
                                  <hr>
                                  <div class="form-actions">
                                      <div class="card-body">
                                          <button type="submit" class="btn btn-success"> <i class="fa fa-check"></i>Kaydet</button>
                                          <button type="button" class="btn btn-dark">İptal</button>
                                      </div>
                                  </div>
                              </div>
                              </form>
                          </div>
                      </div>
                  </div>
               </div>
              </form:form>
              <jsp:include page="footer.jsp"></jsp:include>
          </div>
      </div>
 </body>
</html>
