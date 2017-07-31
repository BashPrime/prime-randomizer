package com.etaylor8086.metroidprime.patcher;

public class PakResource {
	private int entrySize = 0x14;
	public boolean compressed;
	public String fileType;
	public String fileID;
	public int size;
	public int offset;
	
	public PakResource() {
		this.compressed = false;
		this.fileType = "";
		this.fileID = "";
		this.size = 0;
		this.offset = 0;
	}
}
