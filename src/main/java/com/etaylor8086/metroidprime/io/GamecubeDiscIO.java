package com.etaylor8086.metroidprime.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

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
	
	public void writeByte(Byte outData) {
		this.pos += Byte.BYTES;
		try {
			this.outFile.writeByte(outData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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
	
	public void writeShort(Short outData) {
		this.pos += Short.BYTES;
		try {
			this.outFile.writeShort(outData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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
	
	public void writeInt(Integer outData) {
		this.pos += Integer.BYTES;
		try {
			this.outFile.writeInt(outData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public byte[] readBytes(int numBytes) {
		byte[] bytes = new byte[numBytes];
		this.pos += numBytes;
		try {
			this.inFile.readFully(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bytes;
	}
	
	public void writeBytes(byte[] bytes) {
		this.pos += bytes.length;
		try {
			this.outFile.write(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readString() {
		String res = null;
		byte[] buffer = new byte[512];
		int size = 0;
		try {
			for (int i = 0; i < buffer.length; i++) {
				byte readByte = this.readByte();
				if (readByte == 0)
					res = new String(buffer, 0, size, "UTF-8");
				else {
					buffer[i] = readByte;
					size++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public <T extends BinarySerializable> T read(T i) {
		i.read(this);
		return i;
	}
	
	public <T extends BinarySerializable> void write(T i) {
		i.write(this);
	}
}
