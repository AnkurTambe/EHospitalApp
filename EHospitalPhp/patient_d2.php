<?php

$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("select  p_name, p_id, admission_status, patient.City, State,Age, no_of_tests_conducted, ongoing_medication, patient.phone_no, Gender, d_name,time_of_admission, test_type, previous_operations, Disability, previous_conditions, previous_disease, time_span_of_disease, previous_medication from (((patient natural left outer join test_report) natural left outer join medical_history_1) natural left outer join medical_history_2) join department using (d_id) where p_id =?;");
$st_check->bind_param("s", $_GET["p_id"]);
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);
