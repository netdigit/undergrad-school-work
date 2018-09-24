<?php
session_start();
?>

<!DOCTYPE html>
<!-- ex9a_SESSION.php -->
<html>
<body>


<?php

if (!isset($_SESSION['count'])|| !isset($_SESSION['total'])){
$_SESSION['count'] = 0;
$_SESSION['total'] = 0;
} else {
$_SESSION['count']++;
}

echo "<h1> Adder Program:</h1>";
echo "<p>This program will keep adding up your numbers until you KILL the program!</p>";
echo "<form method='get' name='adderForm' id='adderForm' action='ex9a_SESSION.php'>
<input type='hidden' id='kill' name='kill' value='NO'>
First Number: <input type='text' name='num1'><br />
Second Number: <input type='text' name='num2'>

<input type='submit' value='SEND'><br />
<input type='button' value='KILL' name='killProgram' 
onclick=\"alert(1);alert(document.getElementById('kill'));
document.getElementById('kill').value='YES';
alert(2);document.getElementById('adderForm').submit();\">
</form>" ;


if (isset($_REQUEST["kill"]) && ($_REQUEST["kill"] == "YES")) {
$_SESSION['total']=0;
echo "<p>$num1 plus $num2 = ".($num1+$num2)."</p>";
echo "Added to the running total is = ".$_SESSION['total'];
echo "you'r done";
}
else {
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

<!--
1. Tell server to keep data on this form for the session
At top of document, include:
<?php
session_start();
?>

2. Set a counter for the session.
IF you ever need it, the counter can now tell if it is the start of a session 
or if it is a continuing session.
In this case, we will also set a running sum (and check if it "isset")

if (!isset($_SESSION['count'])|| !isset($_SESSION['total'])){
$_SESSION['count'] = 0;
$_SESSION['total'] = 0;
} else {
$_SESSION['count']++;
}
}

3. echo the form (careful to include single quotes inside)

4. Do your checks

Note: It will automatically repeat this code until the window closes (Probably
even until the browser closes! It could last as long as 24 minutes!)

-->