package edu.ou.cs2334.project4.interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Specifies that a class has a special method for opening a file.
 * @author Grace Lee
 * @version 1.0
 */
public interface Openable {
	void open (File file) throws FileNotFoundException, IOException;
}
