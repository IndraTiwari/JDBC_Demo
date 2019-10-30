package com.itctraining.customer.JBDCDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.itctraining.customer.dao.CustomerDao;
import com.itctraining.customer.model.Customer;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
         CustomerDao customerDAO = (CustomerDao)context.getBean("customerDAO");
   //      Customer customer = new Customer(3,"Jhon",24);
     //    customerDAO.insert(customer);
         
         Customer customer1 = customerDAO.findByCustomerId(3);
         System.out.println(customer1.getCustId()+customer1.getName() + customer1.getAge() );
    }
}
