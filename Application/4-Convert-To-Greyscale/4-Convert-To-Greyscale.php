<?php


function convertToGreyscale($image){
	$image_ext = end(explode(".",strtolower($image)));
	if(file_exists($image) && ($image_ext=="jpg" || $image_ext=="png" || $image_ext=="bnp")){
	
		$im = ($image_ext=="jpg") ? imagecreatefromjpeg($image) : ($image_ext=="png"? imagecreatefrompng($image) : imagecreatefrombmp($image) );
		$size_x = imagesx($im);
		$size_y = imagesy($im);

	for ($y=0;$y<$size_y;$y++){
		for ($x=0;$x<$size_x;$x++){
			$rgb = imagecolorat($im,$x,$y);
			$r = ($rgb >> 16) & 0xFF; $g = ($rgb >> 8) & 0xFF; $b = $rgb & 0xFF; 
			$grey = (int)(($r+$g+$b)/3);		
			imagesetpixel($im,$x,$y,imagecolorallocate($im,$grey,$grey,$grey));
		}
	}

	header('Content-type: image/'.($image_ext=="jpg") ? 'jpeg' : ($image_ext=="png"? 'png' : 'bmp' ) );
	
	if($image_ext=="jpg")
		imagejpeg($im);
		elseif($image_ext=="png")
			imagepng($im);
				else imagebmp($im);
	
	}else echo "invalid input";	
}

	if(isset($argv[1]))
		convertToGreyscale($argv[1]);
	else echo "invalid input";
	//convertToGreyscale("C:\\Val-Thorens_pistemap_full.jpg");

?>