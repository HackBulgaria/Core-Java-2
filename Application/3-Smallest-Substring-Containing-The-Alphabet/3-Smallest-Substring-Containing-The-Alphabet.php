<?php

//Ignoring the notices
error_reporting(E_ERROR | E_WARNING | E_PARSE);

function smallestSubstringContainingTheAlphabet($s="",$t="abcdefghijklmnopqrstuvwxyz"){

	$slen = strlen($s);
	$tlen = strlen($t);
	
	if($s==null || $slen<$tlen) return "invalid input";

	
	$minWindowBegin=0;
	$minWindowLen=$slen;
	// prepare two arrays with zeros
	// hsf will be used for counts of chars in searched string t
	$hsf = $nfc = array_fill(0,256,0);
	$count = 0;

	
	// fill array with chars and their counts
	for($i=0;$i<$tlen;$i++){ $nfc[$t[$i]]++; }

		
		for($begin = 0,$end=0;$end<$slen;$end++){
			
			// skip characters not in searched string t
			if($nfc[$s[$end]] == 0){ continue; }
			$hsf[$s[$end]]++;
			
			if ($hsf[$s[$end]] <= $nfc[$s[$end]]){ $count++;}
			
			// if window constraint is satisfied
			if($count == $tlen){
			
		 	while($nfc[$s[$begin]] == 0 || 
				  $hsf[$s[$begin]] > $nfc[$s[$begin]]){
				if($hsf[$s[$begin]] > $nfc[$s[$begin]]){$hsf[$s[$begin]]--;}
					$begin++;
			}
			
				$windowLen = $end - $begin + 1;
				if($windowLen < $minWindowLen){			
					$minWindowBegin = $begin;
					$minWindowLen = $windowLen;
				}

			}
		}
	
	
	if($count == $tlen){
		if($minWindowLen == $slen) return "[$s]";
		else{
			return 	substr($s, 0, $minWindowBegin) . "[" . 
					substr($s, $minWindowBegin, $minWindowLen) . "]" .
					substr($s, $minWindowBegin + $minWindowLen, $slen);
		}
	}
	
	return "invalid input";
}

$tests = "aaaaaabcdefghijklmnopqrstuvwxyz
abcdefghijklmnopqrstuvwxyz
bcdefghijklmnopqrstuvwxyz
aaaaaabcdefghijklmnopqrstuvwxyzhjlkera345hrejaf
abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn
abcdeasfghijklmn124345678!@#$%^&*opqrstsdfuvwxyz!*abcdefdsafghijklmn
32q45hkjhaqkjhq345h'ljslkvcasd0af7asdfohj43h5;lashfdlasdhfa;sdfh92hq4prabcdefghijklfgdhmnopqrsasdftuvwxfadsyz
abcdefghijklmnopqrstuvwxyzj53k4l;earjf;dsk;lkj354q;laejfsd;lkj;254rwe;fd\shl;";


// Test the method
foreach(explode("\n",$tests) as $test){

	echo smallestSubstringContainingTheAlphabet($test) . PHP_EOL;

}

?>