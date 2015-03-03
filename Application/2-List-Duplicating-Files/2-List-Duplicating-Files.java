/*
I wrote a Java program just to show you that I can.
The original solution is here: https://jakut.is/2013/08/06/a-java-program-to-list-all-duplicates-update/
To be less "memory hungry" I'm first comparing files by filesize, and if they equals, then I perform the memory consuming checksum creation.
If you have allowed to use libraries I would rather use: http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/digest/DigestUtils.html#md5Hex(java.io.InputStream)
OR: https://code.google.com/p/guava-libraries/
*/
package pkg2.list.duplicating.files2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author evlogimi
 */
class ValueComparator implements Comparator<String> {

    Map<String, Long> base;

    public ValueComparator(Map<String, Long> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    @Override
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}

public class ListDuplicatingFiles2 {

    private static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("cannot initialize MD5 hash function", e);
        }
    }

    public static void listDuplicatingFiles(String dir) throws NoSuchAlgorithmException, FileNotFoundException, Exception {
        Map<String, Long> allfiles = new HashMap<String, Long>();
        List<String> removefiles = new ArrayList<String>();
        ValueComparator bvc = new ValueComparator(allfiles);
        TreeMap<String, Long> sorted_allfiles = new TreeMap<String, Long>(bvc);
        allfiles = listDuplicatingFiles(dir, dir, allfiles);

        sorted_allfiles.putAll(allfiles);

        Boolean bgn = true;
        String previous = "";
        for (String key : sorted_allfiles.keySet()) {
            if (bgn) {
                bgn = false;
                previous = key;
            } else {

               //System.out.println("Current key: " + key + " value: " + sorted_allfiles.get(key) + " = " + makeHashLean(current_file));
                //System.out.println("Previous key: " + previous + " value: " + sorted_allfiles.get(previous) + " = " + makeHashLean(previous_file));
                if (sorted_allfiles.get(key) == sorted_allfiles.get(previous)) {
                    File previous_file = new File(previous);
                    File current_file = new File(key);
                    if (makeHashLean(previous_file).equals(makeHashLean(current_file))) {
                        //allfiles.remove(previous);
                        removefiles.add(previous);
                    }
                }

                previous = key;
                //System.out.println("key: " + key + " value: " + allfiles.get(key));
            }
        }

        //System.out.println(sorted_allfiles.toString());
        //System.out.println(allfiles.size());

        for (String temp : removefiles) {
            allfiles.remove(temp);
            //System.out.println(temp);
        }
        
        System.out.print("[");
        bgn = false;
        for (String key : allfiles.keySet()) {
            System.out.print((bgn?",":"")+"`"+key.substring(key.lastIndexOf("\\")+1)+"`");
            bgn = true;
        }
        System.out.println("]");
        //System.out.println(allfiles.toString());
        //System.out.println(allfiles.size());

    }

    public static Map<String, Long> listDuplicatingFiles(String dir, String prefix, Map<String, Long> allfiles) {
        File root = new File(dir);
        File[] list = root.listFiles();

        if (list == null) {
            return allfiles;
        }

        for (File f : list) {
            if (f.isDirectory()) {
                allfiles = listDuplicatingFiles(f.getAbsoluteFile().toString(), f.getAbsoluteFile().toString(), allfiles);
            } else {
                allfiles.put(f.getAbsoluteFile().toString(), f.length());
                //System.out.println( "File:" + f.getAbsoluteFile() );
            }
        }
        return allfiles;
    }

    public static String makeHashLean(File infile) throws Exception {
        RandomAccessFile file = new RandomAccessFile(infile, "r");

        int buffSize = 16384;
        byte[] buffer = new byte[buffSize];
        long read = 0;

        // calculate the hash of the whole file for the test
        long offset = file.length();
        int unitsize;
        while (read < offset) {
            unitsize = (int) (((offset - read) >= buffSize) ? buffSize
                    : (offset - read));
            file.read(buffer, 0, unitsize);
            md.update(buffer, 0, unitsize);
            read += unitsize;
        }

        file.close();
        String hash = new BigInteger(1, md.digest()).toString(16);
        return hash;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException, Exception {
        // TODO code application logic here

        listDuplicatingFiles("C:\\Core-Java-2");

    }

}
