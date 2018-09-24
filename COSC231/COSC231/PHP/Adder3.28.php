<?php
  session_start();
?>

<!DOCTYPE html>
<html>
<!-- Kelly Mayhew, March 28, 2017. Copied directly from today's notes. -->

<body>

<!--<form method="post" name="adderForm" id="adderForm" action="ex9b_SESSION.php">
The above doesn't work because I don't have a ex9b_SESSION.php file.-->
<form method="post" name="adderForm" id="adderForm" 
		action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
  First Number: <input type="text" name="num1"><br>
  Second Number: <input type="text" name="num2"><br>
  
  <input type="submit" value="SEND" name="submit"><br>
  <input type="submit" value="reset" name="reset">
</form>

<?php
  if($_SERVER["REQUEST_METHOD"] == "POST"){ //Detects an event. Is form using POST method?
  
    if($_POST['submit']=="SEND"){ //Is the event the clicking of the submit button?
      //collect value of input field
      $num1 = $_REQUEST['num1'];
      $num2 = $_REQUEST['num2'];
    
      if(empty($num1)||empty($num2)){ //Did the user enter both numbers?
        //Note: a value of 0 counts as empty!
        //Alternatively, you could try !isset($num1) instead of empty($num1)
        echo "I need both numbers to add them!";
      }
      else{ //Both numbers entered. Display the sum:
        $_SESSION['total'] += $num1+$num2;
        echo "<p>$num1 plus $num2 = ".($num1+$num2)."</p>";
        echo "Added to the running total is = ".$_SESSION['total'];
      }
      
    }
    else{ //It wasn't the submit button; it must be the other one!
      $_SESSION['total']=0;
      echo "<p>Total has been set to zero.</p>";
    }
    
  }
?>

</body>
</html>