package org.lazicats.ecos.internal.wms.dao.impl;


import org.lazicats.ecos.internal.wms.dao.SerialNumberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SerialNumberDaoImpl implements SerialNumberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	//@Transactional
	public int findSerialNumberByName(String serialNumberName) {
		String sql = "select SERIALNUMBER from T_SERIALNUMBER where NAME= ?";
			int num = jdbcTemplate.queryForInt(sql, serialNumberName);
		sql = "update T_SERIALNUMBER set SERIALNUMBER = ? where NAME= ?";
		int num1 = num+1;
		jdbcTemplate.update(sql, new Object[] { num1, serialNumberName });
		return num1;
	}

}
