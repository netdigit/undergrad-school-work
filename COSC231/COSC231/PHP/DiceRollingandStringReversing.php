<!DOCTYPE html>
<html>
<body>
<!-- NUMBER WORDS -->
<?php
echo "<h2 style='text-decoration: underline;'>Random Number Speller </h2>";
echo  "<p> Program to generate 5 numbers and tells you how to spell them </p>";
$names = array("one", "two", "three", "four", "five", "six", "seven", "eight","nine", "ten");

$numbers = array();

function generate(){
 // $numbers.push(mt_rand(1, 10));
 return mt_rand(1,10);
}

echo "<p>This is how you spell stuff:<br>";

for($i = 0; $i < 5; $i++){
  //echo "hi";
  $numbers[$i] = generate();
  //echo "bye";
  echo "Number ".$numbers[$i]." is spelled ".$names[$numbers[$i]-1].".<br>";
}

//echo var_dump($numbers);
//echo var_dump($names);

echo "The more you know.</p>";
echo "<br><br><br>"
?>

<!-- STRING REVERSING -->

<?php
echo "<h2 style='text-decoration: underline;'>String Reverser</h2>";
echo  "<p> Program to print out and display the reverse of words and phrases </p>";
$strings = array("Hello", "Goodbye", "Thanks", "Hello World", "Javascript is better");
$test = "hello";

for($i = 0; $i < 5; $i++){
	echo $strings[$i]." -> ".strrev($strings[$i])."<br>";
}


?>

</body>
</html>