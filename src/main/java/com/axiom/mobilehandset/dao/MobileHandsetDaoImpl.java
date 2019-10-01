package com.axiom.mobilehandset.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.axiom.mobilehandset.model.MobileHandset;

import org.springframework.stereotype.Repository;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Mobile Handset Dao Impl
 */
@Repository
public class MobileHandsetDaoImpl implements MobileHandsetDao {

	/**
	 * Get All Mobiles implementation
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<MobileHandset> getAllMobiles() throws Exception{
		try (InputStreamReader reader = new InputStreamReader(new URL("https://api.myjson.com/bins/1f2r2v?pretty=true").openStream())) {
			Gson gson = new Gson();
			Type founderListType = new TypeToken<ArrayList<MobileHandset>>() {}.getType();
			return gson.fromJson(reader, founderListType);
		}
	}
}
