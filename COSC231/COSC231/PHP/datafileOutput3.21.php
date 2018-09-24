<!DOCTYPE html>
<html>
<body>

<?php
$myfile = fopen("datafile3.21.txt", "w") or die("Can't open file!");
$txt = "Hi\n";
fwrite($myfile, $txt);
$txt = "Bye\n";
fwrite($myfile, $txt);
fclose($myfile);
echo "Done. Check data file.";
?>

</body>
</html>