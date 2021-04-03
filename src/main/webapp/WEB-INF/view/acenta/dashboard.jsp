<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>

    <meta name="_csrf" content="${_csrf.token}" />
    <meta name="_csrf_header" content="${_csrf.headerName}" />
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1" >
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="../../assets/images/favicon.png">
    <title>Nice admin Template - The Ultimate Multipurpose admin template</title>
    <!-- Custom CSS -->
    <!-- Custom CSS -->
    <link href="../../../resources/css/style.min.css" rel="stylesheet">
    <link href="../../../resources/css/toastr.css" rel="stylesheet">
    <link href="../../../resources/css/default.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">

    <![endif]-->

</head>

<body>

<div id="main-wrapper">

    <jsp:include page="../topHeader.jsp"></jsp:include>

    <jsp:include page="../leftSideBar.jsp"></jsp:include>

    <div class="page-wrapper">
        <!-- ============================================================== -->
        <!-- Bread crumb and right sidebar toggle -->
        <!-- ============================================================== -->
        <div class="page-breadcrumb">
            <div class="row">
                <div class="col-5 align-self-center">
                    <h4 class="page-title">Kullanıcı Listesi</h4>
                </div>
                <div class="col-7 align-self-center">
                    <div class="d-flex align-items-center justify-content-end">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item">
                                    <a href="#">Home</a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">Users List</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- End Bread crumb and right sidebar toggle -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Container fluid  -->
        <!-- ============================================================== -->
        <div class="container-fluid">
            <!-- ============================================================== -->
            <!-- Start Page Content -->
            <!-- ============================================================== -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Users</h4>
                            <h6 class="card-subtitle"></h6>
                            <div class="table-responsive">
                                <div class="float-right mb-2">
                                    <a class="addUser" data-toggle="modal" data-target="#createUserModel">
                                        <i class="fa fa-plus">Kullanıcı Ekle</i>
                                    </a>
                                </div>
                                <table id="demo-foo-addrow" class="table m-t-30 no-wrap table-hover contact-list" data-page-size="10">
                                    <thead>
                                    <tr>

                                        <th>İsim</th>
                                        <th>Soyisim</th>
                                        <th>Ücret</th>
                                        <th>Görev</th>
                                        <th>Güncelle</th>
                                        <th>Sil</th>
                                    </tr>
                                    </thead>

                                    <tbody>

                                    <c:forEach var="staff" items="${staffs}" >
                                        <tr>
                                            <td><span class="label label-inverse">${staff.firstName}</span></td>
                                            <td><span class="label label-info">${staff.lastName}</span></td>
                                            <td><span class="label label-info">${staff.price}</span></td>
                                            <td><span class="label label-info">${staff.job}</span></td>


                                            <td>
                                                <a class="updateModel" data-id="${staff.id}" data-username="${tempUsers.username}" data-password="${tempUsers.password}" data-user="${tempUsers.userType}"  >
                                                    <i class="fas fa-edit" data-toggle="tooltip" data-placement="bottom" title=""></i>
                                                </a>
                                            </td>

                                            <td>
                                                <a>
                                                    <i class="fas fa-trash-alt" data-toggle="tooltip" data-placement="bottom" title=""></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="../footer.jsp"></jsp:include>

    </div>
</div>

<div class="modal fadeIn modal-profile" id="createUserModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5>Personel Ekle</h5>
            </div>
            <div class="modal-body">
                <form id="createUserForm" method="post">
                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">İsim</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="firstName" placeholder="İsim">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">Soy İsim</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="lastName" placeholder="Soy İsim">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">Ücret</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" name="price" placeholder="Ücret">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">Görev</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="job" placeholder="Görev">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="personelCreateBtn">Kaydet</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">İptal</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade modal-profile" id="deleteRecordModal" tabindex="-1" role="dialog"
     aria-labelledby="updateService" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">

                <h5 class="modal-title">Kaydı silmek üzeresiniz!</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                Silmek istediğinize emin misiniz ?
            </div>

            <div class="modal-footer">
                <a class="btn btn-danger" id="btnDeleteYes">Evet</a>
                <button type="button" class="btn btn-default" data-dismiss="modal">Hayır</button>
            </div>

        </div>
    </div>
</div>

<script type="text/javascript">

    $(function () {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });

    $(document).ready(function () {

        $("#personelCreateBtn").click(function () {
            event.preventDefault();
            var postData = $('#createUserForm').serializeObject();
            console.log(postData)
            $.ajax({
                type: "post",
                url: "acenta/createStaff",
                data: JSON.stringify(postData),
                contentType: "application/json",
                success: function(response) {
                    if(response.result == 0){
                        toastr.success(response.message)
                        setTimeout(function(){
                            location.reload()
                        },500)
                    }
                    else {
                        console.log(response.message)
                        toastr.error(response.message)
                    }

                },
                error: function(jqXHR, textStatus, errorThrown) {
                    toastr.error("Bilinmeyen Bir Hata oluştu")
                }
            })

        });

    });
</script>

</body>

</html>
