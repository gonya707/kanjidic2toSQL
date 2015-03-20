import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class CreateSQL {
	public String header = "-- Table created with kanjidic2toSQL \r\n" + 
			"-- https://github.com/gonya707/kanjidic2toSQL\r\n" + 
			"\r\n" + 
			"SET SQL_MODE=\"NO_AUTO_VALUE_ON_ZERO\";\r\n" + 
			"SET time_zone = \"+00:00\";\r\n" + 
			"\r\n" + 
			"--\r\n" + 
			"-- Table structure for table `kanjidic2`\r\n" + 
			"--\r\n" + 
			"\r\n" + 
			"CREATE TABLE IF NOT EXISTS `kanjidic2` (\r\n" + 
			"	`id` int(11) NOT NULL,\r\n" + 
			"	`literal` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`grade` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`stroke_count` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`freq` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`jlpt` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`codepoint_jis208` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`codepoint_jis212` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`codepoint_jis213` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`codepoint_ucs` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`radical_classical` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`radical_nelson_c` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`variant_jis208` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`variant_jis212` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`variant_jis213` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`variant_deroo` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`variant_njecd` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`variant_s_h` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`variant_nelson_c` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`variant_oneill` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`variant_ucs` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_nelson_c` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_nelson_n` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_halpern_njecd` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_halpern_kkd` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_halpern_kkld` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_halpern_kkld_2ed` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_heisig` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_heisig6` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_gakken` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_oneill_names` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_oneill_kk` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_moro` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_henshall` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_sh_kk` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_sakade` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_jf_cards` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_henshall3` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_tutt_cards` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_crowley` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_kanji_in_context` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_busy_people` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_kodansha_compact` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`dic_maniette` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`code_skip` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`code_sh_desc` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`code_four_corner` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`code_deroo` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`code_misclass` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`ja_on` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`ja_kun` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`pinyin` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`korean_r` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`korean_h` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`nanori` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`meaning_en` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`meaning_fr` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`meaning_es` varchar(255) COLLATE utf8_bin NOT NULL,\r\n" + 
			"	`meaning_pt` varchar(255) COLLATE utf8_bin NOT NULL\r\n" + 
			") ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;\r\n" + 
			"\r\n" + 
			"--\r\n" + 
			"-- Data for table `kanjidic2`\r\n" + 
			"--\r\n" + 
			"\r\n" + 
			"INSERT INTO `kanjidic2` (`id`, `literal`, `grade`, `stroke_count`, `freq`, `jlpt`, `codepoint_jis208`, `codepoint_jis212`, `codepoint_jis213`, `codepoint_ucs`, `radical_classical`, `radical_nelson_c`, `variant_jis208`, `variant_jis212`, `variant_jis213`, `variant_deroo`, `variant_njecd`, `variant_s_h`, `variant_nelson_c`, `variant_oneill`, `variant_ucs`, `dic_nelson_c`, `dic_nelson_n`, `dic_halpern_njecd`, `dic_halpern_kkd`, `dic_halpern_kkld`, `dic_halpern_kkld_2ed`, `dic_heisig`, `dic_heisig6`, `dic_gakken`, `dic_oneill_names`, `dic_oneill_kk`, `dic_moro`, `dic_henshall`, `dic_sh_kk`, `dic_sakade`, `dic_jf_cards`, `dic_henshall3`, `dic_tutt_cards`, `dic_crowley`, `dic_kanji_in_context`, `dic_busy_people`, `dic_kodansha_compact`, `dic_maniette`, `code_skip`, `code_sh_desc`, `code_four_corner`, `code_deroo`, `code_misclass`, `ja_on`, `ja_kun`, `pinyin`, `korean_r`, `korean_h`, `nanori`, `meaning_en`, `meaning_fr`, `meaning_es`, `meaning_pt`) VALUES";
	private static String content;

	public String getHeader(){
		return header;
	}
	
	public void setContent(String c){
		content = c;
	}
	
	public static void stringToFile(String name) {
		FileOutputStream fop = null;
		File file;

		try {

			file = new File(name);
			fop = new FileOutputStream(file);

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done writing");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
