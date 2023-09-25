package com.poscodx.mysite.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.poscodx.mysite.service.SiteService;

public class ApplicationContextEventListener {
	@Autowired
	private SiteService siteService;
	
	@EventListener({ContextRefreshedEvent.class})
	public void handlerContextRefreshedEvent() {
		System.out.println("--- Context Refreshed Event Received ---" + siteService);
	}
}
