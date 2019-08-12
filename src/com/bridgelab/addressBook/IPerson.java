/*********************************************************************************************************
 * @purpose	:interface containing various abstract method
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:12-09-2019
 *******************************************************************************************************/
package com.bridgelab.addressBook;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public interface IPerson {
	public void addPerson() throws JsonGenerationException, JsonMappingException, IOException ;
	public void editPerson() throws JsonGenerationException, JsonMappingException, IOException;
	public void deletePerson()throws JsonGenerationException, JsonMappingException, IOException;
	public void sortByLastName();
	public void sortByZip();
	public void printReport();
	
}
