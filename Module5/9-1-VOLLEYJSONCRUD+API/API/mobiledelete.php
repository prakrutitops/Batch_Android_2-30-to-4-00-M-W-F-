<?php
 include('connection.php');
 
 $ID = $_POST['id'];

$Sql_Query = "DELETE FROM mobileproducts WHERE id = '$ID'";

 if(mysqli_query($con,$Sql_Query))
{
 echo 'Record Deleted Successfully';
}
else
{
 echo 'Something went wrong';
 }
 
 mysqli_close($con);
?>