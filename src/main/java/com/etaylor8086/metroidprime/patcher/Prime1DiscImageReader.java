package com.etaylor8086.metroidprime.patcher;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class Prime1DiscImageReader extends GamecubeDiscImageReader {
	String fileName;
	Prime1FileHeader gameHeader;
	
	public Prime1DiscImageReader(String fileName) {
		this.gameHeader = new Prime1FileHeader();
		this.fileName = fileName;
		
		// Get ISO header information
		this.gameHeader.gameId = new String(this.readGameDiscData(this.GAMEID_OFFSET, 6));
		this.gameHeader.version = this.readGameDiscData(this.GAME_VERSION_OFFSET, 1)[0];
		this.gameHeader.fstOffset = ByteBuffer.wrap(this.readGameDiscData(this.FST_OFFSET_OFFSET, 4)).getInt();
		this.gameHeader.fstSize = ByteBuffer.wrap(this.readGameDiscData(this.FST_SIZE_OFFSET, 4)).getInt();
		this.gameHeader.fstMaxSize = ByteBuffer.wrap(this.readGameDiscData(this.FST_MAXSIZE_OFFSET, 4)).getInt();
		
		System.out.println("FST Offset: " + this.gameHeader.fstOffset);
		System.out.println("FST Size: " + this.gameHeader.fstSize);
		System.out.println("FST MaxSize: " + this.gameHeader.fstMaxSize);
		int i = 0;
		int numEntries = ByteBuffer.wrap(this.readGameDiscData(this.gameHeader.fstOffset + 8, 4)).getInt();
		int stringTableOffset = this.gameHeader.fstOffset + (numEntries * 12);
		System.out.println("String table offset: " + stringTableOffset);
		System.out.println(new String(this.readGameDiscData(stringTableOffset, 6)));
		while (i < numEntries) {
			int fileFlag = this.readGameDiscData(this.gameHeader.fstOffset + (i * 12), 1)[0];
			byte[] fileNameOffsetArr = this.readGameDiscData(this.gameHeader.fstOffset + 1 + (i * 12),  3);
			long fileNameOffset = fileNameOffsetArr[0] + fileNameOffsetArr[1] + fileNameOffsetArr[2];
			int newFileNameOffset = this.convertOddByteArrToInt(fileNameOffsetArr);
			int fileOffset = ByteBuffer.wrap(this.readGameDiscData(this.gameHeader.fstOffset + 4 + (i * 12), 4)).getInt();
			int lastFileInt = ByteBuffer.wrap(this.readGameDiscData(this.gameHeader.fstOffset + 8 + (i * 12), 4)).getInt();
			System.out.println(i + " - Flag: " + fileFlag + ", FileNameOffset: (" + newFileNameOffset + ") " + (stringTableOffset + newFileNameOffset) + ", FileOffset: " + fileOffset + ", Other thing: " + lastFileInt);
			i += 1;
		}
	}
	
	public byte[] readGameDiscData(int offset, int length) {
		byte[] discData = new byte[length];
		
		try (RandomAccessFile raf = new RandomAccessFile(this.fileName, "r")) {
			raf.skipBytes(offset);
            raf.read(discData, 0, length);
        }
        catch (Exception e) {
            System.err.println("Failed to read data from " + this.fileName + ": " + e);
            return null;
        }
		
		return discData;
	}
	
	public Integer convertOddByteArrToInt(byte[] byteArr) {
		if (byteArr.length <= 3) {
			byte[] newByteArr = new byte[4];
			
			for (int i = 0; i < byteArr.length; i++) {
				newByteArr[newByteArr.length - 1 - i] = byteArr[byteArr.length - 1 - i];
			}
			
			return ByteBuffer.wrap(newByteArr).getInt();
		}
		
		return null;
	}
}
