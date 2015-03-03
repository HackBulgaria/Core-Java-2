<?php



function listDuplicatingFiles($dir=null){
	if(is_dir($dir)){
	$files = array();
	$all_files = list_files($dir);
	
	foreach($all_files as $file){
		$files[md5_file($file)] = $file;
	}
	

	foreach($files as $k=>$v){
		$files[$k] = end(explode(DIRECTORY_SEPARATOR,$v));	
	}
	
	echo "[ ".implode(", ",$files) . " ]";
	
	//return $files;
		//print_r(list_files($dir));
	}else echo "invalid dir";
}

//recursive function to list all files in specified $dir
function list_files($dir, $prefix = '') {
  if($prefix =='')$prefix = $dir;
  
  $dir = rtrim($dir, '\\/');
  $result = array();
  global $files;

    foreach (scandir($dir) as $f) {
      if ($f !== '.' and $f !== '..') {
        if (is_dir("$dir" . DIRECTORY_SEPARATOR . "$f")) {
          $result = array_merge($result, list_files("$dir" . DIRECTORY_SEPARATOR  . "$f", "$prefix$f".DIRECTORY_SEPARATOR ));
        } else {
          $result[] = $prefix.$f;
        }
      }
    }

  return $result;
}


	if(isset($argv[1]))
		listDuplicatingFiles($argv[1]);
	else echo "invalid input";



?>