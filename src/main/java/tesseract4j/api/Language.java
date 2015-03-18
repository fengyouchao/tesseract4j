/* 
 * Copyright 2015-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tesseract4j.api;

/**
 * 
 * The enumerate <code>Language</code> represents -lang parameters
 * in tesseract line command.
 * 
 * @author Youchao Feng
 * @date  Mar 5, 2015 1:04:08 PM 
 * @version 1.0
 * @since tesseract-ocr 3.02
 */
public enum Language {
	
	/**
	 * Afrikaans language.
	 */
	Afrikaans("afr"),
	/**
	 * Albanian language.
	 */
	Albanian("sqi"),
	
	/**
	 * Arabic language.
	 */
	Arabic("ara"),
	
	/**
	 * Azerbaijani language.
	 */
	Azerbaijani("aze"),
	
	/**
	 * Basque language.
	 */
	Basque("eus"),
	
	/**
	 * Belarusian language.
	 */
	Belarusian("bel"),
	
	/**
	 * Bengali language.
	 */
	Bengali("ben"),
	
	/**
	 * Bulgarian language.
	 */
	Bulgarian("bul"),
	
	/**
	 * Catalan language.
	 */
	Catalan("cat"),
	
	/**
	 * Cherokee language.
	 */
	Cherokee("chr"),
	
	/**
	 * Chinese (Simplified) language.
	 */
	ChineseSimplified("chi_sim"),
	
	/**
	 * Chinese (Traditional) language.
	 */
	ChineseTraditional("chi_tra"),
	
	/**
	 * Czech language.
	 */
	Czech("ces"),
	
	/**
	 * Danish language.
	 */
	Danish("dan"),
	
	/**
	 * Dutch language.
	 */
	Dutch("nld"),
	
	/**
	 * English language.
	 */
	English("eng"),
	
	/**
	 * Esperanto language.
	 */
	Esperanto("epo"),
	
	/**
	 * Estonian language.
	 */
	Estonian("est"),
	
	/**
	 * Finish language.
	 */
	Finish("fin"),
	
	/**
	 * Franksih language.
	 */
	Frankish("frk"),
	
	/**
	 * French language.
	 */
	French("fra"),
	
	/**
	 * Galician language.
	 */
	Galician("glg"),
	
	/**
	 * German language.
	 */
	German("deu"),
	
	/**
	 * Greek language.
	 */
	Greek("ell"),
	
	/**
	 * Hebrew language.
	 */
	Hebrew("heb"),
	
	/**
	 * Hindi language.
	 */
	Hindi("hin"),
	
	/**
	 * Icelandic language.
	 */
	Icelandic("isl"),
	
	/**
	 * Indonesian language.
	 */
	Indonesian("ind"),
	
	/**
	 * Italian language.
	 */
	Italian("ita"),
	
	/**
	 * Italian(Old) language.
	 */
	ItalianOld("ita_old"),
	
	/**
	 * Japanese language.
	 */
	Japanese("jpn"),
	
	/**
	 * Kannada language.
	 */
	Kannada("kan"),
	
	/**
	 * Korean language.
	 */
	Korean("kor"),
	
	/**
	 * Latvian language.
	 */
	Latvian("lav"),
	
	/**
	 * Lithuanian language.
	 */
	Lithuanian("lit"), 
	
	/**
	 * Malay language.
	 */
	Malay("msa"),
	
	/**
	 * Malayalam language.
	 */
	Malayalam("mal"),
	
	/**
	 * Maltese language.
	 */
	Maltese("mlt"),
	
	/**
	 * Math / equation detection module.
	 */
	MathOrEquationDetectionModule("equ"),
	
	/**
	 * Middle English (1100-1500).
	 */
	MiddleEnglish("enm"),
	
	/**
	 * Middle French (ca. 1400-1600) language.
	 */
	MiddleFrench("frm"),
	
	/**
	 * Norwegian language.
	 */
	Norwegian("nor"),
	
	/**
	 * Polish language.
	 */
	Polish("pol"),
	
	/**
	 * Portuguese language.
	 */
	Portuguese("por"),
	
	/**
	 * Romanian language.
	 */
	Romanian("ron"),
	
	/**
	 * Spanish language.
	 */
	Spanish("spa"),
	
	/**
	 * Spanish(Old) language.
	 */
	SpanishOld("spa_old"),
	
	/**
	 * Serbian(Latin) language.
	 */
	SerbianOrLatin("srp"),
	
	/**
	 * Slovenian language.
	 */
	Slovenian("slv"), 
	
	/**
	 * Slovakian language.
	 */
	Slovakian("slk"),
	
	/**
	 * Swahili language.
	 */
	Swahili("swa"),
	
	/**
	 * Swedish language.
	 */
	Swedish("swe"),
	
	/**
	 * Turkish language.
	 */
	Turkish("tur"),
	
	/**
	 * Tagalog language.
	 */
	Tagalog("tgl"),
	
	/**
	 * Tamil language.
	 */
	Tamil("tam"),
	
	/**
	 * Telugu language.
	 */
	Telugu("tel"),
	
	/**
	 * Thai language.
	 */
	Thai("tha"),
	
	/**
	 * Ukrainian language.
	 */
	Ukrainian("ukr"),
	;
	
	/**
	 * Parameter value
	 */
	private String value;
	
	private Language(String value){
		this.value = value;
	}
	
	/**
	 * Get value.
	 * 
	 * @return value.
	 */
	public String getValue(){
		return value;
	}
}
