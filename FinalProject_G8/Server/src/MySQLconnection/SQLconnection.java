package MySQLconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;

import gui.ServerStartController;
import javafx.collections.ObservableList;
import logic.Order;
import logic.User;

public class SQLconnection {
	private static Connection con;
	private static Statement statement;
	private static ResultSet rs;

	public void connectToDB(String loc, String password, String user) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			System.out.println("Driver definition failed");
			/* handle the error */}

		try {
			con = DriverManager.getConnection(loc, user, password);

			System.out.println("SQL connection succeed");

		} catch (SQLException ex) {
			ServerStartController.flag = false;
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}
	}

	public static String GetUserRole(User u) {
		String query = "SELECT * FROM user WHERE Username=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, u.getUsername());
			rs = ps.executeQuery();
			rs.next();
			String Pass = rs.getString("Password");
			boolean loged = rs.getBoolean("IsLoggedIn");
			if (u.getPassword().equals(Pass)) {
				if (!loged) {
					String r = rs.getString("Role");
					System.out.print("password= " + Pass + " role= " + r);
					ps = con.prepareStatement("update user set IsLoggedIn = ? where Username = ?");
					ps.setBoolean(1, true);
					ps.setString(2, u.getUsername());
					ps.executeUpdate();
					return r;
				}
				else {
					return "You're Already logged in";
				}
			} else {
				return "Wrong Password";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Invalid input";
		}

	}
	public static void GetLogOut(User u) {
		String query = "update user set IsLoggedIn = ? where Username = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setBoolean(1, false);
			ps.setString(2, u.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
