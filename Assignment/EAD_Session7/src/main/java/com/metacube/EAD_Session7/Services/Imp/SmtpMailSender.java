package com.metacube.EAD_Session7.Services.Imp;

import com.metacube.EAD_Session7.Services.MailSender;



public class SmtpMailSender implements MailSender {

	@Override
	public String sendMail() {
		return "This mail is send by SmtpMailSender.";
	}

}
