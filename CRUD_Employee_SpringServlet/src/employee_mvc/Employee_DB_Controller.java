package employee_mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Employee_DB_Controller {
	
	private Employee_Service empser;
	
	@Autowired
	public void setEmpser(Employee_Service empser) {
		this.empser = empser;
	}

	@RequestMapping(params="insert")
	public ModelAndView insertFunction(@RequestParam("empno") int empno, @RequestParam("deptid") String deptid, @RequestParam("salary") int salary)
	{
		String page = "Employee.jsp";
		
		Emp e = new Emp(empno,deptid,salary);
		
		int z = empser.insertFunction(e);
		
		ModelAndView mv = new ModelAndView();
		
		if(z == 0)
			mv.addObject("msg", "Not Inserted");
		else
			mv.addObject("msg", "Inserted");
		
		mv.setViewName(page); //response
		return mv;
	}
	
	@RequestMapping(params="update")
	public ModelAndView updateFunction(@RequestParam("empno") int empno, @RequestParam("deptid") String deptid, @RequestParam("salary") int salary)
	{
		String page = "Employee.jsp";
		
		Emp e = new Emp(empno,deptid,salary);
		
		int z = empser.updateFunction(e);
		
		ModelAndView mv = new ModelAndView();
		
		if(z == 0)
			mv.addObject("msg", "Not Updated");
		else
			mv.addObject("msg", "Updated");
		
		mv.setViewName(page); //response
		return mv;
	}
	
	@RequestMapping(params="select")
	public ModelAndView selectFunction(@RequestParam("empno") int empno)
	{
		String page = "Employee.jsp";
		
		Emp z = empser.singleSelect(empno);
		
		ModelAndView mv = new ModelAndView();
		
		if(z == null)
			mv.addObject("msg", "Employee not present in DB.");
		else
			mv.addObject("msg", z.toString());
		
		mv.addObject("k1", z.getDeptid());
		mv.addObject("k2", z.getSalary());
		
		mv.setViewName(page); //response
		return mv;
	}
	
	@RequestMapping(params="multiselect")
	public ModelAndView multiFunction(@RequestParam("salary") int salary)
	{
		String page = "Employee.jsp";
		
		String z = empser.multiSelect(salary);
		
		ModelAndView mv = new ModelAndView();
		
		if(z.length() == 0)
			mv.addObject("msg", "Amount is more than enough to Fetch.");
		else
			mv.addObject("val", z);
		
		mv.setViewName(page); //response
		return mv;
	}
	
	@RequestMapping(params="delete")
	public ModelAndView deleteFunction(@RequestParam("empno") int empno)
	{
		String page = "Employee.jsp";
		
		int z = empser.deleteFunction(empno);
		
		ModelAndView mv = new ModelAndView();
		
		if(z == 0)
			mv.addObject("msg", "Not Deleted");
		else
			mv.addObject("msg", "Deleted");
		
		mv.setViewName(page); //response
		return mv;
	}

	
}
