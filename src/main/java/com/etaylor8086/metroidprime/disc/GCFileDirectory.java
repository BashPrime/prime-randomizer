package com.etaylor8086.metroidprime.disc;

import java.util.ArrayList;
import java.util.List;

public class GCFileDirectory {
	public String name = "";
	public List<GCFile> fileChildren = new ArrayList<GCFile>();
	public List<GCFileDirectory> directoryChildren = new ArrayList<GCFileDirectory>();
}
