package spring.i18n.properties;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class PropertiesCreater {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		for(int i =100000;i<500000;i++)
		{
			sb.append("string").append(i).append(",\r\n");//.append("=").append("translation").append(i).append("\n");
		}
		FileUtils.writeStringToFile(new File("messages.properties"), sb.toString(),"utf8");
	}

}
