package help;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import help.model.Address;
import help.model.Car;
import help.model.Driver;
import help.model.Key;
import help.model.Manufacturer;

@SpringBootApplication
@ServletComponentScan
@Component 
public class AppOdata2Jpa implements InitializingBean
{
	@Autowired
	private EntityManagerFactory emf;
	
	public static void main(String[] args)
	{
		SpringApplication.run(AppOdata2Jpa.class, args);
	}
	
	void init()
	{
		EntityManager em = emf.createEntityManager();
		List<Car> cars = new ArrayList<Car>();
		Calendar mfDate = Calendar.getInstance();
		mfDate.set(2013, 02, 01);
		Address address = new Address("S1", "C1", "Z1", "CN");

		Manufacturer mf = new Manufacturer(1, "SuperCar", mfDate, address, cars);

		Calendar bDate = Calendar.getInstance();
		mfDate.set(1980, 02, 19);
		Driver driver = new Driver(1L, "Speeder", "Super", "Bolt", null, bDate);

		Key key = new Key(1, 2);
		Calendar carDate = Calendar.getInstance();
		carDate.set(2014, 02, 20);
		Car car = new Car(key, "M1", 20000.0, 2014, carDate.getTime(), mf,
				driver);
		cars.add(car);
		driver.setCar(car);

		em.getTransaction().begin();
		em.persist(mf);
		em.persist(driver);
		em.persist(car);
		em.getTransaction().commit();

	}


	@Override
	public void afterPropertiesSet() throws Exception
	{
		init();
		
	}
}
