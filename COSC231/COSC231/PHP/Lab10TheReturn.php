<!DOCTYPE html>
<html>

<!--
Written by Jacob Bray and Kelly Mayhew for Project 10 on 3/23/2017.
-->

<head>
  <meta charset="utf-8" />
  <style>
    table{
      border: 2px solid black;
      border-collapse: collapse;
    }
    td{
      border: 1px solid black;
      padding: 5px;
    }
  </style>
</head>

<body>

<!-- #11: VOWEL COUNTER -->

<?php
echo "<h1>Vowel Counter</h1>";
echo "<p>Enter 5 words or phrases and we'll count the number of vowels in each of them for you, for free.</p>";
?>

<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
<input type="text" placeholder="Phrase 1" name="phrase1"><br>
<input type="text" placeholder="Phrase 2" name="phrase2"><br>
<input type="text" placeholder="Phrase 3" name="phrase3"><br>
<input type="text" placeholder="Phrase 4" name="phrase4"><br>
<input type="text" placeholder="Phrase 5" name="phrase5"><br>
<input type="submit">
</form>

<?php

if($_SERVER["REQUEST_METHOD"] == "POST"){
  $num = $_REQUEST['num'];
  $phrases = array($_REQUEST['phrase1'], $_REQUEST['phrase2'], $_REQUEST['phrase3'], $_REQUEST['phrase4'],
  $_REQUEST['phrase5']);
  echo "<br><br>";
 # var_dump($phrases);
  
  for($i = 0; $i < count($phrases); $i++){
	$tempArr = str_split($phrases[$i]);
	$total = 0;
		for($j = 0; $j < count($tempArr); $j++){
			switch(strtoupper($tempArr[$j])){
				case 'A':
					$total++;
					break;
				case 'E':
					$total++;
					break;
				case 'I':
					$total++;
					break;
				case 'O':
					$total++;
					break;
				case 'U':
					$total++;
					break;
			}
			
		}   
		echo $phrases[$i]." has $total vowels <br>";
  
  }
  
 
}




?>


</body>
</html>