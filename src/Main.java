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
		
		int id = 0;

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

			// codepoint data
			String codepoint_jis208 = "";
			String codepoint_jis212 = "";
			String codepoint_jis213 = "";
			String codepoint_ucs = "";

			Elements codepoints = character.getElementsByTag("cp_value");
			for (Element codepoint : codepoints) {
				String cp_type = codepoint.attr("cp_type");
				switch(cp_type){
				case "jis208":
					codepoint_jis208 = commaFormat(codepoint_jis208, codepoint.text());
					break;
				case "jis212":
					codepoint_jis212 = commaFormat(codepoint_jis212, codepoint.text());
					break;
				case "jis213":
					codepoint_jis213 = commaFormat(codepoint_jis213, codepoint.text());
					break;
				case "ucs":
					codepoint_ucs = commaFormat(codepoint_ucs, codepoint.text());
					break;
				}
			}

			// radical data
			String radical_classical = "";
			String radical_nelson_c = "";

			Elements radicals = character.getElementsByTag("rad_value");
			for (Element radical : radicals) {
				String rad_type = radical.attr("rad_type");
				switch(rad_type){
				case "classical":
					radical_classical = commaFormat(radical_classical, radical.text());
					break;
				case "nelson_c":
					radical_nelson_c = commaFormat(radical_nelson_c, radical.text());
					break;
				}
			}

			// variants
			String variant_jis208 = "";
			String variant_jis212 = "";
			String variant_jis213 = "";
			String variant_deroo = "";
			String variant_njecd = "";
			String variant_s_h = "";
			String variant_nelson_c = "";
			String variant_oneill = "";
			String variant_ucs = "";

			Elements variants = character.getElementsByTag("variant");
			for (Element variant : variants) {
				String var_type = variant.attr("var_type");
				switch(var_type){
				case "jis208":
					variant_jis208 = commaFormat(variant_jis208, variant.text());
					break;
				case "jis212":
					variant_jis212 = commaFormat(variant_jis212, variant.text());
					break;
				case "jis213":
					variant_jis213 = commaFormat(variant_jis213, variant.text());
					break;
				case "deroo":
					variant_deroo = commaFormat(variant_deroo, variant.text());
					break;
				case "njecd":
					variant_njecd = commaFormat(variant_njecd, variant.text());
					break;
				case "s_h":
					variant_s_h = commaFormat(variant_s_h, variant.text());
					break;
				case "nelson_c":
					variant_nelson_c = commaFormat(variant_nelson_c, variant.text());
					break;
				case "variant_nelson_c":
					variant_oneill = commaFormat(variant_oneill, variant.text());
					break;
				case "ucs":
					variant_ucs = commaFormat(variant_ucs, variant.text());
					break;
				}
			}

			// dic references
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

			Elements dictionaries = character.getElementsByTag("dic_ref");
			for (Element dictionary : dictionaries) {
				String dr_type = dictionary.attr("dr_type");
				switch(dr_type){
				case "nelson_c":
					dic_nelson_c = commaFormat(dic_nelson_c, dictionary.text());
					break;
				case "nelson_n":
					dic_nelson_n = commaFormat(dic_nelson_n, dictionary.text());
					break;
				case "halpern_njecd":
					dic_halpern_njecd = commaFormat(dic_halpern_njecd, dictionary.text());
					break;
				case "halpern_kkd":
					dic_halpern_kkd = commaFormat(dic_halpern_kkd, dictionary.text());
					break;
				case "halpern_kkld":
					dic_halpern_kkld = commaFormat(dic_halpern_kkld, dictionary.text());
					break;
				case "halpern_kkld_2ed":
					dic_halpern_kkld_2ed = commaFormat(dic_halpern_kkld_2ed, dictionary.text());
					break;
				case "heisig":
					dic_heisig = commaFormat(dic_heisig, dictionary.text());
					break;
				case "heisig6":
					dic_heisig6 = commaFormat(dic_heisig6, dictionary.text());
					break;
				case "gakken":
					dic_gakken = commaFormat(dic_gakken, dictionary.text());
					break;
				case "oneill_names":
					dic_oneill_names = commaFormat(dic_oneill_names, dictionary.text());
					break;
				case "oneill_kk":
					dic_oneill_kk = commaFormat(dic_oneill_kk, dictionary.text());
					break;
				case "moro":
					dic_moro = commaFormat(dic_moro, dictionary.text());
					break;
				case "henshall":
					dic_henshall = commaFormat(dic_henshall, dictionary.text());
					break;
				case "sh_kk":
					dic_sh_kk = commaFormat(dic_sh_kk, dictionary.text());
					break;
				case "sakade":
					dic_sakade = commaFormat(dic_sakade, dictionary.text());
					break;
				case "jf_cards":
					dic_jf_cards = commaFormat(dic_jf_cards, dictionary.text());
					break;
				case "henshall3":
					dic_henshall3 = commaFormat(dic_henshall3, dictionary.text());
					break;
				case "tutt_cards":
					dic_tutt_cards = commaFormat(dic_tutt_cards, dictionary.text());
					break;
				case "crowley ":
					dic_crowley = commaFormat(dic_crowley, dictionary.text());
					break;
				case "kanji_in_context":
					dic_kanji_in_context = commaFormat(dic_kanji_in_context, dictionary.text());
					break;
				case "busy_people":
					dic_busy_people = commaFormat(dic_busy_people, dictionary.text());
					break;
				case "kodansha_compact":
					dic_kodansha_compact = commaFormat(dic_kodansha_compact, dictionary.text());
					break;
				case "maniette":
					dic_maniette = commaFormat(dic_maniette, dictionary.text());
					break;
				}
			}

			// query codes
			String code_skip = "";
			String code_sh_desc = "";
			String code_four_corner = "";
			String code_deroo = "";
			String code_misclass = "";

			Elements codes = character.getElementsByTag("q_code");
			for (Element code : codes) {
				String qc_type = code.attr("qc_type");
				switch(qc_type){
				case "skip":
					code_skip = commaFormat(code_skip, code.text());
					break;
				case "sh_desc":
					code_sh_desc = commaFormat(code_sh_desc, code.text());
					break;
				case "four_corner":
					code_four_corner = commaFormat(code_four_corner, code.text());
					break;
				case "deroo":
					code_deroo = commaFormat(code_deroo, code.text());
					break;
				case "misclass":
					code_misclass = commaFormat(code_misclass, code.text());
					break;
				}
			}

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

			// meanings
			String meaning_en = "";
			String meaning_fr = "";
			String meaning_es = "";
			String meaning_pt = "";	

			Elements meanings = character.getElementsByTag("meaning");
			for (Element meaning : meanings) {
				String m_lang = meaning.attr("m_lang");
				switch(m_lang){
				case "":
					meaning_en = commaFormat(meaning_en, meaning.text());
					break;
				case "fr":
					meaning_fr = commaFormat(meaning_fr, meaning.text());
					break;
				case "es":
					meaning_es = commaFormat(meaning_es, meaning.text());
					break;
				case "pt":
					meaning_pt = commaFormat(meaning_pt, meaning.text());
					break;
				}
			}

			if(meaning_en.contains("'")){
				meaning_en = meaning_en.replace("'", "''");
			}
			if(meaning_fr.contains("'")){
				meaning_fr = meaning_fr.replace("'", "''");
			}
			if(meaning_es.contains("'")){
				meaning_es = meaning_es.replace("'", "''");
			}
			if(meaning_pt.contains("'")){
				meaning_pt = meaning_pt.replace("'", "''");
			}

			result = result + "\n(" + id 
					+ ", '" + literal
					+ "', '" + grade
					+ "', '" + stroke_count
					+ "', '" + freq
					+ "', '" + jlpt
					+ "', '" + codepoint_jis208
					+ "', '" + codepoint_jis212
					+ "', '" + codepoint_jis213
					+ "', '" + codepoint_ucs
					+ "', '" + radical_classical
					+ "', '" + radical_nelson_c
					+ "', '" + variant_jis208
					+ "', '" + variant_jis212
					+ "', '" + variant_jis213
					+ "', '" + variant_deroo
					+ "', '" + variant_njecd
					+ "', '" + variant_s_h
					+ "', '" + variant_nelson_c
					+ "', '" + variant_oneill
					+ "', '" + variant_ucs
					+ "', '" + dic_nelson_c
					+ "', '" + dic_nelson_n
					+ "', '" + dic_halpern_njecd
					+ "', '" + dic_halpern_kkd
					+ "', '" + dic_halpern_kkld
					+ "', '" + dic_halpern_kkld_2ed
					+ "', '" + dic_heisig
					+ "', '" + dic_heisig6
					+ "', '" + dic_gakken
					+ "', '" + dic_oneill_names
					+ "', '" + dic_oneill_kk
					+ "', '" + dic_moro
					+ "', '" + dic_henshall
					+ "', '" + dic_sh_kk
					+ "', '" + dic_sakade
					+ "', '" + dic_jf_cards
					+ "', '" + dic_henshall3
					+ "', '" + dic_tutt_cards
					+ "', '" + dic_crowley
					+ "', '" + dic_kanji_in_context
					+ "', '" + dic_busy_people
					+ "', '" + dic_kodansha_compact
					+ "', '" + dic_maniette
					+ "', '" + code_skip
					+ "', '" + code_sh_desc
					+ "', '" + code_four_corner
					+ "', '" + code_deroo
					+ "', '" + code_misclass
					+ "', '" + ja_on
					+ "', '" + ja_kun
					+ "', '" + pinyin
					+ "', '" + korean_r
					+ "', '" + korean_h
					+ "', '" + nanori
					+ "', '" + meaning_en
					+ "', '" + meaning_fr
					+ "', '" + meaning_es
					+ "', '" + meaning_pt
					+ "'),";
			
			id++;

			System.out.println(id + "/13108");
		}	

		result = result.substring(0, result.length()-1) + ";";
		CreateSQL csql = new CreateSQL();
		csql.setContent(csql.getHeader() + result);
		csql.stringToFile("assets/result.sql");

	}

}
