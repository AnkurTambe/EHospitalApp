<?php

$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("select tech_name,tech_id, Salary, Qualifications, phone_no, lab_no, type_of_test from lab_tech natural join lab where tech_id =?;");
$st_check->bind_param("s", $_GET["tech_id"]);
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);
