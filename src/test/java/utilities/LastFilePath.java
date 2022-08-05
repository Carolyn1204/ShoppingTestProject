package utilities;

import java.io.File;

public class LastFilePath {

	public static String getLastFilePath(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[files.length-1];

	    return lastModifiedFile.getPath();
	}


}
