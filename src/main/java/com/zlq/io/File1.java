package com.zlq.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by liqing.zhan on 2016/8/15.
 */
public class File1 {
	public static void main(String args[]) throws IOException {
		String path = "\\home\\q\\server\\navigationdata\\";
		String name = "LocationRegion.Tmp";

		File filePath = new File(path);
		if (filePath.exists() && filePath.isDirectory()) {
			System.out.println(filePath + " is dir ");
		} else {
			filePath.mkdir();
		}

		File files = new File(filePath, name);
		if (!files.exists()) {
            System.out.println(files.getAbsoluteFile());
			files.createNewFile();
		}
	}
}
