<?php
$con = new mysqli("localhost", "root", "", "ehospitaldb");
$st_check = $con->prepare("select * from doctor where phone_no=? and pass=?");
$st_check->bind_param("ss", $_GET["phone_no"], $_GET["pass"]);
$st_check->execute();
$rs = $st_check->get_result();
if ($rs->num_rows == 0)
    echo "0";
else
    echo "1";

