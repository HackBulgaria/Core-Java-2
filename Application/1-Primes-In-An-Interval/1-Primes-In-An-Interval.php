<?php



function primesInAnInterval($from=0,$to=0){

	if($to>$from && $from >= 2){

  $number = 2;
  $range = range(2, $to);
  $primes = array_combine($range, $range);

  while ($number*$number < $to) {
    for ($i = $number; $i <= $to; $i += $number) {
      if ($i == $number) {
        continue;
      }
      unset($primes[$i]);
    }
    $number = next($primes);
  }

  foreach ($primes as $prime) {
    if ($prime < $from) {
      unset($primes[$prime]);
    } else {
      break;
    }
  }
	
		echo "[ ". implode(", ",$primes) ." ]";

	}else echo "invalid input";
}

	if(isset($argv[2]))
		primesInAnInterval($argv[1],$argv[2]);
	else echo "invalid input";
?>

