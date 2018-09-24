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