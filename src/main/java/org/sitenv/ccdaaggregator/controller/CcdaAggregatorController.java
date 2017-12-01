package org.sitenv.ccdaaggregator.controller;

import java.io.IOException;
import java.util.List;

import org.sitenv.ccdaaggregator.service.CcdaAggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class CcdaAggregatorController {
	
	
	@Autowired
	CcdaAggregatorService ccdaAggregatorService;
	
	@RequestMapping(value="/ccdaaggregatorservice", method= RequestMethod.POST)
	public void ccdascorecardservice(@RequestParam("queryId") String queryId, @RequestParam("ccdaFiles") List<MultipartFile> ccdaFiles) throws IOException{
		 ccdaAggregatorService.processCcdaFiles(queryId,ccdaFiles);
	}
	
}
