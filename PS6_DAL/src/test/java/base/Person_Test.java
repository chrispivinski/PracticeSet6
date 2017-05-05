package base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		PersonDomainModel per2 = new PersonDomainModel();
		per2.setFirstName("Jim");
		per2.setLastName("Smith");
		per2.setStreet("8 Ivy Lane"); 
		per2.setPostalCode(19952);
		per2.setCity("Harrington");
		per2.setBirthday(new Date());
		 
		PersonDAL.addPerson(per2); 
		
		PersonDomainModel per3 = PersonDAL.getPerson(per2.getPersonID());
		
		assertNotNull(per3);
	} 

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	//	PersonDAL.deletePerson(perID);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	//	PersonDAL.deletePerson(per2.getPersonID());
	}

	
	@Test
	public void TestGetAllPersons()
	{
		ArrayList<PersonDomainModel> pers = PersonDAL.getPersons();
		assertNotNull(pers);
	}
	
	
	@Test
	public void AddGetUpdateDeletePerson() {
		PersonDomainModel per1 = new PersonDomainModel();
		per1.setBirthday(new Date(0));
		per1.setCity("Townsend");
		per1.setFirstName("Bert");
		per1.setLastName("Gibbons");
		per1.setPostalCode(19734);
		per1.setStreet("214 Labrador Lane");
		
		PersonDAL.addPerson(per1); 
		
		PersonDomainModel per4 = PersonDAL.getPerson(per1.getPersonID());
		
		assertEquals(per1.getPersonID(), per4.getPersonID());
		
		per4.setCity("Harrington");
		PersonDAL.updatePerson(per4);
		
		PersonDomainModel per5 = PersonDAL.getPerson(per1.getPersonID());
		
		assertEquals(per4.getCity(), per5.getCity());
		assertNotEquals(per1.getCity(),per5.getCity());
		
		PersonDAL.deletePerson(per1.getPersonID());
		assertNull(per1);
		
		PersonDAL.getPerson(per1.getPersonID());
		assertNotNull(per1);
		
		
		
	}

	private void assertNotEquals(String city, String city2) {
		// TODO Auto-generated method stub
		
	}
	
	/*public void UpdatePerson() {
		PersonDomainModel per4 = PersonDAL.getPerson()
	}*/

}
