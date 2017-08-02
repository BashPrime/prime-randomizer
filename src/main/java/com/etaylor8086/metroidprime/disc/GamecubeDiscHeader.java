package com.etaylor8086.metroidprime.disc;

import com.etaylor8086.metroidprime.io.BinarySerializable;
import com.etaylor8086.metroidprime.io.GamecubeDiscIO;

public class GamecubeDiscHeader extends BinarySerializable {
	private int magicNumber = 0xC2339F3D;
	public int gameCode = -1;
	public short makerCode = -1;
	public byte discID = -1;
	public byte version = -1;
	public byte audioStreaming = -1;
	public byte streamBufferSize = -1;
	public int dvdMagicWord = -1;
	public String gameName = "";
	public int debugMonitorOffset = -1;
	public int debugMonitorAddr = -1;
	public int bootDolOffset = -1;
	public int fstOffset = -1;
	public int fstSize = -1;
	public int fstMaxSize = -1;
	public int userPos = -1;
	public int userLen = -1;
	public int unknown = -1;
	
	public void read(GamecubeDiscIO gcio) {
		this.gameCode = gcio.readInt();
		this.makerCode = gcio.readShort();
		this.discID = gcio.readByte();
		this.version = gcio.readByte();
		this.audioStreaming = gcio.readByte();
		this.streamBufferSize = gcio.readByte();
		gcio.readBytes(0x12); // Read unused zeroes 0x12 long
		this.magicNumber = gcio.readInt();
		this.gameName = gcio.readString();
		// Seek to 0x400
		this.debugMonitorAddr = gcio.readInt();
		this.debugMonitorOffset = gcio.readInt();
		gcio.readBytes(0x18); // Read unused zeroes 0x18 long
		this.bootDolOffset = gcio.readInt();
		this.fstOffset = gcio.readInt();
		this.fstSize = gcio.readInt();
		this.fstMaxSize = gcio.readInt();
		this.userPos = gcio.readInt();
		this.userLen = gcio.readInt();
		this.unknown = gcio.readInt();
		gcio.readBytes(0x04); // Read unused zeroes 0x04 long
	}
	
	public void write(GamecubeDiscIO gcio) {
		// Write class members to gcio here
	}
}
