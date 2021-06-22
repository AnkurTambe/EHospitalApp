<?php

$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("select Main_name, main_id,  Salary, Main_type, Street, City, phone_no from maintenance where main_id = ?;");
$st_check->bind_param("s", $_GET["main_id"]);
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);
