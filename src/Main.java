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
		System.out.println("Done.");
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

		for (Element character : characters) {
			//String href = character.attr("href");

			// Single data tags
			String literal = character.getElementsByTag("literal").text();
			String grade = character.getElementsByTag("grade").text();
			String stroke_count = character.getElementsByTag("stroke_count").text();
			String freq = character.getElementsByTag("literal").text();
			String jlpt = character.getElementsByTag("jlpt").text();

			// readings
			String ja_on = "";
			String ja_kun = "";
			String pinyin = "";
			String korean_r = "";
			String korean_h = "";

			Elements readings = doc.getElementsByTag("reading");
			for (Element reading : readings) {
				String r_type = reading.attr("r_type");
				switch(r_type){
				case "ja_on":
					if (!ja_on.equals("")){
						ja_on = reading.text();
						}
					else{
						ja_on = ", " + reading.text();
					}
					break;
				case "ja_kun":
					if (!ja_kun.equals("")){
						ja_kun = reading.text();
						}
					else{
						ja_kun = ", " + reading.text();
					}
					break;
				case "pinyin":
					if (!pinyin.equals("")){
						pinyin = reading.text();
						}
					else{
						pinyin = ", " + reading.text();
					}
					break;
				case "korean_r":
					if (!korean_r.equals("")){
						korean_r = reading.text();
						}
					else{
						korean_r = ", " + reading.text();
					}
					break;
				case "korean_h":
					if (!korean_h.equals("")){
						korean_h = reading.text();
						}
					else{
						korean_h = ", " + reading.text();
					}
					break;

				}

			}
			
			// nanori readings
			String nanori = "";
			
			Elements e_nanoris = doc.getElementsByTag("nanori");
			for (Element e_nanori : e_nanoris) {
				if (!nanori.equals("")){
					nanori = e_nanori.text();
					}
				else{
					nanori = ", " + e_nanori.text();
				}
			}


		}	


	}

}
