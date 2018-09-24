<!DOCTYPE html>
<html>
<body>

<?php
$x = 4;
echo "out of function: $x<br>";

function showX(){
  $x = 5;
  echo "in function: ".$x."<br>";
  $x+=5;
  echo "in function: ".$x."<br>";
}

showX();
showX();
showX();
echo "out of function: $x<br>";

?>

<h1>Adder Program</h1>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
<!--<form method="post" action="ex8a_form.php">
	The above opens and runs a separate php file.-->
  First Number: <input type="text" name="num1"><br>
  Second Number: <input type="text" name="num2"><br>
  
  <input type="submit">
</form>

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
  }
}
?>

</body>
</html>