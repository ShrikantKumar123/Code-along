package mainapp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("1.Register Here!");
		System.out.println("2.Login");
		int x;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		x=Integer.parseInt(br.readLine());
		//objects
		Registerpojo register= new Registerpojo();
		RegisterDAO registerdao=new RegisterDAO(); 
		Loginpojo login=new Loginpojo();
		LoginDAO logindao=new LoginDAO();
		switch(x){
		case 1:System.out.println("Enter the first name");
			String firstname=br.readLine();
			System.out.println("Enter the last name");
			String lastname=br.readLine();
			System.out.println("Enter the user name");
			String username=br.readLine();
			System.out.println("Enter the password");
			String password=br.readLine();
			System.out.println("Enter the email");
			String email=br.readLine();
			register.setFirstname(firstname);
			register.setLastname(lastname);
			register.setUsername(username);
			register.setPassword(password);
			register.setEmail(email);
			
			registerdao.addUser(register);
			break;
		case 2:
			System.out.println("Enter the user name");
			String name=br.readLine();
			System.out.println("Enter the password");
			String pass=br.readLine();
			login.setUsername(name);
			login.setPassword(pass);
			if(logindao.validate(login)==true) {
				Luck luck=new Luck();
				luck.display();
			}
			else
				System.out.println("Incorrect username/password");
			break;
		}
	}

}
