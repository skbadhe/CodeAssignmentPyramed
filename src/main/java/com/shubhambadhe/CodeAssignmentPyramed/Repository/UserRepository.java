/**
 * 
 */
package com.shubhambadhe.CodeAssignmentPyramed.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shubhambadhe.CodeAssignmentPyramed.User.User;

/**
 * @author Shubham
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
