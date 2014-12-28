package sistemasb13.tienda;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import sistemasb13.tienda.services.UbigeoService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Nelson on 7/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-web-config.xml")
public class TestApp {

    @Autowired
    private UbigeoService ubigeoService;


    @Before
    @Transactional
    @Rollback(false)
    public void setup()
    {
      
    }

//    @Test
//    @Transactional
    public void testFind()
    {
    	assertEquals(25,ubigeoService.getAllDepartments().size());
    	
    }
    
//    @Test
//    @Transactional
    public void testFind2()
    {
    	assertEquals(7,ubigeoService.getProvinciasByIdDepartment("01").size());
    	
    }
    
    @Test
    @Transactional
    public void testFind3()
    {
    	assertEquals(21,ubigeoService.getDistritosByIdProvinciaAndIdDepartment("01", "01").size());
    	
    }
}

