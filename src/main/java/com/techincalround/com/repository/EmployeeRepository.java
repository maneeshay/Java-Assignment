/*
 * This class allows us perform logic operations i.e. CRUD operation of employee
 * @author Manisha Yadav
 */
package com.techincalround.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techincalround.com.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
