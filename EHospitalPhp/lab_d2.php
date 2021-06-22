<?php

$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("select lab_no, no_of_equipments, type_of_test, d_name from lab natural join lab_d natural join department where lab_no = ?");
$st_check->bind_param("s", $_GET["lab_no"]);
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);
