package com.etaylor8086.metroidprime.patcher;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import com.etaylor8086.metroidprime.disc.GamecubeDiscHeader;
import com.etaylor8086.metroidprime.util.FileUtilities;

public class Prime1Reader extends GamecubeDiscImageReader {
	String fileName;
	GamecubeDiscHeader gameHeader;
	Prime1File[] prime1Files;
	List<PakFile> worldPaks;
	
	public Prime1Reader(String fileName) {
		this.gameHeader = new GamecubeDiscHeader();
		this.fileName = fileName;
		this.worldPaks = new ArrayList<PakFile>();
		FileUtilities.setFileName(fileName);
		this.gameHeader = this.readDiscHeader();
		this.prime1Files = this.readFileSystemTable(this.gameHeader);
	}
	
	
	
	public GamecubeDiscHeader readDiscHeader() {
		GamecubeDiscHeader gameHeader = new GamecubeDiscHeader();
//		gameHeader.gameId = new String(FileUtilities.readGameDiscData(this.GAMEID_OFFSET, 6));
//		gameHeader.version = FileUtilities.readGameDiscData(this.GAME_VERSION_OFFSET, 1)[0];
//		gameHeader.fstOffset = ByteBuffer.wrap(FileUtilities.readGameDiscData(this.FST_OFFSET_OFFSET, 4)).getInt();
//		gameHeader.fstSize = ByteBuffer.wrap(FileUtilities.readGameDiscData(this.FST_SIZE_OFFSET, 4)).getInt();
//		gameHeader.fstMaxSize = ByteBuffer.wrap(FileUtilities.readGameDiscData(this.FST_MAXSIZE_OFFSET, 4)).getInt();
		return gameHeader;
	}
	
	public Prime1File[] readFileSystemTable(GamecubeDiscHeader gameHeader) {
		int numEntries = ByteBuffer.wrap(FileUtilities.readGameDiscData(gameHeader.fstOffset + 8, 4)).getInt();
		Prime1File[] prime1Files = new Prime1File[numEntries];
		int stringTableOffset = gameHeader.fstOffset + (numEntries * 12);
		System.out.println("String table offset: " + stringTableOffset);
		for (int i = 1; i < numEntries; i++) {
			prime1Files[i-1] = new Prime1File();
			int fileFlag = FileUtilities.readGameDiscData(this.gameHeader.fstOffset + (i * 12), 1)[0];
			prime1Files[i-1].isDirectory = fileFlag == 1 ? true : false;
			
			byte[] fileNameOffsetBytes = FileUtilities.readGameDiscData(this.gameHeader.fstOffset + 1 + (i * 12),  3);
			prime1Files[i-1].fileName = new String(FileUtilities.readFileName(stringTableOffset + FileUtilities.convertOddByteArrToInt(fileNameOffsetBytes)));
			
			prime1Files[i-1].fileOffset = ByteBuffer.wrap(FileUtilities.readGameDiscData(this.gameHeader.fstOffset + 4 + (i * 12), 4)).getInt();
			prime1Files[i-1].multiIntVal = ByteBuffer.wrap(FileUtilities.readGameDiscData(this.gameHeader.fstOffset + 8 + (i * 12), 4)).getInt();
//			System.out.println(prime1Files[i-1].fileName + " - isDirectory: " + prime1Files[i-1].isDirectory + ", fileOffset: " + Integer.toHexString(prime1Files[i-1].fileOffset) + ", multiIntVal: " + prime1Files[i-1].multiIntVal);
			
			if (prime1Files[i-1].fileName.matches("Metroid[1-8].pak")) {
				System.out.println("World pak found");
				this.worldPaks.add(new PakFile(prime1Files[i-1].fileName, prime1Files[i-1].fileOffset));
			}
		}
		return prime1Files;
	}
	
	
}
