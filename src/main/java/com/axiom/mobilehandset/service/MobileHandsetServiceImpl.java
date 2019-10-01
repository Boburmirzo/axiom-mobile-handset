package com.axiom.mobilehandset.service;

import com.axiom.mobilehandset.dao.MobileHandsetDao;
import com.axiom.mobilehandset.model.MobileHandset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Bobur Umurzokov.
 *
 * Mobile Handset Service Impl.
 */
@Service
public class MobileHandsetServiceImpl implements MobileHandsetService {

	/**
	 * LOG for logging track.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(MobileHandsetServiceImpl.class);

	/**
	 * Mobile Handset Dao.
	 */
	private final MobileHandsetDao mobileHandsetDao;

	/**
	 * MobileHandsetServiceImpl constructor.
	 */
	public MobileHandsetServiceImpl(MobileHandsetDao mobileHandsetDao) {
		this.mobileHandsetDao = mobileHandsetDao;
	}

	/**
	 * Get Mobile Handsets. Calls DAO method, parses mobile handset data and constructs a list of Mobile Handset
	 *
	 * @return List of MobileHandset
	 */
	public List<MobileHandset> getMobileHandsets(Map<String, String> filter) throws Exception {
        LOG.info("Request for getting mobile handset data is STARTED");
		List<MobileHandset> completeMobileHandset = completeMobileHandset = mobileHandsetDao.getAllMobiles();

		if (CollectionUtils.isEmpty(completeMobileHandset)) {
			return new ArrayList<>();
		}

		if (!CollectionUtils.isEmpty(filter)) {
			return completeMobileHandset
					.stream()
					.filter(MobileHandSetPredicate.executeSearchCriteria(filter))
					.collect(Collectors.toList());
		}
		LOG.info("Request for getting mobile handset data is FINISHED");
		return completeMobileHandset;
	}
}
