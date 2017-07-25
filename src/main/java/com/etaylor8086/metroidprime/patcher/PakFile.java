package com.etaylor8086.metroidprime.patcher;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class PakFile {
	private String discPath;
	private String fileName;
	private int offset;
	private int namedResourceCount;
	private int resourceCount;
	private PakNamedResource[] namedResources;
	private PakResource[] pakResources;
	
	public PakFile(String discPath, String fileName, int offset) {
		this.discPath = discPath;
		this.fileName = fileName;
		this.offset = offset;
		this.namedResourceCount = 0;
		this.resourceCount = 0;
		this.readFile();
	}
	
	public void readFile() {
		int currentOffset = 0x8;
		this.namedResourceCount = ByteBuffer.wrap(this.readGameDiscData(currentOffset, 4)).getInt();
		System.out.println("Resource count in " + this.fileName + ": " + this.namedResourceCount);
		this.readNamedResources(currentOffset += 4);
	}
	
	public int readNamedResources(int startOffset) {
		int bytesRead = 0;
		int offset = startOffset;
		this.namedResources = new PakNamedResource[this.namedResourceCount];
		
		for (int i = 0; i < this.namedResourceCount; i++) {
			this.namedResources[i] = new PakNamedResource();
			this.namedResources[i].fileType = new String(this.readGameDiscData(offset, 4));
			this.namedResources[i].fileID = ByteBuffer.wrap(this.readGameDiscData(offset += 4, 4)).getInt();
			this.namedResources[i].nameLength = ByteBuffer.wrap(this.readGameDiscData(offset += 4, 4)).getInt();
			this.namedResources[i].name = new String(this.readGameDiscData(offset += 4, this.namedResources[i].nameLength));
			offset += this.namedResources[i].nameLength;
			System.out.println("---- " + this.fileName + ", fileType=" + this.namedResources[i].fileType + ", fileID=" + this.namedResources[i].fileID + ", NameLength=" + this.namedResources[i].nameLength + ", Name=" + this.namedResources[i].name);
		}
		
		return bytesRead;
	}
	
	
	
	public byte[] readGameDiscData(int offset, int length) {
		byte[] discData = new byte[length];
		
		try (RandomAccessFile raf = new RandomAccessFile(this.discPath, "r")) {
			raf.seek(this.offset + offset);
            raf.read(discData, 0, length);
        }
        catch (Exception e) {
            System.err.println("Failed to read data from " + this.discPath + ": " + e);
            return null;
        }
		
		return discData;
	}
}
