/**
 * 
 */
package com.shubhambadhe.CodeAssignmentPyramed.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shubhambadhe.CodeAssignmentPyramed.Login.Login;

/**
 * @author Shubham
 *
 */
@Repository
public interface LoginRepository extends CrudRepository<Login, String>{

}
