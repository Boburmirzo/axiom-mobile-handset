package com.axiom.mobilehandset.service;

import com.axiom.mobilehandset.model.MobileHandset;

import java.util.List;
import java.util.Map;

/**
 * Mobile Handset Service
 */
public interface MobileHandsetService {

	/**
	 *
	 * @param filter
	 * @return List of MobileHandset object fetched from Json
	 * @throws Exception
	 */
	List<MobileHandset> getMobileHandsets(Map<String, String> filter) throws Exception;
}
