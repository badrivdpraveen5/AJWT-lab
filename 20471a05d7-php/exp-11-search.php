<?php
$br   = $_POST['b'];
$link = mysqli_connect( "localhost", "root", "", "badripraveen" );
// Check connection 
if ( $link === false ) {
    die( "ERROR: Could not connect. " . mysqli_connect_error() );
}
// Attempt select query execution 
$sql = "SELECT * FROM students where branch='$br'"; 
if ( $result = mysqli_query( $link, $sql ) ) {
    if ( mysqli_num_rows( $result ) > 0 ) {
        echo "<table border=1>";
        echo "<tr>";
        echo "<th>Rno</th>";
        echo "<th>Name</th>";
        echo "<th>Branch</th>";
        echo "<th>Email</th>";
        echo "<th>Address</th>";
        echo "</tr>";
        while ( $row = mysqli_fetch_array( $result ) ) {
            echo "<tr>";
            echo "<td>" . $row['rno'] . "</td>";
            echo "<td>". $row['sname'] . "</td>";
            echo "<td>". $row['branch'] . "</td>";
            echo "<td>". $row['email'] . "</td>";
            echo "<td>". $row['address'] . "</td>";
            echo "</tr>";
        }
        echo "</table>";
        // Close result set 
        mysqli_free_result( $result );
    } else {
        echo "No records matching your query were found.";
    }
} else {
    echo "ERROR: Could not able to execute $sql. " . mysqli_error( $link );
}
mysqli_close( $link );
?>
