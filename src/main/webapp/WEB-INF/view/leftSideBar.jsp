<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionInfo.user.userType eq 'ADMIN'}">
<aside class="left-sidebar">
    <!-- Sidebar scroll-->
    <div class="scroll-sidebar">
        <!-- Sidebar navigation-->
        <nav class="sidebar-nav">
            <ul id="sidebarnav">
                <li class="nav-small-cap">
                    <i class="mdi mdi-dots-horizontal"></i>
                    <span class="hide-menu">ACENTALAR</span>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false">
                        <i class="mdi mdi-av-timer"></i>
                        <span class="hide-menu">Dashboard </span>
                        <span class="badge badge-pill badge-info ml-auto m-r-15">3</span>
                    </a>
                    <ul aria-expanded="false" class="collapse  first-level">
                        <li class="sidebar-item">
                            <a href="index.html" class="sidebar-link">
                                <i class="mdi mdi-adjust"></i>
                                <span class="hide-menu"> Classic </span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a href="index.jsp" class="sidebar-link">
                                <i class="mdi mdi-adjust"></i>
                                <span class="hide-menu"> Analytical </span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a href="index3.html" class="sidebar-link">
                                <i class="mdi mdi-adjust"></i>
                                <span class="hide-menu"> Modern </span>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="sidebar-item">
                    <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false">
                        <i class="mdi mdi-tune"></i>
                        <span class="hide-menu">Yönetim Paneli </span>
                    </a>
                    <ul aria-expanded="false" class="collapse  first-level">
                        <li class="sidebar-item">
                            <a href="<c:url value="/admin/createUser"/>" class="sidebar-link">
                                <i class="mdi mdi-view-quilt"></i>
                                <span class="hide-menu">Kullanıcı Oluştur</span>
                            </a>
                        </li>

                        <li class="sidebar-item">
                            <a href="<c:url value="/admin/listUser"/>" class="sidebar-link">
                                <i class="mdi mdi-view-quilt"></i>
                                <span class="hide-menu">Kullanıcı Listele</span>
                            </a>
                        </li>
                    </ul>


            </ul>
        </nav>
        <!-- End Sidebar navigation -->
    </div>
    <!-- End Sidebar scroll-->
</aside>
</c:if>

<c:if test="${sessionInfo.user.userType eq 'ACENTA'}">
    <aside class="left-sidebar">
        <!-- Sidebar scroll-->
        <div class="scroll-sidebar">
            <!-- Sidebar navigation-->
            <nav class="sidebar-nav">
                <ul id="sidebarnav">
                    <li class="nav-small-cap">
                        <i class="mdi mdi-dots-horizontal"></i>
                        <span class="hide-menu">Personal</span>
                    </li>
                    <li class="sidebar-item">
                        <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false">
                            <i class="mdi mdi-av-timer"></i>
                            <span class="hide-menu">Dashboard </span>
                            <span class="badge badge-pill badge-info ml-auto m-r-15">3</span>
                        </a>
                        <ul aria-expanded="false" class="collapse  first-level">
                            <li class="sidebar-item">
                                <a href="index.html" class="sidebar-link">
                                    <i class="mdi mdi-adjust"></i>
                                    <span class="hide-menu"> Classic </span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a href="index.jsp" class="sidebar-link">
                                    <i class="mdi mdi-adjust"></i>
                                    <span class="hide-menu"> Analytical </span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a href="index3.html" class="sidebar-link">
                                    <i class="mdi mdi-adjust"></i>
                                    <span class="hide-menu"> Modern </span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-item">
                        <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false">
                            <i class="mdi mdi-tune"></i>
                            <span class="hide-menu">Sidebar Type </span>
                        </a>
                        <ul aria-expanded="false" class="collapse  first-level">
                            <li class="sidebar-item">
                                <a href="sidebar-type-minisidebar.html" class="sidebar-link">
                                    <i class="mdi mdi-view-quilt"></i>
                                    <span class="hide-menu"> Minisidebar </span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a href="sidebar-type-iconsidebar.html" class="sidebar-link">
                                    <i class="mdi mdi-view-parallel"></i>
                                    <span class="hide-menu"> Icon Sidebar </span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a href="sidebar-type-overlaysidebar.html" class="sidebar-link">
                                    <i class="mdi mdi-view-day"></i>
                                    <span class="hide-menu"> Overlay Sidebar </span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a href="sidebar-type-fullsidebar.html" class="sidebar-link">
                                    <i class="mdi mdi-view-array"></i>
                                    <span class="hide-menu"> Full Sidebar </span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a href="sidebar-type-horizontalsidebar.html" class="sidebar-link">
                                    <i class="mdi mdi-view-module"></i>
                                    <span class="hide-menu"> Horizontal Sidebar </span>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <!-- End Sidebar navigation -->
        </div>
        <!-- End Sidebar scroll-->
    </aside>
</c:if>