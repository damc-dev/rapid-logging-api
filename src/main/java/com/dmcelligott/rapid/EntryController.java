package com.dmcelligott.rapid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmcelligott.rapid.model.Entry;
import com.dmcelligott.rapid.service.EntryService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/entry")
public class EntryController {
	
	@Autowired
	EntryService service;
	
	@RequestMapping(method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Iterable<Entry>> listEntities() {
		return new ResponseEntity<Iterable<Entry>>(service.findAll(), HttpStatus.OK);
	}

}
