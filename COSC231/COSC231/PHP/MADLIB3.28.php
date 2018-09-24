<?php
  session_start();
?>

<!DOCTYPE html>
<html>
<!-- Kelly Mayhew, March 28, 2017. Today's notes used as a template. -->
<head>
  <meta charset="utf-8" />
  <title>I done did do it!</title>
</head>

<body>
<h1>MAD LIBS</h1>

<form method="post" name="madLib" id="madLib" 
		action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
  Noun: <input type="text" name="noun1"><br>
  -ing Verb: <input type="text" name="verb1"><br>
  Object: <input type="text" name="obj1"><br>
  Noun: <input type="text" name="noun2"><br>
  Past Tense Verb: <input type="text" name="verb2"><br>
  
  <input type="submit" value="SEND" name="submit"><br>
  <input type="submit" value="reset" name="reset">
</form>

<?php
  if($_SERVER["REQUEST_METHOD"] == "POST"){ //Detects an event. Is form using POST method?
  
    if($_POST['submit']=="SEND"){ //Is the event the clicking of the submit button?
      //collect value of input field
      $n1 = $_REQUEST['noun1'];
      $v1 = $_REQUEST['verb1'];
      $o1 = $_REQUEST['obj1'];
      $n2 = $_REQUEST['noun2'];
      $v2 = $_REQUEST['verb2'];
    
      if(empty($n1)||empty($v1)||empty($o1)||empty($n2)||empty($v2)){ //Did the user enter everything?
        echo "Please fill every box!";
      }
      else{ //Everything entered right. Display results:
        $sentence = "$n1 went $v1 out $o1, but $n2 just $v2.";
        $_SESSION['total'] .= " ".$sentence; //.= for string concatenation
        echo "<p>Current sentence: ".$sentence."</p>";
        echo "Current story: ".$_SESSION['total'];
      }
      
    }
    else{ //It wasn't the submit button; it must be the other one!
      session_unset();
      echo "<p>Your story has been erased. :(</p>";
    }
    
  }
?>

</body>
</html>