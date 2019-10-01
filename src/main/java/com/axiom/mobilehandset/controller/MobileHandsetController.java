package com.axiom.mobilehandset.controller;

import com.axiom.mobilehandset.model.MobileHandset;
import com.axiom.mobilehandset.service.MobileHandsetService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/mobile")
public class MobileHandsetController {
	private final MobileHandsetService mobileHandsetService;

	public MobileHandsetController(MobileHandsetService mobileHandsetService) {
		this.mobileHandsetService = mobileHandsetService;
	}

	@GetMapping(path = "/search", produces = "application/json")
	public List<MobileHandset> getMobileHandsets(@RequestParam(required = false) Map<String, String> allParams) {
		try {
			return mobileHandsetService.getMobileHandsets(allParams);
		} catch (Exception e){
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
}
