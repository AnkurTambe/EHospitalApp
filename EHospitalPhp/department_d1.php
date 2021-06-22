<?php

$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("SELECT d_name, no_of_rooms, d_id FROM `department` ORDER BY `department`.`d_id` ASC");
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);

