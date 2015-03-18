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

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tesseract4j.util.ShellExecuteResult;
import tesseract4j.util.ShellExecutor;
import tesseract4j.util.ShellExecutors;

/**
 * 
 * The class <code>Tesseract</code> is core class in tessseract4j.
 * it used to call tesseract command and return text in image.<br>
 * example:
 * <pre>
 * 		String text = 
 * 		Tesseract.loadImage(new File("a.png")).setLanguage(Language
 * 			.English).ocr();
 * </pre>
 * 
 * @author Youchao Feng
 * @date  Mar 5, 2015 1:04:16 PM 
 * @version 1.0
 * @since tesseract-ocr 3.02
 */
public final class Tesseract {
	
	protected static final Logger logger = LoggerFactory.getLogger(Tesseract.class);
	
	private static final String TESSERACT_COMMAND = "tesseract";

	/**
	 * Image file.
	 */
	private File imageFile;

	/**
	 * output parameter.
	 */
	private String outputParameter = ".tessract_temp_output_" 
			+ System.currentTimeMillis()
			+ (int)(Math.random()*100);

	/**
	 * Output file.
	 */
	private File outputFile = new File(outputParameter+".txt");

	/**
	 * Text's language, -lang
	 */
	private Language language = null;

	/**
	 * User's dictionary name.
	 */
	private String dictionayName = null;
	
	/**
	 * -psm parameter.
	 */
	private PageSegmentationMode psm = null;

	/**
	 * Keep output file.
	 */
	private static boolean keepOutputFile = false;
	
	/**
	 * keep input image.
	 */
	private static boolean keepInputImage = false;

	/**
	 * Construct a <code>Tesseract</code> instance by a image 
	 * <code>java.io.File</code>.
	 *  
	 * @param imageFile The <code>java.io.File</code> instance which 
	 * 					represent a image.
	 */
	private Tesseract(File imageFile){
		this.imageFile = imageFile;
	}

	/**
	 * Get a <code>Tesseract</code> instance by <code>java.io.File</code>.
	 * 
	 * @param imageFile The <code>java.io.File</code> instance which 
	 * 					represent a image file.
	 * @return			<code>Tesseract</code> instance.
	 */
	public static final Tesseract loadImage(File imageFile){
		keepInputImage = true;
		return new Tesseract(imageFile);
	}

	/**
	 * Get a <code>Tesseract</code> instance by <code>java.io.InputStream</code>.This method
	 * will create a temporary image file in PNG format.
	 * 
	 * @param imageInputStream  The <code>java.io.InputStream</code> instance which 
	 * 							represent a image.
	 * @return	<code>Tesseract</code> instance.
	 */
	public static final Tesseract loadImage(InputStream imageInputStream){
		File imageFile  = new File(".tesseract_temp_image_"
				+ System.currentTimeMillis()
				+ (int)(Math.random()*100)
				+ ".png");
		try {
			BufferedImage image  = ImageIO.read(imageInputStream);
			ImageIO.write(image, "png", imageFile);
		} catch (IOException e) {
			throw new TesseractException(e.getMessage());
		}
		return new Tesseract(imageFile);
	}

	/**
	 * Get a <code>Tesseract</code> instance by byte array.This method will create
	 * a temporary image file in PNG format.
	 * 
	 * @param imageBytes	byte array of image file.
	 * @return	<code>Tesseract</code> instance.
	 */
	public static final Tesseract loadImage(byte[] imageBytes){
		
		return loadImage(new ByteArrayInputStream(imageBytes));
	}

	/**
	 * Keep output file.
	 * 
	 * @return {@link Tesseract}
	 */
	public final Tesseract keepOutputFile(){
		keepOutputFile = true;
		return this;
	}

	/**
	 * Set language.
	 * 
	 * @param language language
	 * @return <code>Tesseract</code> instance.
	 */
	public final Tesseract setLanguage(Language language){
		this.language = language;
		return this;
	}

	/**
	 * Set custom dictionary.
	 * 
	 * @param dictionayName The name of dictionary.
	 * @return <code>Tesseract</code> instance.
	 */
	public final Tesseract setCustomDic(String dictionayName){
		this.dictionayName = dictionayName;
		return this;
	}
	
	/**
	 * Set page segmentation mode.
	 * 
	 * @param pageSegmentationMode page segmentation mode.
	 * @return <code>Tesseract</code> instance.
	 */
	public final Tesseract setPageSegmentationMode(PageSegmentationMode pageSegmentationMode) {
		this.psm = pageSegmentationMode;
		return this;
	}

	/**
	 * Start to ORC.
	 * 
	 * @return The text in image.
	 * @throws TesseractException Exception if any error occurs.
	 */
	public final String ocr() throws TesseractException{
		String value = null;
		ShellExecutor shellExecutor = ShellExecutors.newDefaultShellExecutor();

		try {
			shellExecutor.setWorkDir(new File("").getCanonicalFile());
		} catch (IOException ioe) {
			throw new TesseractException(ioe.getMessage());
		}
		
		final String command = TESSERACT_COMMAND + " " 
				+ imageFile.getAbsolutePath() + " "									//image name
				+ outputParameter + " " 							    			//output base
				+ (language == null ? "" : " -l "+language.getValue()) + " "  		// -l parameter
				+ (psm == null ? "" : " -psm " + psm.getValue()) + " "				// -psm parameter
				+ (dictionayName == null ? "" : "nobatch "+ dictionayName) + " "	//custom dictionary
				;

		logger.debug(command);
		ShellExecuteResult result = shellExecutor.execute(command);

		if(result.isSuccess()){
			FileInputStream fileInputStream = null;
			BufferedReader reader = null;
			try {
				fileInputStream = new FileInputStream(outputFile);
				reader = new BufferedReader(new InputStreamReader(fileInputStream));
				value = reader.readLine();
			} catch (IOException e) {
				throw new TesseractException(e.getMessage());
			}finally{
				try {
					reader.close();
					fileInputStream.close();
				} catch (IOException e) {
					throw new TesseractException(e.getMessage());
				}
				
			}

		}else{
			throw new TesseractException(result.getErrorMessage());
		}
		if (!keepOutputFile) {
			outputFile.delete();
		}
		if (!keepInputImage) {
			imageFile.delete();
		}
		return value;
	}
}
