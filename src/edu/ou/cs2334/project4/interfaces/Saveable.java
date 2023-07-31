package edu.ou.cs2334.project4.interfaces;

import java.io.IOException;

/**
 * Specifies that a class has a special method for saving a file.
 * @author Grace Lee
 * @version 1.0
 */
public interface Saveable {
	void save(String filename) throws IOException;
}
