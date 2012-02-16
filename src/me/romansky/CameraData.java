package me.romansky;

/**
 * Created by IntelliJ IDEA.
 * User: romansky
 * Date: 2/16/12
 * Time: 1:28 AM
 */
public class CameraData {
	public String name;
	public String description;
	public String coordinateLon;
	public String coordinateLat;

	public CameraData(String name, String description, String coordinateLon, String coordinateLat){
		this.name = name;
		this.description = description;
		this.coordinateLon = coordinateLon;
		this.coordinateLat = coordinateLat;
	}
}
