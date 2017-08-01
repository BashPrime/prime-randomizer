package com.etaylor8086.metroidprime.patcher;

public class GamecubeDiscHeader {
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
}
