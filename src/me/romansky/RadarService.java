package me.romansky;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: romansky
 * Date: 2/16/12
 * Time: 12:02 AM
 */
public class RadarService extends Service {

	private List<CameraData> cameras = new ArrayList<CameraData>();

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
	//code to execute when the service is first created
	}
	@Override
	public void onDestroy() {
	//code to execute when the service is shutting down
	}
	@Override
	public void onStart(Intent intent, int startId) {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document camerasDoc = builder.parse(getAssets().open("cameras.kml"));
			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList nodes = (NodeList) xpath.evaluate("//Placemark", camerasDoc, XPathConstants.NODESET);
			for (Integer i=0; i < nodes.getLength(); i++ ){
				Node node = nodes.item(i);
				CameraData camD = new CameraData(
						xpath.evaluate("name/text()", node, XPathConstants.STRING).toString(),
						xpath.evaluate("description/text()", node),
						xpath.evaluate("Point/coordinates/text()", node).split(",")[0],
						xpath.evaluate("Point/coordinates/text()", node).split(",")[1]
				);
				cameras.add(camD);
			}
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}


}
