<?php
$link = mysqli_connect( "localhost", "root", "", "badripraveen" );
// Check connection 
if ( $link === false ) {
    die( "ERROR: Could not connect. " . mysqli_connect_error() );
}
// Attempt select query execution 
$sql = "SELECT * FROM books";
if ( $result = mysqli_query( $link, $sql ) ) {
    if ( mysqli_num_rows( $result ) > 0 ) {
        echo "<table border=1>";
        echo "<tr>";
        echo "<th>Bookid</th>";
        echo "<th>Bookname</th>";
        echo "<th>Author</th>";
        echo "<th>Publication</th>";
        echo "</tr>";
        while ( $row = mysqli_fetch_array( $result ) ) {
            echo "<tr>";
            echo "<td>" . $row['bookid'] . "</td>";
            echo "<td>" . $row['bookname'] . "</td>";
            echo "<td>" . $row['author'] . "</td>";
            echo "<td>" . $row['publication'] . "</td>";
            echo "</tr>";
        }
        echo "</table>";
        mysqli_free_result( $result );
    } else {
        echo "No records matching your query were found.";
    }
} else {
    echo "ERROR: Could not able to execute $sql. " . mysqli_error( $link );
}
mysqli_close( $link );
?>
