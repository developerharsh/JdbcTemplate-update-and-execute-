package mypack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DemoBean implements Demo
{
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addData1(User user) throws SQLException {
		
		jdbcTemplate.execute("insert into login values ('"+user.getUserName()+"','"+user.getUserPassword()+"')");
		System.out.println("row inserted");
	}
	public void addData2(User user) throws SQLException 
	{
		Object arr[]={user.getUserName(),user.getUserPassword()};
		int a = jdbcTemplate.update("insert into login values(?,?)",arr);
		System.out.println(a+": row inserted");
	}


}
