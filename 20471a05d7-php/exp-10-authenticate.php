<html>
   <body bgcolor="lightblue">
      <center>
      <?php 
         $uname = $_POST['u1']; 
         $pass = $_POST['p1']; 
         $sql = "SELECT * FROM registers WHERE uname='$uname' and      pass='$pass'"; 
         $link = mysqli_connect("localhost", "root", "", "badripraveen"); 
         if ($link === false) { 
         die("error couldnot connect" . mysqli_connect_error()); 
         } 
         if (mysqli_query($link, $sql)) { 
         if (mysqli_affected_rows($link) != 0) { 
         echo mysqli_affected_rows($link) . "successfully loged in found"; 
         //while($out=mysqli_fetch_array($result)) 
         //{ 
         //echo  "<tr><td>".$out['uname']."</td><td>".$out['pass']."</td><td>".$out['email']."</td><td>".$out['mobile']."</td></tr>"; 
         //} 
         } else { 
         echo "Username and Password was not matched" . mysqli_error($link); 
         } 
         } 
         mysqli_close($link); 
         ?>
