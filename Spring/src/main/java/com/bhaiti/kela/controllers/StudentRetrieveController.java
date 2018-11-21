package com.bhaiti.kela.controllers;
import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhaiti.kela.beans.Student;
import com.bhaiti.kela.beans.StudentRegistration;
@Controller
public class StudentRetrieveController {
	
/*	JSONArray ja = new JSONArray();
*/
	@RequestMapping(method = RequestMethod.GET, value="/student/allstudent")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:8000")
	public List<Student> getAllStudents() {
		//return StudentRegistration.getInstance().getStudentRecords();

		JSONParser jsonParser = new JSONParser();
	    
		JSONArray stdlist;
	    
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

	
	return stdlist;
	}
}