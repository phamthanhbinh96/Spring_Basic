package springjdbc.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springjdbc.model.Student;

public class JdbcstudentDAO implements StudentDAO{
    private DataSource dataSource;
    private ApplicationContext context;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public JdbcstudentDAO() {

	}
	//read file csv and insert to database
	public void readFileCSV() {
		String csvFile = "/src/main/resources/Data_SpringBasic.csv";
		
        String line = "";
        String cvsSplitBy = ",";
        

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] data   = line.split(cvsSplitBy);
                context = new ClassPathXmlApplicationContext("bean.xml");
                StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");
                int id = Integer.parseInt(data[0]);
			    String name = data[1];
			    String dateOfBirth = data[2];
			    String gender = data[3];
			    
			    Student student = new Student(id, name, dateOfBirth, gender);
			    studentDAO.insert(student);  
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	//insert student to database
	public void insert(Student student) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO STUDENT " +
				"(ID, Name, BirthOfDate,Gender) VALUES (?, ?, ?,?)";
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, student.getID());
			ps.setString(2, student.getName());
			ps.setString(3, student.getBirthOfDate());
			ps.setString(4, student.getGender());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}	
	}
	
	
	
}
