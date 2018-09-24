<?php
session_start();
?>

<!DOCTYPE html>
<!-- ex9a_Adder.php -->
<html>
<body>
  <h1> Adder Program:</h1>
  <p>This program will keep adding up your numbers until you KILL the program!</p>

  <form method="post" name="adderForm" id="adderForm" action="ex9a_Adder.php">
    First Number: <input type="text" name="num1"><br />
    Second Number: <input type="text" name="num2">

    <input type="submit" value="SEND" name="submit" ><br />

  </form>

<?php


if ($_SERVER["REQUEST_METHOD"] == "POST") {

    // collect value of input field
    $num1 = $_REQUEST['num1']; 
    $num2 = $_REQUEST['num2'];
    if (empty($num1)||empty($num2)) {
         echo "I need both numbers to add them";
   } else {
         $_SESSION['total'] += $num1+$num2;
         echo "<p>$num1 plus $num2 = ".($num1+$num2)."</p>";
         echo "Added to the running total is = ".$_SESSION['total'];
   }
}


?>

</body>
</html>

<!--Change it to MAD LIBS and include a reset button!

 

 

 

Just in case you need to do a little error checking, I added pop up windows (alert boxes)
 here in this example: SEE ex9a_SESSIONS.php-->
