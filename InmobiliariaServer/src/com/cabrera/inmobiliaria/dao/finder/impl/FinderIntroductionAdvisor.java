package com.cabrera.inmobiliaria.dao.finder.impl;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class FinderIntroductionAdvisor extends DefaultIntroductionAdvisor {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -8396020071684418886L;

	public FinderIntroductionAdvisor() {
	        super(new FinderIntroductionInterceptor());
	    }
}
