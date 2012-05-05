package com.myjavaworld.ftp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.SocketFactory;

/**
 * Custom socket factory to connect through any proxy servers.
 * 
 * @author Sai Pullabhotla
 * 
 */
class CustomSocketFactory extends SocketFactory {

	/**
	 * The proxy, if any
	 */
	private Proxy proxy = null;

	/**
	 * Creates a new instance of <code>CustomSocketFactory</code>.
	 * 
	 * @param client
	 *            the FTP client
	 */
	public CustomSocketFactory(FTPClient client) {
		this.proxy = client.getProxy();
	}

	@Override
	public Socket createSocket(String host, int port) throws IOException,
			UnknownHostException {
		return createSocket(host, port, null, 0);
	}

	@Override
	public Socket createSocket(InetAddress address, int port)
			throws IOException {
		return createSocket(address, port, null, 0);
	}

	@Override
	public Socket createSocket(String host, int port, InetAddress localAddress,
			int localPort) throws IOException, UnknownHostException {
		return createSocket(InetAddress.getByName(host), port, localAddress,
				localPort);
	}

	@Override
	public Socket createSocket(InetAddress address, int port,
			InetAddress localAddress, int localPort) throws IOException {
		if (proxy == null) {
			return new Socket(address, port, localAddress, localPort);
		}
		switch (proxy.type()) {
		case SOCKS:
			Socket socket = new Socket(proxy);
			socket.bind(new InetSocketAddress(localAddress, localPort));
			socket.connect(new InetSocketAddress(address, port));
			return socket;
		case DIRECT:
			return new Socket(address, port, localAddress, localPort);
		default:
			throw new RuntimeException("Invalid or unimplemented proxy type: "
					+ proxy.type());
		}
	}
}
