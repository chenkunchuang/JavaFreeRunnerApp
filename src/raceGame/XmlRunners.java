package raceGame;

import java.io.*;
import java.nio.file.*;

import javax.xml.stream.*;



/**
 * This is for loading runner information from xml file
 * @author cchuang
 *
 */
public class XmlRunners extends ThreadRunner{

	/**
	 * Default constructor doing nothing
	 */
	public XmlRunners() {}
	
	/**
	 * XmlRunner constructor
	 * @param name: runner name
	 * @param speed: runner speed
	 * @param rest: runner rest percentage
	 */
	public XmlRunners(String name, int speed, int rest){
		super(name, speed, rest);
	}
	
	/**
	 * Reading from xml file to get runner information
	 */
	@Override
	public void ChooseSource(){
		Path filePath = Paths.get("FinalXMLData.xml");
		File fileObj = filePath.toFile();
		String name="", speed="", rest="";
		if(Files.exists(filePath))
		{
		    // create the XMLInputFactory object
	        XMLInputFactory inputFactory = XMLInputFactory.newFactory();
	        try
	        {
	            // create a XMLStreamReader object
	            FileReader fileReader =
	                new FileReader(fileObj);
	            XMLStreamReader reader =
	                inputFactory.createXMLStreamReader(fileReader);
	            // read the products from the file
	            while (reader.hasNext())
	            {
	                int eventType = reader.getEventType();
	                switch (eventType)
	                {
	                
	                	case XMLStreamConstants.START_ELEMENT:
	                    	String elementName = reader.getLocalName();
	                    	
		                        if (elementName.equals("Runner"))
		                        {
		                        	name = reader.getAttributeValue(0);
		                        }
		                        if (elementName.equals("RunnersMoveIncrement"))
		                        {
		                            speed = reader.getElementText();
		                        }
		                        if (elementName.equals("RestPercentage"))
		                        {
		                        	rest = reader.getElementText();
		                        }	
		                        
		                        
	                        break;
	                    case XMLStreamConstants.END_ELEMENT:
	                        elementName = reader.getLocalName();
	                        if (elementName.equals("Runner"))
	                        {
	                        	//load the runner info at the end of each runner info
	                        	ThreadRunner runner = new XmlRunners(name,Integer.parseInt(speed),Integer.parseInt(rest));
	                        	RaceMgr.AddRunner(runner);
	                        }
	                        break;
	                    default:
	                        break;
	                }
	                
	                reader.next();
	            }
	        }
	        catch (IOException | XMLStreamException e)
	        {
	            System.out.println(e);
	        }
	            
		}
	}
}
