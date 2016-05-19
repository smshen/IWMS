package org.lazicats.ecos.internal.promotion.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

@Repository
public class CouponDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void saveCoupon(final String mobile,final String coupon) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into tbl_promotion_coupon(mobile,coupon) values(?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,mobile);	
				ps.setString(2,coupon);	
				return ps;
			}
		});
	}
	

	public boolean exist(String mobile) {
		String sql = "select count(mobile) from tbl_promotion_coupon cp where cp.mobile=" + mobile;
		return jdbcTemplate.queryForInt(sql)>0;
	}
	
	public String getExistCoupon(String mobile) {
		String sql = "select coupon from tbl_promotion_coupon cp where cp.mobile=" + mobile;
		return jdbcTemplate.queryForObject(sql, String.class);
	}
	
	public int getCouponCount() {
		String sql = "select count(mobile) from tbl_promotion_coupon cp";
		return jdbcTemplate.queryForInt(sql);
	}

}
