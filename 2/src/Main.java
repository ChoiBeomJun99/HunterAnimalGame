import java.sql.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection cnt = null;
		Statement stat = null;
		
		try {
			// Class Load
			Class.forName("org.sqlite.JDBC");
			System.out.println("Find org.sqlite.JDBC");		
		}
		catch (ClassNotFoundException e){
			System.out.println("Can't find org.sqlite.JDBC");
			System.err.println(e.getMessage());
		}
		
		try {
			// create a database connection
	        cnt = DriverManager.getConnection("jdbc:sqlite:test.db");
	        stat = cnt.createStatement();
	        stat.setQueryTimeout(30);  // set timeout to 30 sec.
	        
	        // use update
//	        stat.executeUpdate("drop table if exists animalList");
//	        stat.executeUpdate("create table animalList (name string, species string, price int )");
//	        stat.executeUpdate("insert into animalList values('熱團檜', '膩模', 5000)");
//	        stat.executeUpdate("insert into animalList values('熱綴檜', '罹辦', 5000)");
	        
	        // use query
	        ResultSet rs = stat.executeQuery("select * from animalList");
	        while(rs.next())
	        {
	          // read the result set
	        	System.out.println("name = " + rs.getString("name"));
	        	System.out.println("species = " + rs.getString("species"));
	        	System.out.println("price = " + rs.getString("price"));	          
	        }
		}
		catch(SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
	        System.err.println(e.getMessage());			
		}
		finally {
			try {
				if(cnt != null)
					cnt.close();
			}
			catch(SQLException e) {
				// connection close failed
				System.err.println(e.getMessage());
			}
		}

	}

}
