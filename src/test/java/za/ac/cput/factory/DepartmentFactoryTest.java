package za.ac.cput.factory;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Department;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentFactoryTest {

    private Department department;
    private Department department2;

    @BeforeEach
    public void setUp() {

        department   = DepartmentFactory.getDepartment("2", "IT", "100", "5");
        department2  = DepartmentFactory.getDepartment("4", "Finance", "50", "8");
    }

    @Test
    public void testEquality(){

        //test if the instance variables are as expected
        assertAll("DepartmentFactory",
                ()->assertEquals("2", department.getDepartmentId()),
                ()->assertEquals("IT", department.getDepartmentName()),
                ()->assertEquals("100", department.getDepartmentSize()),
                ()->assertEquals("8", department.getDepartmentFloor()));//fail, actual is 5
    }//end of testEquality method

    @Test
    public void testIdentity(){
        assertSame(department,department2);//failed test, objects are not the same
    }//end of testIdentity method

    @Test
    public void testNull(){

        assertNotNull(department);//object is not null
    }

}