package com.etaylor8086.metroidprime.util;

import java.io.RandomAccessFile;

public class FileUtilities {
	private static String fileName;
	
	public static byte[] readGameDiscData(int offset, int length) {
		byte[] discData = new byte[length];
		
		try (RandomAccessFile raf = new RandomAccessFile(FileUtilities.fileName, "r")) {
			raf.seek(offset);
            raf.read(discData, 0, length);
        }
        catch (Exception e) {
            System.err.println("Failed to read data from " + FileUtilities.fileName + ": " + e);
            return null;
        }
		
		return discData;
	}
	
	public static void setFileName(String fileName) {
		FileUtilities.fileName = fileName;
	}
	
	public static int getIntFromHexString(String hexStr) {
		return (int) Long.parseLong(hexStr, 16);
	}
}
