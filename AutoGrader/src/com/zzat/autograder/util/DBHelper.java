package com.zzat.autograder.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	private java.sql.Connection con = null;
	private String userName;
	private String password;

	// Constructor
	public DBHelper() {
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	private java.sql.Connection getDBConnection() {
		java.sql.Connection con = null;
		try {
			Class.forName("org.h2.Driver");
			con = java.sql.DriverManager.getConnection(
					"jdbc:h2:tcp://localhost/~/test", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Trace in getConnection() : "
					+ e.getMessage());
		}
		return con;
	}

	/*
	 * Display the driver properties, database details To test connection This
	 * method is used for testing
	 */
	private void displayDbProperties() {

		java.sql.DatabaseMetaData dm = null;
		java.sql.ResultSet rs = null;
		try {
			con = getDBConnection();
			if (con != null) {
				dm = con.getMetaData();
				System.out.println("Driver Information");
				System.out.println("\tDriver Name: " + dm.getDriverName());
				System.out
						.println("\tDriver Version: " + dm.getDriverVersion());
				System.out.println("\nDatabase Information ");
				System.out.println("\tDatabase Name: "
						+ dm.getDatabaseProductName());
				System.out.println("\tDatabase Version: "
						+ dm.getDatabaseProductVersion());
				System.out.println("Avalilable Catalogs ");
				rs = dm.getCatalogs();
				while (rs.next()) {
					System.out.println("\tcatalog: " + rs.getString(1));
				}
				rs.close();
				rs = null;
				closeConnection();
			} else
				System.out.println("Error: No active connection");
		} catch (Exception e) {
			e.printStackTrace();
		}
		dm = null;
	}

	// To close connection
	private void closeConnection() {
		try {
			if (con != null)
				con.close();
			con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// To run update SQL query ( Update, delete )
	public void runUpdateQuery(String sqlQuery) {

		Statement stmt = null;

		java.sql.Connection con = null;
		try {
			con = getDBConnection();
			if (con != null) {

				stmt = con.createStatement();
				stmt.executeUpdate(sqlQuery);
			} else {
				System.out.println("Database error: No active connection.");
			}
		} catch (Exception e) {
			System.out.println("Database error: Exception ocurred.");
		} finally {
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Database error: Exception ocurred.");
			}
		}
	}

	public int runInsertQuery(String sqlQuery) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		int result = -1;
		try {
			connection = getDBConnection();
			statement = connection.prepareStatement(sqlQuery,
					Statement.RETURN_GENERATED_KEYS);

			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(
						"Database error: Failed to execute insert query.");
			}

			generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				result = generatedKeys.getInt(1);
			} else {
				throw new SQLException("Database error: Failed to retrieve ID.");
			}
		} finally {
			if (generatedKeys != null)
				try {
					generatedKeys.close();
				} catch (SQLException logOrIgnore) {
				}
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException logOrIgnore) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException logOrIgnore) {
				}
		}
		return result;
	}

	public int runInsertBulkQuery(String sqlQuery) throws SQLException {
		int result = -1;
		Statement stmt = null;
		java.sql.Connection con = null;
		try {
			con = getDBConnection();
			if (con != null) {

				stmt = con.createStatement();

				result = stmt.executeUpdate(sqlQuery);

				// ResultSetMetaData metaData = rs.getMetaData();

			} else
				System.out.println("Database error: No active connection.");
		} catch (Exception e) {

			System.out.println("Database error: Exception ocurred.");
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Database error: Exception ocurred.");
			}
		}
		return result;
	}

	public ResultSet runFindQuery(String sqlQuery) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			connection = getDBConnection();

			statement = connection.prepareStatement(sqlQuery);
			rs = statement.executeQuery();

		} catch (Exception e) {
			System.out.println("Database error: Exception ocurred.");
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logOrIgnore) {
				}
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException logOrIgnore) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException logOrIgnore) {
				}
		}
		return rs;
	}
}
