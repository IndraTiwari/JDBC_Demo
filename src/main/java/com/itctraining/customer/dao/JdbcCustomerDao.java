package com.itctraining.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.itctraining.customer.model.Customer;

public class JdbcCustomerDao implements CustomerDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "insert into customer" + "(CUST_ID, NAME, AGE)values(?,?,?)";

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}

	}

	public Customer findByCustomerId(int custId) {
		// TODO Auto-generated method stub
		String sql = "select * from customer where CUST_ID = ?";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				customer = new Customer(rs.getInt("CUST_ID"),
						rs.getString("NAME"), 
						rs.getInt("Age"));
			}
			rs.close();
			ps.close();
			
			return customer;
		}
		catch (SQLException e) {
			throw new RuntimeException (e);
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {}
			}
		}
//		return null;
	}

}
