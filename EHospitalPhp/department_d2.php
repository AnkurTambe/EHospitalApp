<?php

$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("select d_name,d_id, no_of_rooms, no_of_halls, no_of_consultancy_rooms, no_of_beds, beds_occupied, patient_discharge_average, patient_admissionrate_average from department where d_id =?");
$st_check->bind_param("s", $_GET["d_id"]);
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);
