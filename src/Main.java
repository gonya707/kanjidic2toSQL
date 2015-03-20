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
	
	private static String commaFormat(String s, String append){
		if (!s.equals("")){
			s = s + ", " + append;
		}
		else{
			s = append;
		}
		return s;
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
			
			// Single data tags
			String literal = character.getElementsByTag("literal").text();
			String grade = character.getElementsByTag("grade").text();
			String stroke_count = character.getElementsByTag("stroke_count").text();
			String freq = character.getElementsByTag("freq").text();
			String jlpt = character.getElementsByTag("jlpt").text();
			
			// codepoint data TODO
			String codepoint_jis208 = "";
			String codepoint_jis212 = "";
			String codepoint_jis213 = "";
			String codepoint_ucs = "";
			
			// radical data TODO
			String radical_classical = "";
			String radical_nelson_c = "";
			
			// variants TODO
			String variant_jis208 = "";
			String variant_jis212 = "";
			String variant_jis213 = "";
			String variant_deroo = "";
			String variant_njecd = "";
			String variant_s_h = "";
			String variant_nelson_c = "";
			String variant_oneill = "";
			String variant_ucs = "";
			
			// dic references TODO
			String dic_nelson_c = "";
			String dic_nelson_n = "";
			String dic_halpern_njecd = "";
			String dic_halpern_kkd = "";
			String dic_halpern_kkld = "";
			String dic_halpern_kkld_2ed = "";
			String dic_heisig = "";
			String dic_heisig6 = "";
			String dic_gakken = "";
			String dic_oneill_names = "";
			String dic_oneill_kk = "";
			String dic_moro = "";
			String dic_henshall = "";
			String dic_sh_kk = "";
			String dic_sakade = "";
			String dic_jf_cards = "";
			String dic_henshall3 = "";
			String dic_tutt_cards = "";
			String dic_crowley = "";
			String dic_kanji_in_context = "";
			String dic_busy_people = "";
			String dic_kodansha_compact = "";
			String dic_maniette = "";
			
			// query codes TODO
			String code_skip = "";
			String code_sh_desc = "";
			String code_four_corner = "";
			String code_deroo = "";
			String code_misclass = "";
			
			// readings
			String ja_on = "";
			String ja_kun = "";
			String pinyin = "";
			String korean_r = "";
			String korean_h = "";
			String nanori = "";

			Elements readings = character.getElementsByTag("reading");
			for (Element reading : readings) {
				String r_type = reading.attr("r_type");
				switch(r_type){
				case "ja_on":
					ja_on = commaFormat(ja_on, reading.text());
					break;
				case "ja_kun":
					ja_kun = commaFormat(ja_kun, reading.text());
					break;
				case "pinyin":
					pinyin = commaFormat(pinyin, reading.text());
					break;
				case "korean_r":
					korean_r = commaFormat(korean_r, reading.text());
					break;
				case "korean_h":
					korean_h = commaFormat(korean_h, reading.text());
					break;
				}
			}

			Elements e_nanoris = character.getElementsByTag("nanori");
			for (Element e_nanori : e_nanoris) {
				nanori = commaFormat(nanori, e_nanori.text());
			}
			
			// meanings TODO
			

			//System.out.println(literal + " " + ja_on);

		}	


	}

}
