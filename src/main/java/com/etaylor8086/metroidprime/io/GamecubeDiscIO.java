package com.etaylor8086.metroidprime.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class GamecubeDiscIO {
	private long pos = 0;
	private RandomAccessFile inFile = null;
	private RandomAccessFile outFile = null;
	
	public GamecubeDiscIO(RandomAccessFile inFile, RandomAccessFile outFile) {
		this.inFile = inFile;
		this.outFile = outFile;
	}
	
	public Byte readByte() {
		this.pos += Byte.BYTES;
		Byte inData = null;
		try {
			inData = this.inFile.readByte();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inData;
	}
	
	public Short readShort() {
		this.pos += Short.BYTES;
		Short inData = null;
		try {
			inData = this.inFile.readShort();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inData;
	}
	
	public Integer readInt() {
		this.pos += Integer.BYTES;
		Integer inData = null;
		try {
			inData = this.inFile.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inData;
	}
}
