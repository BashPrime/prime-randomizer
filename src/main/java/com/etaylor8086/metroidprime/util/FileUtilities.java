package com.etaylor8086.metroidprime.util;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

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
	
	public static byte[] readFileName(int offset) {
		List<Byte> byteList = new ArrayList<Byte>();
		
		try (RandomAccessFile raf = new RandomAccessFile(FileUtilities.fileName, "r")) {
			raf.seek(offset);
			while (true) {
				byte newByte = raf.readByte();
				if (newByte != 0)
					byteList.add(newByte);
				else
					break;
			}
			byte[] bytes = new byte[byteList.size()];
			
			for (int i = 0; i < bytes.length; i++) {
				bytes[i] = byteList.get(i);
			}
			
			return bytes;
        }
        catch (Exception e) {
            System.err.println("Failed to read data from " + FileUtilities.fileName + ": " + e);
            return null;
        }
	}
	
	public static Integer convertOddByteArrToInt(byte[] byteArr) {
		if (byteArr.length <= 3) {
			byte[] newByteArr = new byte[4];
			
			for (int i = 0; i < byteArr.length; i++) {
				newByteArr[newByteArr.length - 1 - i] = byteArr[byteArr.length - 1 - i];
			}
			
			return ByteBuffer.wrap(newByteArr).getInt();
		}
		
		return null;
	}
	
	public static void setFileName(String fileName) {
		FileUtilities.fileName = fileName;
	}
	
	public static int getIntFromHexString(String hexStr) {
		return (int) Long.parseLong(hexStr, 16);
	}
}
