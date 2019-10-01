package com.axiom.mobilehandset.service;

import com.axiom.mobilehandset.model.Hardware;
import com.axiom.mobilehandset.model.MobileHandset;
import com.axiom.mobilehandset.model.Release;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Mobile HandSet Predicate
 * The Builder class for executing filter and building predicates
 */
public class MobileHandSetPredicate {

	/**
	 * Execute Search Criteria
	 */
	public static Predicate<MobileHandset> executeSearchCriteria(Map<String, String> filter) {
		List<Predicate<MobileHandset>> predicateList = new ArrayList<Predicate<MobileHandset>>();
		List<Class> classes = new ArrayList<>();
		classes.add(MobileHandset.class);
		classes.add(Hardware.class);
		classes.add(Release.class);
		filter.forEach((fieldName, fieldValue) -> {
			classes.forEach(aClass -> {
				Arrays.stream(aClass.getMethods()).forEach(method -> {
					if (method.getName().equalsIgnoreCase("get" + fieldName)) {
						if (aClass.getCanonicalName().equalsIgnoreCase(MobileHandset.class.getCanonicalName())) {
							predicateList.add(filterMobileHandsetClass(method, fieldValue));
						} else if (aClass.getCanonicalName().equalsIgnoreCase(Hardware.class.getCanonicalName())) {
							predicateList.add(filterHardwareClass(method, fieldValue));
						} else if (aClass.getCanonicalName().equalsIgnoreCase(Release.class.getCanonicalName())) {
							predicateList.add(filterReleaseClass(method, fieldValue));
						}

					}
				});

			});

		});
		return predicateList.stream()
				.reduce(w -> true, Predicate::and);
	}

	/**
	 * Filter Mobile Handset Class
	 */
	private static Predicate<MobileHandset> filterMobileHandsetClass(Method method,
	                                                                 String fieldValue) {
		return mobileHandset ->
		{
			try {
				return method.getReturnType() == Integer.class ? method.invoke(mobileHandset)
						.equals(Integer.parseInt(fieldValue))
						: (method.getName()
						.equalsIgnoreCase("getSim") ? String.valueOf(method.invoke(mobileHandset))
						.toLowerCase()
						.contains(fieldValue.toLowerCase())
						: method.invoke(mobileHandset).equals(fieldValue));
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
				return false;
			}
		};
	}

	/**
	 * Filter Hardware Class
	 */
	private static Predicate<MobileHandset> filterHardwareClass(Method method,
	                                                            String fieldValue) {
		return mobileHandset ->
		{
			try {
				Object hardware = mobileHandset.getHardware();
				return method.invoke(hardware).equals(fieldValue);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
				return false;
			}
		};
	}

	/**
	 * Filter Release Class
	 */
	private static Predicate<MobileHandset> filterReleaseClass(Method method,
	                                                           String fieldValue) {
		return mobileHandset ->
		{
			try {
				Object release = mobileHandset.getRelease();
				return method.getReturnType() == Double.class ? method.invoke(release)
						.equals(Double.parseDouble(fieldValue)) : method.invoke(release).equals(fieldValue);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
				return false;
			}
		};
	}
}
