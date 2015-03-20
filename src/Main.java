import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {

	public static void main(String[] args) {
		parse("assets/kanjidic2.xml");
	}

	private static void parse(String url) {

		String result = "";

		StringBuilder contentBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(url));
			String str;
			while ((str = in.readLine()) != null) {
				contentBuilder.append(str);
			}
			in.close();
		} catch (IOException e) {
		}
		String xml = contentBuilder.toString();

		Document doc = Jsoup.parse(xml);
		Elements characters = doc.getElementsByTag("character");

		int i =1 ;
		for (Element character : characters) {
			//String href = character.attr("href");
			String literal = character.getElementsByTag("literal").text();
			
		}	


	}

}
