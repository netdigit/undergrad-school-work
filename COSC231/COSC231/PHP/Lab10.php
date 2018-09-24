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

<!-- #2: COIN FLIP -->

<?php
echo "<h1>Coin Flip Simulator</h1>";
echo "<p>Enter a number and we'll flip a bunch of coins really really fast and tell 
you what the results were in a neat and fancy table.</p>";
?>

<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
<input type="number" placeholder="Pick a Number" name="num">
<input type="submit">
</form>

<?php

if($_SERVER["REQUEST_METHOD"] == "POST"){
  $num = $_REQUEST['num'];
  $coinArr = generateNums($num);
  echo "<br><br>";
  displayArray($coinArr);
}

function generateNums($a){
$tempArr = array();
  for($i = 0; $i < $a; $i++){
    $temp = mt_rand(0,1);
    if($temp == 0){
      $tempArr[$i] = "Heads";
    }
    else{
      $tempArr[$i] = "Tails";
    }
  }
  return $tempArr;
}

function displayArray($arr){
  echo "<table>";
  for($i = 0; $i < count($arr);){
    echo "<tr>";
    for($j = 0; $j < 10; $j++){
      echo "<td>".$arr[$i]."</td>";
      $i++;
      if($i == count($arr)){
        break;
      }
    }
    echo "</tr>";
  }
  echo "</table>";
}
?>


</body>
</html>