package org.lazicats.internal.dao;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.lazicats.ecos.basecomponent.utils.RandomUtils;
import org.lazicats.ecos.internal.payment.common.Allunion.db.Dao;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayNotify;
import org.lazicats.ecos.internal.payment.dao.UPOPPaymentDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
	
	private static ClassPathXmlApplicationContext ac;
	private static Dao dao;
	private static UPOPPaymentDao paymentDao;

	@BeforeClass
	public static void init() {
		 ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		 dao = ac.getBean(Dao.class);
		 paymentDao = ac.getBean(UPOPPaymentDao.class);
		 Assert.assertNotNull(dao);
	}
	
	@Test
	public void testSavePaymentReslOk() throws Exception {
		paymentDao.savePaymentResl("testorderno", "testpaymentON");
	}
	
	@Test
	public void testGetPaymentReslByOdNOk() throws Exception {
		String paymentOdN = paymentDao.getPaymentOrderNo2("testorderno");
		Assert.assertEquals("testpaymentON", paymentOdN);
	}
	
	@Test
	public void testGetPaymentReslByOdNNotFound() throws Exception {
		int paymentOdNC = paymentDao.countPaymentOrderNo("test");
		
		Assert.assertEquals(0, paymentOdNC);
	}
	
	@Test
	public void testInsertPaymentRef(){
		String randomNumberStr = RandomUtils.getRandomNumberStr(50);
		PayNotify qp = new PayNotify();
		qp.setEntinst("entinst");
		qp.setBizseq("bizseq");
		qp.setMac("mac");
		qp.setPayinst("payInst");
		qp.setTrxcod("trxcod");
		qp.setTimestamp("tstp");
		qp.setContent("");
		qp.setPayresult("0000");
		qp.setAmount(33600l);
		qp.setPayseq("payseq");
		qp.setTermid("termidid");
		qp.setTraceno("traceno");
		qp.setContent("");
		qp.setTrxid("trxid");
		
		dao.insertPaymentRef(qp);
	}
	
	@Test
	public void testInsertCustomReturnLog() throws UnsupportedEncodingException{
		String randomNumberStr = RandomUtils.getRandomNumberStr(32);
		String returnInfo = new String("入库成功".getBytes(),"GBK");
		 returnInfo = new String(returnInfo.getBytes("GBK"));
		 System.out.println(returnInfo);
			dao.insertCustomReturnLog("dfdsfskjddfkdfdf7fddrdfdfsdfss", "C01",returnInfo);
		}
	
	@Test
	public void testIsTrxidExist(){
		boolean resl = dao.isTrxidExist(
				"43588158065216687262792527471748251413273502209074");
		Assert.assertEquals(true,resl);
		
		boolean resl1 = dao.isTrxidExist(
				"4358815806521668726279252747174825141327350220907");
		Assert.assertEquals(false,resl1);
	}

}
