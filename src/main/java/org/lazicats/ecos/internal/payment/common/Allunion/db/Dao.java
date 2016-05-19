package org.lazicats.ecos.internal.payment.common.Allunion.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.lazicats.ecos.internal.payment.common.Allunion.model.PayNotify;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

//test
@Repository
public class Dao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * save the payment reference
	 * @param pn
	 */
	public void insertPaymentRef(final PayNotify pn) {
		System.out.println("inserting paynotify...");
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into tbl_allinpay_payment_ref(trxid,payseq,orderno,termid,traceno,timestamp) values(?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,pn.getTrxid());
				ps.setString(2,pn.getPayseq());
				ps.setString(3,pn.getBizseq());
				ps.setString(4,pn.getTermid());
				ps.setString(5,pn.getTraceno());
				ps.setString(6,pn.getTimestamp());
				return ps;
			}
		});
	}
	
	public boolean isTrxidExist(String trxid) {
		String sql = "select count(*) from tbl_allinpay_payment_ref pr where pr.trxid = ?";
		return jdbcTemplate.queryForInt(sql,trxid)>0;
	}
	
	/**
	 * test tet
	 * @param payTransactionNo
	 * @param returnCode
	 * @param returnInfo
	 */
	public void insertCustomReturnLog(final String payTransactionNo,final String returnCode,final String returnInfo) {
		System.out.println("inserting custom return log...");
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into TBL_CUSTOM_RETURN_LOG(PAYTRANSACTIONNO,RETURNCODE) values(?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,payTransactionNo);
				ps.setString(2,returnCode);
			
				return ps;
			}
		});
		
	}

}
