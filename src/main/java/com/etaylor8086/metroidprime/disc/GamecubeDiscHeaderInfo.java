package com.etaylor8086.metroidprime.disc;

import com.etaylor8086.metroidprime.io.BinarySerializable;
import com.etaylor8086.metroidprime.io.GamecubeDiscIO;

public class GamecubeDiscHeaderInfo extends BinarySerializable {
	public int debugMonitorSize = -1;
	public int simulatedMemorySize = -1;
	public int argOffset = -1;
	public int debugFlag = -1;
	public int trackLocation = -1;
	public int trackSize = -1;
	public int countryCode = -1;
	public int unknown = -1;
	
	public void read(GamecubeDiscIO gcio) {
		debugMonitorSize = gcio.readInt();
		simulatedMemorySize = gcio.readInt();
		debugFlag = gcio.readInt();
		trackLocation = gcio.readInt();
		trackSize = gcio.readInt();
		countryCode = gcio.readInt();
		unknown = gcio.readInt();
		gcio.readPaddingTo(0x2440);
	}
	
	public void write(GamecubeDiscIO gcio) {
		// Write class members to gcio here
	}
}
