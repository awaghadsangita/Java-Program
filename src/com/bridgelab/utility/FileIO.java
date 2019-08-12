/******************************************************************************************************************************
 * @purpose	:contain methods for reading and writing various type of files
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:08-08-2019
 ******************************************************************************************************************************/
package com.bridgelab.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	public static void writeToJsonFile(File file,String jsonString) throws IOException
	{
		FileWriter filewriter=new FileWriter(file);
		BufferedWriter bufferedwriter=new BufferedWriter(filewriter);
		bufferedwriter.write("["+jsonString+"]");
		bufferedwriter.close();
	}

}
