<?php

$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("select HR_Name,HR_ID , Salary, Timing, phone_no from hr where HR_ID = ?");
$st_check->bind_param("s", $_GET["HR_ID"]);
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);
