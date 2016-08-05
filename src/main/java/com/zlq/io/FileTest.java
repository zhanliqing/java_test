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
}
