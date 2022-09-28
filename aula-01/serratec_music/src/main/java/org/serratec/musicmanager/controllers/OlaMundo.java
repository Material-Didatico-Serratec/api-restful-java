package org.serratec.musicmanager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OlaMundo {
	
	@GetMapping("/ola")
	public String olaMundo() {
		return "Ola Serratec Music!";
	}

}
