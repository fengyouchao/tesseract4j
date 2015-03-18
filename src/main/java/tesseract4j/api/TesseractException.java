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
 * The class <code>TesseractException</code> represents exceptions
 * threw by {@link Tesseract}
 * 
 * @author Youchao Feng
 * @date  Mar 5, 2015 1:04:24 PM 
 * @version 1.0
 * @since tesseract-ocr 3.02
 */
public class TesseractException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TesseractException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TesseractException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TesseractException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TesseractException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TesseractException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
