package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.BackupContainer;

public class DataFunctions {
	public static void writeSaveFile(BackupContainer inputContainer) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("outputdata.dat"));
		oos.writeObject(inputContainer);
		oos.close();
	}
	public static BackupContainer readSaveFile(String filepath) throws Exception {
		ObjectInputStream ois;
		if(filepath.equals("default")) {
			ois = new ObjectInputStream(new FileInputStream("outputdata.dat"));
		} else {
			ois = new ObjectInputStream(new FileInputStream(filepath));
		}
		
		Object returnedData = ois.readObject();
		if(returnedData instanceof BackupContainer) {
			BackupContainer returnedContainer = (BackupContainer) returnedData;
			return returnedContainer;
		} else {
			throw new Exception();
		}
	}
	
}
