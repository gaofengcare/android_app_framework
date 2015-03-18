/**
 * 
 */
package com.fgao.mobile.fly.tcp;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import com.fgao.mobile.fly.common.IOUtils;

/**
 * @author gaofeng
 * @date 2015-3-18
 */
public class SimpleSocketClient {

	private int timeout = 5000;
	private Socket socket;
	private InputStream ins;
	private OutputStream ous;

	public SimpleSocketClient() {
	}

	public void connect(String address, int port) throws UnknownHostException, IOException {
		socket = new Socket();
		socket.connect(new InetSocketAddress(address, port), timeout);
		socket.setKeepAlive(true);
	}
	
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void sendData(byte data[]) throws IOException {
		if (ous == null) {
			ous = socket.getOutputStream();
		}
		ous.write(data);
		ous.flush();
	}

	public byte[] getResult() throws IOException {
		ins = socket.getInputStream();
		if (ins == null) {
			return null;
		}
		return IOUtils.readInputStreamByte(ins);
	}
	
	public InputStream getIns() throws IOException {
		if (ins == null) {
			ins = socket.getInputStream();
		}
		return ins;
	}
	
	public OutputStream getOutputStream() throws IOException {
		if (ous == null) {
			ous = socket.getOutputStream();
		}
		return ous;
	}

	public void close() {
		try {
			if (ous != null) {
				ous.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (ins != null) {
				ins.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (socket != null && socket.isConnected()) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
