<?php

$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("select  jun_Name, jun_ID, junior_doc.Salary, Qualifications, junior_doc.Years_exp, junior_doc.Night_shift_start, junior_doc.night_shift_end, junior_doc.phone_no, d_name, doc_name from ((junior_doc join department using (d_id)) natural left outer join jun_relation) left outer join doctor using (doc_id) where jun_id = ?;");
$st_check->bind_param("s", $_GET["jun_id"]);
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);
