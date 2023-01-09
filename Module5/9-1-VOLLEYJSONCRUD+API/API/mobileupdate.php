<?php
 include('connection.php');
 
 $ID = $_POST['id'];
 $NAME = $_POST['p_name'];
 $PRICE = $_POST['p_price'];
 $DESCRIPTION = $_POST['p_des'];

$Sql_Query = "UPDATE mobileproducts SET p_name='$NAME' ,p_price='$PRICE',p_des='$DESCRIPTION' WHERE id = '$ID'";
//echo $Sql_Query;
 if(mysqli_query($con,$Sql_Query))
{
 echo 'Record Updated Successfully';
}
else
{
 echo 'Something went wrong';
 }
 
 mysqli_close($con);
?>