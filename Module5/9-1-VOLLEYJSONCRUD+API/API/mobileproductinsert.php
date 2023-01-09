<?php

    include('connection.php');
    
    $name=$_POST["p_name"];
    $price=$_POST["p_price"];
    $description=$_POST["p_des"];
   
    
    if($name=="" && $price=="" && $description=="")
    {
        
        echo '0';
    }
    else
    {
        
        $sql="insert into mobileproducts(p_name,p_price,p_des) values('$name','$price','$description')";
        $ex=mysqli_query($con,$sql);
        mysqli_close($con);
        
    }
    

?>