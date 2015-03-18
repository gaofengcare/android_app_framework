/**
 * 
 */
package com.fgao.mobile.fly.common;

/**
 * @author gaofeng
 * 2015
 */
public class Utils {

	public Utils() {
	}
	
    public static String byteToBit(byte b) {  
        return ""  
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)  
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)  
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)  
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);  
    }  

	public static String byteArrayToIP(byte[] bytes) {
		return new StringBuffer().append(bytes[3] & 0xFF).append('.').append(bytes[2] & 0xFF).append('.')
				.append(bytes[1] & 0xFF).append('.').append(bytes[0] & 0xFF).toString();
	}
	
	
	public static String substringBetween(String str, String tag) {
		return substringBetween(str, tag, tag);
	}

	public static String substringBetween(String str, String open, String close) {
		if (str == null || open == null || close == null) {
			return null;
		}
		int start = str.indexOf(open);
		if (start != -1) {
			int end = str.indexOf(close, start + open.length());
			if (end != -1) {
				return str.substring(start + open.length(), end);
			}
		}
		return null;
	}
	

}
