package springjdbc.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springjdbc.dao.JdbcstudentDAO;

public class Run {
	private static ApplicationContext context;

	public static void main(String[] args) throws Exception {
		context = new ClassPathXmlApplicationContext("bean.xml");
		JdbcstudentDAO dao = new JdbcstudentDAO();
		dao.readFileCSV();
	}
}
