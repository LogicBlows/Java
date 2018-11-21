package com.bhaiti.kela.controllers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import com.bhaiti.kela.beans.StudentRegistration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
@Controller
public class StudentDeleteController {
@RequestMapping(method = RequestMethod.DELETE, value="/delete/student/{regdNum}")
@ResponseBody
@CrossOrigin(origins = "http://localhost:8000")
public JSONArray deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
	 JSONArray stdlist = null;
	 try
    	{
      	JSONParser jsonParser = new JSONParser();
		   
		    try (FileReader reader = new FileReader("E:/Student Registartion/File/students.json"))
		    {
		        //Read JSON file
		        Object obj = jsonParser.parse(reader);

		         stdlist = (JSONArray) obj;
		        System.out.println(stdlist);
		         }
		    catch (Exception e) {
		        e.printStackTrace();
		        stdlist=new JSONArray();
		    } 

  	FileWriter fw=new FileWriter("E:/Student Registartion/File/students.json",false);    
  	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
  	
  	
  	
  	 
  	
    stdlist.remove(Integer.parseInt(regdNum));
      fw.write(stdlist.toJSONString());    
  	fw.close();  	
  	} 
      catch (IOException e) 
  	{
  	System.out.println("file created");
      e.printStackTrace();
  	}
   
System.out.println("In deleteStudentRecord");   

  // return StudentRegistration.getInstance().deleteStudent(regdNum);
return stdlist;
}
}

