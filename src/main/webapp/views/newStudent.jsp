<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/4/2023
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>Basic React Lab</title>
</head>

<body>
<div class="row">
    <div class="card">
        <div class="card-body">
            <h3 class="card-title">Thông tin sinh viên</h3>
            <form class="form-sample" action="<%=request.getContextPath()%>/StudentServlet" method="post">
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label">Mã sinh viên</label>
                    <div class="col-sm-9">
                        <input type="text" name="id" class="form-control" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label">Tên sinh viên</label>
                    <div class="col-sm-9">
                        <input type="text" name="name" class="form-control" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label">ngày sinh</label>
                    <div class="col-sm-9">
                        <input type="date" name="birthday" class="form-control" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label">Giới tính</label>
                    <div class="col-sm-9">
                        <select class="form-control" name="gen">
                            <option value="true">Nam</option>
                            <option value="false">Nữ</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label">Nơi sinh</label>
                    <div class="col-sm-9">
                        <select class="form-control" name="place">
                            <option value="HN">Hà Nội</option>
                            <option value="HCM">TP. Hồ Chí Minh</option>
                            <option value="DN">Đà Nẵng</option>
                            <option value="QN">Quảng Ninh</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label">Địa chỉ</label>
                    <div class="col-sm-9">
                        <textarea name="address" class="form-control"></textarea>
                    </div>
                </div>
                <input type="submit" class="btn btn-primary me-2" name="action" value="CREATE">
            </form>
        </div>
    </div>
</div>
<!-- END FORM SINH VIÊN -->
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</body>
</html>
