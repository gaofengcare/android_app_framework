/**
 * 
 */
package com.fgao.mobile.fly.common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author gaofeng
 *
 */
public final class IOUtils {
		
	public static String readInputStream(InputStream ins){
		if (ins == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(ins));
		String str = null;
		try {
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			br.close();
			return sb.toString();
		} catch (IOException e) {
		}
		return null;
	}

	public static byte[] readInputStreamByte(InputStream ins) {
		if (ins == null) {
			return null;
		}
		BufferedInputStream bis = new BufferedInputStream(ins);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			byte[] buffer = new byte[128];
			int n = -1;
			while ((n = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, n);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bos.toByteArray();
	}
	
	public static void saveFile(String path,byte[] content){
		File f = new File(path);
		try {
			FileOutputStream bos = new FileOutputStream(f);
			bos.write(content);
			bos.flush();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveFileTmp(String _temp1,String content){
		File f = new File(_temp1);
		try {
			FileWriter bos = new FileWriter(f);
			bos.write(content);
			bos.flush();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
