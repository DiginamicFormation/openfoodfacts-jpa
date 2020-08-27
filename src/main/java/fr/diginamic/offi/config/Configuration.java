package fr.diginamic.offi.config;

import java.util.ResourceBundle;

/**
 * Configuration du projet
 * 
 * @author RichardBONNAMY
 *
 */
public class Configuration {

	/** fileUrl */
	private String fileUrl;

	/**
	 * Constructeur
	 * 
	 */
	public Configuration() {
		ResourceBundle properties = ResourceBundle.getBundle("configuration");
		fileUrl = properties.getString("file.url");
	}

	/**
	 * Getter
	 * 
	 * @return the fileUrl
	 */
	public String getFileUrl() {
		return fileUrl;
	}
}
