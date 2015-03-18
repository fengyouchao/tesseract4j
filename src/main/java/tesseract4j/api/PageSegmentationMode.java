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
 * The enumerate <code>PageSegmentationMode</code> represents -psm parameters
 * in tesseract line command.
 * 
 * @author Youchao Feng
 * @date  Mar 6, 2015 8:42:44 AM 
 * @version 1.0
 */
public enum PageSegmentationMode {
	
	OSD_ONLY(0),
	AUTOMATIC_OSD(1),
	AUTOMATIC_WITHOUT_OSD_OR_OCR(2),
	DEFAULT(3),
	SINGLE_COLUMN(4),
	SINGLE_UNIFORM_BLOCK_VERTICALLY(5),
	SINGLE_UNIFORM_BLOCK(6),
	SINGLE_TEXT_LINE(7),
	SINGLE_WORLD(8),
	SINGLE_WORLD_IN_CIRCLE(9),
	SINGLE_CHARACTER(10);
	
	private int value;
	
	private PageSegmentationMode(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
