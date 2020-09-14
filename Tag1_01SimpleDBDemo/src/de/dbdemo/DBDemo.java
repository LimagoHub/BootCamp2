package de.dbdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class DBDemo {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/gothaer";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private static final List<Person> personen = Arrays.asList(new Person("John", "Doe"), new Person("John", "Wanyne"),
			new Person("John", "McClaine"), new Person("John", "Wick"), new Person("John", "Rambo"),
			new Person("John Boy", "Walton"));

	public static void main(String[] args) throws Exception {
		// Class.forName(DRIVER); // Treiber wird in VM geladen

		try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD)) {
			connection.setAutoCommit(false);
//			try(Statement statement = connection.createStatement()) {
////				statement.execute("DROP table IF EXISTS PERSON ");
////				statement.execute("CREATE TABLE person (id int auto_increment PRIMARY KEY, vorname varchar(30), nachname varchar(30) NOT NULL)");
//				
//				for (Person person: personen) {
//					statement.execute(String.format("INSERT INTO Person (vorname,nachname)values('%s','%s')", person.vorname, person.nachname));
//				}
//				
//			}

			try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Person (vorname,nachname)values(?,?)", Statement.RETURN_GENERATED_KEYS)) {
				for (Person person : personen) {
					statement.setString(1, person.vorname);
					statement.setString(2, person.nachname);
					statement.execute();
					try (ResultSet pks = statement.getGeneratedKeys()) {
						if(pks.next()) {
							int pk = pks.getInt(1);
							System.out.println("Pk ist: " + pk);
						}
					}
				}

			}
			
			
			try( Statement statement = connection.createStatement()) {
				try(ResultSet resultSet = statement.executeQuery("SELECT * FROM PERSON")){
					ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
					for(int column = 1; column <= resultSetMetaData.getColumnCount(); column ++) {
						System.out.printf("%-30s", resultSetMetaData.getColumnName(column));
					}
					System.out.println();
					while(resultSet.next()) {
						for(int column = 1; column <= resultSetMetaData.getColumnCount(); column ++) {
							System.out.printf("%-30s", resultSet.getString(resultSetMetaData.getColumnName(column)));
						}
						System.out.println();
					}
				}
			}
			
			connection.commit();

		}

		// connection.close();
		System.out.println("ende");

	}

	static class Person {
		String vorname;
		String nachname;

		public Person(String vorname, String nachname) {
			super();
			this.vorname = vorname;
			this.nachname = nachname;
		}

	}

}
