package com.hjh.ssmo.util.config;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.Configuration;

/**
 * 复合查询
 * 
 * @author haojiahong
 * 
 * @createtime：2015-12-17 下午4:07:31
 * 
 * 
 */
public class CompositeFactory {

	private static CompositeConfiguration configuration;

	private CompositeFactory() {
	}

	public static CompositeConfiguration getInstance() {
		if (configuration == null) {
			synchronized (CompositeFactory.class) {
				configuration = new CompositeConfiguration();
			}
		}
		return configuration;
	}

	public static void addConfiguration(Configuration config) {
		configuration = getInstance();
		configuration.addConfiguration(config);
	}

	public static String getString(String key) {
		return configuration.getString(key);
	}

}
