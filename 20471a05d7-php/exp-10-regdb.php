<?php
$uname  = $_POST['u1'];
$pass   = $_POST['p1'];
$email  = $_POST['e1'];
$mobile = $_POST['m1'];
$sql    = "insert into registers values('$uname','$pass','$email','$mobile')";
$link   = mysqli_connect("localhost", "root", "", "badripraveen");
// Check connection 
if ($link === false) {
    die("ERROR: Could not connect. " . mysqli_connect_error());
}
if (mysqli_query($link, $sql)) {
    if (mysqli_affected_rows($link) != 0) {
        echo "data registered successfully";
    } else {
        echo "Data cannot be inserted" . mysqli_error($link);
    }
} else {
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
}
mysqli_close($link);
?> 
