package com.jumia.quiz.Dao.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jumia.quiz.Dao.customerDao;
import com.jumia.quiz.model.customer;
import com.sun.istack.logging.Logger;

@Repository
public class customerDaoImpl implements customerDao {

	@PersistenceContext
	public EntityManager entityManager;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(customerDaoImpl.class);

	@Override
	public List getAllCustomer() {

		List customersphone = new ArrayList();
		HashMap<String, Object> resultvalues = null;
		List<HashMap<String, Object>> Levels = new ArrayList();
		String queryString = "select  s.phone from customer s ";
		try {
			Query query = entityManager.createNativeQuery(queryString);

			customersphone = query.getResultList();

			String regex = "\\(237\\)\\ ?[2368]\\d{7,8}$";

			String regex2 = "\\(251\\)\\ ?[1-59]\\d{8}$";

			String regex3 = "\\(212\\)\\ ?[5-9]\\d{8}$";

			String regex4 = "\\(258\\)\\ ?[28]\\d{7,8}$";
			String regex5 = "\\(256\\)\\ ?\\d{9}$";

			Pattern pattern1 = Pattern.compile(regex);
			Pattern pattern2 = Pattern.compile(regex2);

			Pattern pattern3 = Pattern.compile(regex3);
			Pattern pattern4 = Pattern.compile(regex4);
			
			Pattern pattern5 = Pattern.compile(regex5);

			for (int i = 0; i < customersphone.size(); i++) {
				Matcher matcher1 = pattern1.matcher((CharSequence) customersphone.get(i));
				boolean match1 = matcher1.matches();

				Matcher matcher2 = pattern2.matcher((CharSequence) customersphone.get(i));
				boolean match2 = matcher2.matches();
				System.out.println(customersphone.get(i) + " : " + matcher2.matches());

				Matcher matcher3 = pattern3.matcher((CharSequence) customersphone.get(i));
				boolean match3 = matcher3.matches();
				System.out.println(customersphone.get(i) + " : " + matcher3.matches());

				Matcher matcher4 = pattern4.matcher((CharSequence) customersphone.get(i));
				boolean match4 = matcher4.matches();
				System.out.println(customersphone.get(i) + " : " + matcher4.matches());

				Matcher matcher5 = pattern5.matcher((CharSequence) customersphone.get(i));
				boolean match5 = matcher5.matches();
				System.out.println(customersphone.get(i) + " : " + matcher5.matches());

				if ((match1) = true) {
					resultvalues = new HashMap<String, Object>();

					resultvalues.put("PhoneNumber", customersphone.get(i));
					resultvalues.put("Country", "Cameroon");
					resultvalues.put("Country code", "+237");
					Levels.add(resultvalues);
				} else if ((match2) = true) {
					resultvalues = new HashMap<String, Object>();

					resultvalues.put("PhoneNumber", customersphone.get(i));
					resultvalues.put("Country", "Ethiopia");
					resultvalues.put("Country code", "+251");
					Levels.add(resultvalues);
				}
				
		        else if ((match3) = true) {
				resultvalues = new HashMap<String, Object>();

				resultvalues.put("PhoneNumber", customersphone.get(i));
				resultvalues.put("Country", "Morocco");
				resultvalues.put("Country code", "+212");
				Levels.add(resultvalues);
			} else if ((match4) = true) {
				
					resultvalues = new HashMap<String, Object>();

					resultvalues.put("PhoneNumber", customersphone.get(i));
					resultvalues.put("Country", "Mozambique");
					resultvalues.put("Country code", "+258");
					Levels.add(resultvalues);
			} else if ((match5) = true){
				resultvalues = new HashMap<String, Object>();

				resultvalues.put("PhoneNumber", customersphone.get(i));
				resultvalues.put("Country", "Uganda");
				resultvalues.put("Country code", "+258");
				Levels.add(resultvalues);
			} else {
				
				resultvalues = new HashMap<String, Object>();

				resultvalues.put("PhoneNumber", customersphone.get(i));
				resultvalues.put("Country", " ");
				resultvalues.put("Country code", " ");
				Levels.add(resultvalues);
				
			}
			}

		} catch (Error e) {
			((org.slf4j.Logger) logger).error("Error in getting Customers Numbers ", e);
		}
		return Levels;

	}

}
