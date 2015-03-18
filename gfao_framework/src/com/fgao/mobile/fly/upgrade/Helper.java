
package com.fgao.mobile.fly.upgrade;   

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.fgao.mobile.fly.common.IOUtils;
import com.fgao.mobile.fly.common.Utils;
import com.fgao.mobile.fly.model.AppVersion;


/**
 * @author gaofeng
 * @since 2015 
 */
public class Helper {

	/**
	 * 
	 */
	public Helper() {
		// TODO Auto-generated constructor stub
	}

	public static boolean checkAppVersion(String newOne, String oldOne) {
		if (newOne == null) {
			return false;
		}
		String new1 = newOne;
		if (new1 == null || new1.length() <= 1) {
			return false;
		}
		String old = oldOne;
		String v1[] = new1.split("\\.");
		String v2[] = old.split("\\.");
		int n = 1000;
		int n1 = 0;
		for (int i = 0; i < v1.length; i++) {
			n = n / 10;
			n1 = n1 + Integer.parseInt(v1[i]) * n;
		}
		n = 1000;
		int n2 = 0;
		for (int i = 0; i < v2.length; i++) {
			n = n / 10;
			n2 = n2 + Integer.parseInt(v2[i]) * n;
		}
		return n1 > n2;
	}

	public static boolean checkAppVersion(AppVersion newOne, String oldOne) {
		if (newOne == null) {
			return false;
		}
		String new1 = newOne.version;
		if (new1 == null || new1.length() <= 1) {
			return false;
		}
		String old = oldOne;
		String v1[] = new1.split("\\.");
		String v2[] = old.split("\\.");
		int n = 1000;
		int n1 = 0;
		for (int i = 0; i < v1.length; i++) {
			n = n / 10;
			n1 = n1 + Integer.parseInt(v1[i]) * n;
		}
		n = 1000;
		int n2 = 0;
		for (int i = 0; i < v2.length; i++) {
			n = n / 10;
			n2 = n2 + Integer.parseInt(v2[i]) * n;
		}
		return n1 > n2;
	}
	
	public static AppVersion parserXML(String xmlfilePath) {
		String xml = null;
		try {
			xml = IOUtils.readInputStream(new FileInputStream(xmlfilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		AppVersion version;
		if (xml != null) {
			version = new AppVersion();
			version.apkURL = Utils.substringBetween(xml, "<apk>", "</apk>");
			version.desc = Utils.substringBetween(xml, "<desc>", "</desc>");
			version.version = Utils.substringBetween(xml, "<ver>", "</ver>");
			File f = new File(xmlfilePath);
			if (f.exists()) {
				f.delete();
			}
			return version;
		}
		return null;
	}
}
