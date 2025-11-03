package com.set_job_portal.Service;

import org.springframework.stereotype.Service;

@Service
public class ChatLoggerService
{
	public void logConnection(String message) {
		System.out.println("WebSockect Log:"+message);
	}

}
