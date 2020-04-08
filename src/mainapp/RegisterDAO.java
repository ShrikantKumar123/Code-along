package mainapp;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	public void addUser(Registerpojo register) throws ClassNotFoundException, SQLException {
	String firstname= register.getFirstname();
	String lastname= register.getLastname();
	String username=register.getUsername();
	String password=register.getPassword();
	String email=register.getEmail();
	
	ConnectionManager cm=new ConnectionManager();
	//insert all the details into database
	String sql="insert into USERDETALS(FIRST_NAME,LAST_NAME,USER_NAME,PASSWORD,EMAIL)VALUES(?,?,?,?,?)";
	//Create Statement object
	PreparedStatement st=cm.getConnection().prepareStatement(sql);
	st.setString(1, firstname);
	st.setString(2, lastname);
	st.setString(3, username);
	st.setString(4, password);
	st.setString(5, email);
	st.executeUpdate();
	cm.getConnection().close();
	}
}	
