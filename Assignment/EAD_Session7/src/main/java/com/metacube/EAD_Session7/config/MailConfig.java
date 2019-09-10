package com.metacube.EAD_Session7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.EAD_Session7.Services.MailSender;
import com.metacube.EAD_Session7.Services.Imp.MockMailSender;
import com.metacube.EAD_Session7.Services.Imp.SmtpMailSender;



@Configuration
public class MailConfig {
	
	@Primary
	@Bean
	public MailSender smtpMailSender() {
		return new SmtpMailSender();
	}
	
	
	@Bean
	public MailSender mockMailSender() {
		return new MockMailSender();
	}

}
