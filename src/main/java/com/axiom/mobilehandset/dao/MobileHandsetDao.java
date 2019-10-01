package com.axiom.mobilehandset.dao;

import com.axiom.mobilehandset.model.MobileHandset;

import java.util.List;

/**
 * @author Bobur Umurzokov
 *
 * Mobile Handset Dao
 * Interface for fetching data from Mobile handset data
 */
public interface MobileHandsetDao {

	/**
	 *
	 * @return List of MobileHandSet
	 * @throws Exception if something went wrong while parsing data into object
	 */
	List<MobileHandset> getAllMobiles() throws Exception;
}