package employee_mvc;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class Employee_Service {

	private JdbcTemplate t;

	@Autowired
	public void setT(JdbcTemplate t) {
		this.t = t;
		System.out.println(t);
	}
	
	@Bean
	public JdbcTemplate createObj()
	{
		BasicDataSource b = new BasicDataSource();
		b.setUsername("root");
		b.setUrl("jdbc:mysql://localhost:3306/employee");
		b.setPassword("RU_sh@007");
		b.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		JdbcTemplate jtemp = new JdbcTemplate(b);
		return jtemp;
	}

	public Emp singleSelect(int empno) {
		// TODO Auto-generated method stub

		Emp e = null;
		
		String sql = "Select * from emp where empno = ?";
		
		BeanPropertyRowMapper<Emp> bean = new BeanPropertyRowMapper<Emp>(Emp.class);
		
		Object params[] = { empno };
		
		try 
		{
			e = t.queryForObject(sql, params, bean);	
			System.out.println(e);
		} 
		catch (DataAccessException ex) 
		{
			// TODO Auto-generated catch block
			System.out.println("Employee Number is not found.");
		}		
		return e;
	}

	public String multiSelect(int salary) {
		// TODO Auto-generated method stub
	  String data = new String();
		
		List<Emp> l = new ArrayList<Emp>();

		String sql = "Select * from emp where salary > ?";
		
		BeanPropertyRowMapper<Emp> bean = new BeanPropertyRowMapper<Emp>(Emp.class);
		
		Object params[] = { salary };
		
		try {
			l = t.query(sql,params,bean);
			if( l.size() == 0)
			{
				System.out.println("No items below this price.");
			}
			else
				{
					StringBuilder sb = new StringBuilder();
					for(Emp e : l)
					{	
						sb.append("\n" );
						sb.append(e);
					}
					data = sb.toString();
					System.out.println(sb);
				}
		} catch (DataAccessException ex) {
			// TODO Auto-generated catch block
		System.out.println("Amount is more than enough to fetch.");
		}
		return data;
		
	}
	
	public int insertFunction(Emp e) 
	{
		// TODO Auto-generated method stub
		String sql = "insert into emp(empno,deptid,salary) values (?,?,?)"; // people who make mistake in
		
		Object[] params = { e.getEmpno(),e.getDeptid(),e.getSalary() };
		
		int result = t.update(sql, params);
		
		if(result > 0)
		{
			System.out.println("insert successful.");
		}
		else
		{
			System.out.println("insert fail.");
		}
		return result;
	}
	
	public int updateFunction(Emp e)
	{
		String sql = "Update emp Set deptid = ?, salary = ? where empno = ?"; 
		
		Object[] params = { e.getDeptid(),e.getSalary(),e.getEmpno() };
		
		int result = t.update(sql, params);
		
		if(result > 0)
		{
			System.out.println("Update Successful");
		}
		else
		{
			System.out.println("Update Fail");
		}	
		return result;
	}
	
	public int deleteFunction(int empno)
	{
		String sql = "Delete from emp where empno = ?"; 
		
		Object[] params = { empno };
		
		int result = t.update(sql, params);
		
		if(result > 0)
		{
			System.out.println("Delete Successful");
		}
		else
		{
			System.out.println("Delete Fail");
		}
		return result;
	}
	
}
