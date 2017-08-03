package com.etaylor8086.metroidprime.disc;

import com.etaylor8086.metroidprime.io.BinarySerializable;
import com.etaylor8086.metroidprime.io.GamecubeDiscIO;

public class Apploader extends BinarySerializable {
	public String dateString = "";
	public int entryPoint = -1;
	public int size = -1;
	public int trailerSize = -1;
	public byte[] code = null;
	
	public void read(GamecubeDiscIO gcio) {
		dateString = gcio.readString();
		gcio.readPaddingTo(0x10);
		entryPoint = gcio.readInt();
		int codeSize = gcio.readInt();
		trailerSize = gcio.readInt();
		code = gcio.readBytes(codeSize);
	}
	
	public void write(GamecubeDiscIO gcio) {
		// Write class members to gcio here
	}
}
