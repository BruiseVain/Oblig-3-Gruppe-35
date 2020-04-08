package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity){		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		
		try {
			// we use MD5 with 128 bits digest
			MessageDigest m = MessageDigest.getInstance("MD5");
		
			// compute the hash of the input 'entity'
			byte[] dig = m.digest(entity.getBytes("utf8"));
			// convert the hash into hex format
			String hash2Hex = toHex(dig);
			// convert the hex into BigInteger
			hashint = new BigInteger(hash2Hex, 16);
		
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// return the BigInteger
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		// get the digest length
		// compute the number of bits = digest length * 8
		// compute the address size = 2 ^ number of bits
	
		BigDecimal addressSize = BigDecimal.valueOf(Math.pow(2, bitSize()));
		BigInteger address = addressSize.toBigInteger();
		// return the address size
		
		return address;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		MessageDigest m = null;
		
		try {
			m = MessageDigest.getInstance("MD5");
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		digestlen = m.getDigestLength();
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
