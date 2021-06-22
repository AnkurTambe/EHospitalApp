<?php

$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("select tech_Name, qualifications, tech_ID from `lab_tech` ORDER BY `lab_tech`.`tech_ID` ASC");
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);

