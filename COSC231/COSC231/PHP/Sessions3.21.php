<?php
session_start();
?>
<!DOCTYPE html>
<html>
<body>

<h1>Adder Program</h1>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
<!--<form method="post" action="ex8a_form.php">
	The above opens and runs a separate php file.-->
  First Number: <input type="text" name="num1"><br>
  Second Number: <input type="text" name="num2"><br>
  
  <input type="submit">
</form>

<!--<input type="submit" action="<?php session_unset(); session_destroy();?>">-->

<?php
if($_SERVER["REQUEST_METHOD"] == "POST"){
  //collect input field values
  $num1 = $_REQUEST['num1'];
  $num2 = $_REQUEST['num2'];
  if(empty($num1)||empty($num2)){
    echo "I need both numbers to add them.";
  }
  else{
    echo "<p>$num1 plus $num2 = ".($num1+$num2)."</p>";
    $_SESSION['total'] += $_SESSION['total'] + $num1 + $num2;
    echo "Running total: ".$_SESSION['total'];
    #The session variables don't work for WHATEVER REASON
  }
}
?>

</body>
</html>