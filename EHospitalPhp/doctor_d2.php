<?php

$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("select Doc_Name,Doc_ID,  doctor.Salary, Age, Degree_level, doctor.years_exp, Specialization, doctor.night_shift_start, doctor.Night_shift_end, patients_attended, doctor.phone_no, d_name, jun_name from ((doctor join department using (d_id)) left outer join jun_relation using(doc_id)) left outer join junior_doc using (jun_id) where doc_id = ?");
$st_check->bind_param("s", $_GET["doc_id"]);
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);
