package com.etaylor8086.metroidprime.io;

public abstract class BinarySerializable {
	public abstract void read(GamecubeDiscIO gcio);
	public abstract void write (GamecubeDiscIO gcio);
}
