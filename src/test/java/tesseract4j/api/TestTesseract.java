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

import java.io.File;
import java.io.FileInputStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * The class <code>TestTesseract</code> is a test class to test
 * {@link Tesseract}.
 * 
 * @author Youchao Feng
 * @date  Mar 9, 2015 9:51:03 AM 
 * @version 1.0
 */
public class TestTesseract {

	@Test
	public void test() throws Exception {
		File imageFile  = new File(this.getClass().getResource("/").getPath() + "123.gif");
		FileInputStream inputStream = new FileInputStream(imageFile);
		String value = Tesseract.loadImage(inputStream)
				.setLanguage(Language.English)
				.ocr();
		System.out.println(value);
		Assert.assertEquals("TJW", value);
	}

}
