package com.zlq.hack;

import java.io.File;

/**
 * Created by liqing.zhan on 2016/7/28.
 */
public class SecurityManagerTest {
	public static void main(String args[]) {
		System.setSecurityManager(new ReadSecurityManager());

		File f = new File("d://abc/a.txt");
		System.out.println(f.canRead());
	}
}

class ReadSecurityManager extends SecurityManager {
	@Override
	public void checkRead(String file) {
		throw new SecurityException("file read is not allowed");
	}

	@Override
	public void checkWrite(String file) {
		throw new SecurityException("file write is not allowed");
	}
}
