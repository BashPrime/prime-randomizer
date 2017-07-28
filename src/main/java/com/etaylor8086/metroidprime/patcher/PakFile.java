package com.etaylor8086.metroidprime.patcher;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class PakFile {
	private String discPath;
	private String fileName;
	private int offset;
	private int namedResourceCount;
	private int resourceCount;
	private PakNamedResource[] pakNamedResources;
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
		// We don't care about the 8 byte header, skip it and go straight to 9th byte
		int currentOffset = 0x8;
		this.namedResourceCount = ByteBuffer.wrap(this.readGameDiscData(currentOffset, 4)).getInt();
		System.out.println("Named Resource count in " + this.fileName + ": " + this.namedResourceCount);
		currentOffset = this.readNamedResources(currentOffset += 4);
		this.resourceCount = ByteBuffer.wrap(this.readGameDiscData(currentOffset, 4)).getInt();
		System.out.println("Resource count in " + this.fileName + ": " + this.resourceCount);
		this.readResources(currentOffset += 4);
	}
	
	/**
	 * Reads in bytes to populate named resources array property.
	 * 
	 * @param startOffset
	 * @return Offset value (beginning of resourcesTable) after reading all named resources.
	 */
	public int readNamedResources(int startOffset) {
		int offset = startOffset;
		this.pakNamedResources = new PakNamedResource[this.namedResourceCount];
		
		for (int i = 0; i < this.namedResourceCount; i++) {
			this.pakNamedResources[i] = new PakNamedResource();
			this.pakNamedResources[i].fileType = new String(this.readGameDiscData(offset, 4));
			this.pakNamedResources[i].fileID = ByteBuffer.wrap(this.readGameDiscData(offset + 4, 4)).getInt();
			this.pakNamedResources[i].nameLength = ByteBuffer.wrap(this.readGameDiscData(offset + 8, 4)).getInt();
			this.pakNamedResources[i].name = new String(this.readGameDiscData(offset + 12, this.pakNamedResources[i].nameLength));
			offset += 0xC + this.pakNamedResources[i].nameLength;
//			System.out.println("---- " + this.fileName + ", fileType=" + this.pakNamedResources[i].fileType + ", fileID=" + this.pakNamedResources[i].fileID + ", NameLength=" + this.pakNamedResources[i].nameLength + ", Name=" + this.pakNamedResources[i].name);
		}
		
		return offset;
	}
	
	public void readResources(int startOffset) {
		int offset = startOffset;
		this.pakResources = new PakResource[this.resourceCount];
		
		for (int i = 0; i < this.resourceCount; i++) {
			this.pakResources[i] = new PakResource();
			this.pakResources[i].compressed = ByteBuffer.wrap(this.readGameDiscData(offset, 4)).getInt() == 1 ? true : false;
			this.pakResources[i].fourCC = new String(this.readGameDiscData(offset + 4, 4));
			this.pakResources[i].fileID = ByteBuffer.wrap(this.readGameDiscData(offset + 8, 4)).getInt();
			this.pakResources[i].size = ByteBuffer.wrap(this.readGameDiscData(offset + 12, 4)).getInt();
			this.pakResources[i].offset = ByteBuffer.wrap(this.readGameDiscData(offset + 16, 4)).getInt();
			offset += 0x14;
//			System.out.println("---- " + this.fileName + ", compressed=" + this.pakResources[i].compressed + ", fileType=" + this.pakResources[i].fourCC + ", fileID=" + this.pakResources[i].fileID + ", size=" + this.pakResources[i].size + ", offset=" + this.pakResources[i].offset);
		}
		
		
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
