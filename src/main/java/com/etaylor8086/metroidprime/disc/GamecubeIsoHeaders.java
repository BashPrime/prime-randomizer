package com.etaylor8086.metroidprime.disc;

import com.etaylor8086.metroidprime.io.BinarySerializable;
import com.etaylor8086.metroidprime.io.GamecubeDiscIO;

public class GamecubeIsoHeaders extends BinarySerializable {
	public GamecubeDiscHeader discHeader = new GamecubeDiscHeader();
	public GamecubeDiscHeaderInfo discHeaderInfo = new GamecubeDiscHeaderInfo();
	public Apploader apploader = new Apploader();
	
	public void read(GamecubeDiscIO gcio) {
		gcio.read(discHeader);
		gcio.read(discHeaderInfo);
		gcio.read(apploader);
	}
	
	public void write(GamecubeDiscIO gcio) {
		// Write class members to gcio here
	}
}
