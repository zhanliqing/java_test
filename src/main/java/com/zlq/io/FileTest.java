package com.zlq.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by liqing.zhan on 2016/8/2.
 */
public class FileTest {

	@Test
	public void rename_t() throws IOException {
		File file = new File("d://abc/first.txt");
		if (!file.exists()) {
			file.createNewFile();
		}

		File dest = new File("");
		file.renameTo(dest);
	}

	@Test

	public void directoryExists() {
		File f = new File("/home/q/server/navigationdata/locationRegion");
		System.out.println(f.exists() && f.isDirectory());
	}

	@Test
	public void touchFile() throws IOException {
		File f = new File("d://abc");

		File f1 = new File(f, "xxxxxx");
		f1.createNewFile();
	}
}
