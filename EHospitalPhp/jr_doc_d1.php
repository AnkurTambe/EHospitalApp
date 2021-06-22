<?php

$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("select jun_Name, qualifications, jun_ID from junior_doc ORDER BY `junior_doc`.`jun_ID` ASC");
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);

