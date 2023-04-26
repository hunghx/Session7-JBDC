<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/4/2023
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>Basic React Lab</title>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col grid-margin stretch-card">
            <div class="card">
                <!-- START CONTROL -->
                <div class="card-header">
                    <div class="row">
                        <div class="col-3">
                            <button type="button" class="btn btn-primary btn-icon-text">
                                <a href="views/newStudent.jsp" class="text-light"> Thêm mới sinh viên</a>
                            </button>
                        </div>
                        <div class="col-6">
                            <form class="search-form" method="get" action="<%=request.getContextPath()%>/StudentServlet">
                                <i class="icon-search"></i>
                                <input
                                        type="search"
                                        class="form-control"
                                        placeholder="Search Here"
                                        title="Search here"
                                        name="search"
                                />
                                <button type="submit" name="action" value="SEARCH" class="btn btn-primary btn-icon-text">
                                    Search
                                </button>
                            </form>
                        </div>
                        <div class="col-3 d-flex align-items-center">
                            <select class="form-control">
                                <option value="">Sắp xếp</option>
                                <option value="">ABC def</option>
                                <option value="">ABC def</option>
                                <option value="">ABC def</option>
                            </select>
                        </div>
                    </div>
                </div>
                <!-- END CONTROL -->
                <!-- START LIST STUDENT -->
                <div class="card-body">
                    <h3 class="card-title">Danh sách sinh viên</h3>
                    <div class="table-responsive pt-3">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Mã sinh viên</th>
                                <th>Tên sinh viên</th>
                                <th>Ngày Sinh</th>
                                <th>Giới tính</th>
                                <th>Hành động</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="st" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${st.id}</td>
                                    <td>${st.name}</td>
                                    <td>${st.birthday}</td>
                                    <td>${st.gen?"Nam":"Nữ"}</td>
                                    <td>
                                        <div class="template-demo">
                                            <button
                                                    type="button"
                                                    class="btn btn-danger btn-icon-text"
                                            >
                                                Xem
                                            </button>
                                            <button
                                                    type="button"
                                                    class="btn btn-warning btn-icon-text"
                                            ><a href="StudentServlet?action=EDIT&id=${st.id}">Sửa</a>
                                            </button>
                                            <button
                                                    type="button"
                                                    class="btn btn-success btn-icon-text"
                                            >
                                                <a class="text-light" href="StudentServlet?action=DELETE&id=${st.id}">Xóa</a>
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- END LIST STUDENT -->
            </div>
        </div>
        <!-- START FORM SINH VIEN -->
        <!-- END FORM SINH VIÊN -->
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>