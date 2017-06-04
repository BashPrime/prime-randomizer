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
