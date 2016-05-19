package org.lazicats.ecos.internal.phoneSms.util;

import java.util.Random;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.phoneSms.model.PhoneInfo;

import com.jasson.im.api.APIClient;

public class SendTask extends Thread {
	private Logger logger = Logger.getLogger(SendTask.class);
	int loop = 10;
	long interval = 2000L;
	private APIClient handler=null;
	private PhoneInfo phoneInfo=null;
	
	
	public SendTask(APIClient handler, PhoneInfo phoneInfo) {
		this.handler = handler;
		this.phoneInfo=phoneInfo;
		
	}

	public void run() {
		Random random = new Random();
		long tmpSmId = 0;
		long tmpSrcId = 0;
		while (loop > 0) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
			}
			tmpSmId = random.nextInt(1000);
			tmpSrcId = random.nextInt(100);
			logger.info("TestSend:" + loop + "[smId:" + tmpSmId + ";srcId:"
					+ tmpSrcId + "]");
			handler.sendSM(phoneInfo.getMobileStr().split(","), phoneInfo
					.getContent(), tmpSmId, tmpSrcId);

			loop--;
		}
		logger.info("Test completed.");
	}
}
