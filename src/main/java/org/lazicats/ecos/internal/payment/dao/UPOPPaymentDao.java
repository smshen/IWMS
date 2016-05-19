package org.lazicats.ecos.internal.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UPOPPaymentDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 保存订单支付结果信息
	 * @param orderNo
	 */
	public void savePaymentResl(final String orderNo,final String paymentOrderNo) {
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into tbl_cbt_union_payment("
										+ "order_no,payment_orderno) values(?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,orderNo);	
				ps.setString(2,paymentOrderNo);	
				return ps;
			}
		});
	}
	
	public String getPaymentOrderNo(String orderNo) {
		String sql = "SELECT up.payment_orderno "
				   + "FROM tbl_cbt_union_payment up "
				   + "WHERE up.order_no='" + orderNo + "'";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int index) throws SQLException {
				return rs.getString(0);
			}
			
		});

	}
	
	public String getPaymentOrderNo2(String orderNo) {
		String sql = "SELECT up.payment_orderno "
				   + "FROM tbl_cbt_union_payment up "
				   + "WHERE up.order_no='" + orderNo + "'";
		
		return jdbcTemplate.queryForObject(sql,String.class);
	}
	
	public int countPaymentOrderNo(String orderNo) {
		String sql = "SELECT count(up.payment_orderno) "
				   + "FROM tbl_cbt_union_payment up "
				   + "WHERE up.order_no='" + orderNo + "'";
		
		return jdbcTemplate.queryForInt(sql);
	}
	
	public String getPaymentOrderNoIfExist(String orderNo) {
		if(countPaymentOrderNo(orderNo)>0){
			return getPaymentOrderNo2(orderNo);
		}else{
			return orderNo;
		}
		
	}

}
