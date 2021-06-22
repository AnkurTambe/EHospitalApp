<?php

$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("select a_id, name from admin where phone_no=?");
$st_check->bind_param("s", $_GET["phone_no"]);
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);
