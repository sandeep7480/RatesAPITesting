package FunctionLibrary;

import java.time.LocalDate;

import org.junit.Assert;

public class ResponseDate {
	
	public void datecheck(String date){
		
		Assert.assertNotNull(date);
		LocalDate today = LocalDate.now();
		LocalDate actualdate = LocalDate.parse(date);
		//System.out.println(actualdate);
		//System.out.println(actualdate.compareTo(today));
		Assert.assertTrue(actualdate.compareTo(today) <= 0);
		
	    
	}

}
