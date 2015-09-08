package com.opensource.maker.common.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.opensource.maker.common.ConfigFileUtil;
 

public abstract class PropertyConfig {
	private static  Logger logger = Logger.getLogger(PropertyConfig.class);
	protected  String configName;
	private  Properties p = null;
	
	public String getConfigName() {
		return configName;
	}

	protected   PropertyConfig(String configName) {
		p = new Properties();
		String configPath = ConfigFileUtil.getPath(PropertyConfig.class,configName);
		if (configPath != null) {			
			try {
				InputStream input = new FileInputStream(configPath);
				p.load(input);
				this.configName = configName;
			} catch (FileNotFoundException e) {
				logger.error("",e);
				this.configName = null;
			} catch (IOException e) {
				logger.error("",e);
				this.configName = null;
			}			
		} else {
			logger.error("娌℃湁鍙戠幇閰嶇疆鏂囦欢spconfig.properties");
			this.configName = null;
		}
	}
	
	/**
	 * 鏍规嵁閰嶇疆鏂囦欢涓殑閿紝杩斿洖鍏跺瓧绗︿覆绫诲瀷鐨勫�
	 * 
	 * @param key the key
	 * 
	 * @return the value
	 */
	public  String getValue(String key) {
		String value = p.getProperty(key);
		return value;
	}
	
	/**
	 * 鏍规嵁閰嶇疆鏂囦欢涓殑閿紝杩斿洖鍏舵暣鏁扮被鍨嬬殑鍊硷紝濡傛灉涓嶈兘杞寲涓烘暣鏁帮紝杩斿洖0.
	 * 
	 * @param key the key
	 * 
	 * @return the int
	 */
	public  int getInt(String key) {
		String str = getValue(key);
		int valueInt = 0;
		if (str != null) {
			try {
				valueInt = Integer.parseInt(str);
			} catch (Exception e) {
				logger.debug(e);
			}
		}
		logger.debug(key + "->" + valueInt);
		return valueInt;
	}
	
	public  void traceInfo(String key) {
		logger.info(key + "->" + p.getProperty(key));
	}

	public Properties getProperties() {
		return p;
	}
	
	
}

