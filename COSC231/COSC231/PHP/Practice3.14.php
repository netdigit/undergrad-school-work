<!DOCTYPE html>
<html>

<body>
<!-- #2A: Add 2 numbers -->

<h1>Adding Random Numbers</h1>
<p>This program uses PHP to generate 2 random numbers and add them.</p>

<?php
function sum(){
  $x = mt_rand(1, 10);
  $y = mt_rand(1, 10);
  $z = $x + $y;
  return "$x + $y = $z";
}
echo sum();
?>

<br><br>

<!-- #2B: Looping through an Array -->

<h1>Pick 5 Random Numbers</h1>
<p>5 random numbers between 1 and 75 will be generated. They will be displayed and 
added. A running sum will be displayed.</p>

<?php
$total = 0;
$allnum = array();
for($i = 0; $i < 5; $i++){
  $new = mt_rand(1, 75);
  echo "Random number generated: ".$new."<br>";
  $total = $total + $new;
  echo "Total so far: ".$total."<br>";
  array_push($allnum, $new);
}

echo "<br><br>Here's the final result:<br>";
for($i = 0; $i < count($allnum); $i++){
  
}
?>

</body>
</html>