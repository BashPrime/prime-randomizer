package com.etaylor8086.metroidprime.patcher;

public class PakNamedResource {
	private int minEntrySize = 0xC;
	private int entrySize;
	public String fileType;
	public int fileID;
	public int nameLength;
	public String name;
	
	public PakNamedResource() {
		this.fileType = "";
		this.fileID = 0;
		this.nameLength = 0;
		this.name = "";
	}
}
