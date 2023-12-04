package com.poly.rest.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.poly.service.UploadService;

import jakarta.websocket.server.PathParam;

@CrossOrigin("*")
@RestController
public class UploadRestController {
	@Autowired
	UploadService uService;
	
	@PostMapping("/rest/upload/{files}")
	public JsonNode upload(@PathParam("file") MultipartFile file,
			@PathVariable("folder")String folder) {
		File saveFile = uService.save(file);
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("name", saveFile.getName());
		node.put("size", saveFile.length());
		return node;
	}
	
}
