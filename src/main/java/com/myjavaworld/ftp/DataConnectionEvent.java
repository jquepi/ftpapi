/*
 * This software is the confidential and proprietary information of the author,
 * Sai Pullabhotla. You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement you
 * entered into with the author. 
 * 
 * THE AUTHOR MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF 
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR 
 * NON-INFRINGEMENT. THE AUTHOR SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY 
 * LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR 
 * ITS DERIVATIVES.
 */
package com.myjavaworld.ftp;

import java.util.EventObject;

/**
 * An event generated by data connections to notify the status of data transfer.
 * 
 * @author Sai Pullabhotla, psai [at] jMethods [dot] com
 * @version 2.0
 */
public class DataConnectionEvent extends EventObject {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 7736555651463625070L;
	/**
	 * A constant to indicate that data is being sent to the remote host.
	 */
	public static final int SEND = 1;
	/**
	 * A constant to indicate that data is being received from the remote host.
	 */
	public static final int RECEIVE = 2;
	/**
	 * The type of this event.
	 */
	private int id = 0;
	/**
	 * Number of bytes trabsferred so far.
	 */
	private long bytesTransferred = 0L;

	/**
	 * Constructs a <code>DataConnectionEvent</code>.
	 * 
	 * @param source
	 *            The object that generated this event.
	 * @param id
	 *            Type of this event. Possible types are -
	 *            <ol>
	 *            <li><code>DataConnectionEvent.SEND</code></li>
	 *            <li><code>DataConnectionEvent.RECEIVE</code></li>
	 *            </ol>
	 * @param bytesTransferred
	 *            Number of bytes transferred so far.
	 */
	public DataConnectionEvent(Object source, int id, long bytesTransferred) {
		super(source);
		this.id = id;
		this.bytesTransferred = bytesTransferred;
	}

	/**
	 * Returns the ID ot type of this event.
	 * 
	 * @return Type of this event.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the number of bytes transferred.
	 * 
	 * @return number of bytes transferred.
	 */
	public long getBytesTransferred() {
		return bytesTransferred;
	}

	/**
	 * String rpresentation of this event.
	 * 
	 * @return String representation of this event.
	 */
	@Override
	public String toString() {
		return "Type: " + id + " Bytes Transferred: " + bytesTransferred;
	}
}