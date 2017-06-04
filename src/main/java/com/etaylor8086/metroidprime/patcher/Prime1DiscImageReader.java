package com.etaylor8086.metroidprime.patcher;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class Prime1DiscImageReader {
	String fileName;
	Prime1FileHeader gameHeader;
	
	public Prime1DiscImageReader(String fileName) {
		this.gameHeader = new Prime1FileHeader();
		this.fileName = fileName;
		
		// Get ISO header information
		this.gameHeader.gameId = new String(this.readGameDiscData(0x00, 6));
		this.gameHeader.version = this.readGameDiscData(0x07, 1)[0];
		this.gameHeader.fstOffset = ByteBuffer.wrap(this.readGameDiscData(0x0424, 4)).getInt();
		this.gameHeader.fstSize = ByteBuffer.wrap(this.readGameDiscData(0x0428, 4)).getInt();
		this.gameHeader.fstMaxSize = ByteBuffer.wrap(this.readGameDiscData(0x042C, 4)).getInt();
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
}
