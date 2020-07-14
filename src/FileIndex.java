/**
 * %java FileIndex.java  ex1.txt ex2.txt ex3.txt ex4.txt
 * Indexing files
 *  ex1.txt
 *  ex2.txt
 *  ex3.txt
 *  ex4.txt
 * Done indexing
 * age
 *  ex3.txt
 *  ex4.txt
 * was
 *  ex1.txt
 *  ex2.txt
 *  ex3.txt
 *  ex4.txt
 *  */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**Goal. Given a list of files specified, create an index so that you can
 efficiently find all files containing a given query string.

 Solution. Key = query string; value = set of files containing that string.
 */
public class FileIndex {

    public static void main(String[] args) {
	// create ST
    Map<String, Set<File>> st = new TreeMap<>();

    // create inverted index of all files
    StdOut.println("Indexing files");
    //list of file names from command line
    for (String filename : args) {
        StdOut.println(" " +filename); // print filename
        File file = new File(filename);
        In in = new In(file); // чтение файла
        //for each word in file,
        //add file to
        //corresponding set
        while (!in.isEmpty()) {
            String word = in.readString();
                if (!st.containsKey(word)) st.put(word, new TreeSet<>());
            st.get(word).add(file);
        }
    }

        StdOut.println("Done indexing");

    // read queries from standard input, one per line
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.containsKey(query))
                for (File k : st.get(query))
                    StdOut.println(" " +k.getName());
        }
    }
}
