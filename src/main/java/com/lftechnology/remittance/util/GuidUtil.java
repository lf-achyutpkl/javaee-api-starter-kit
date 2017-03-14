package com.lftechnology.remittance.util;

import java.util.UUID;

/**
 * Utility class for generating random UUID.
 * @author Achyut Pokhrel<achyutpokhrel@lftechnology.com>
 *
 */
public class GuidUtil {
	private GuidUtil(){}
	
	/**
	 * Generate UUID.
	 * @return UUID
	 */
	public static UUID generate(){
		return UUID.randomUUID();
	}
}
