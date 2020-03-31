package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) throws NoSuchAlgorithmException, UnsupportedEncodingException {		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		byte [] bytesOfMsg = entity.getBytes("UTF-8");
		
		
		// we use MD5 with 128 bits digest
		MessageDigest m = MessageDigest.getInstance("MD5");
		
		// compute the hash of the input 'entity'
		byte[] hash = m.digest(bytesOfMsg);
		// convert the hash into hex format
		StringBuilder hex = new StringBuilder(2*hash.length);
		for(byte b : hash) {
			hex.append(String.format("%02x", b&0xff));
		}
		String digest = hex.toString();
		// convert the hex into BigInteger
		hashint = new BigInteger(digest, 16);
		
		// return the BigInteger
		
		return hashint;
	}
	
	public static BigInteger addressSize() throws NoSuchAlgorithmException {
		
		// Task: compute the address size of MD5
		MessageDigest m = MessageDigest.getInstance("MD5");
		
		// get the digest length
		int length = m.getDigestLength();
		
		// compute the number of bits = digest length * 8
		int bits = length*8;
		// compute the address size = 2 ^ number of bits
		int address = (int)Math.pow(2, bits);
		
		BigInteger bigInteger = BigInteger.valueOf(address);
		// return the address size
		
		return bigInteger;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		
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
