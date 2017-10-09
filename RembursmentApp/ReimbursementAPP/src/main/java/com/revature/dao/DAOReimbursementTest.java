/**
 * 
 */
package com.revature.dao;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.model.Reimbursement;

/**
 * @author joshw
 *
 */
public class DAOReimbursementTest {

  private DAOReimbursement reimbDao = new DAOReimbursement();
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void successfulGetReimb() {
    Reimbursement reimb = reimbDao.getReimbursementById(4);
    System.out.println(reimb.toString());
    Assert.assertEquals("test data", reimb.getDescription());
  }
  
//  @Test
//  public void successfulAddReimb() {
//    int result = reimbDao.createReimbursement(1, "some other test data", 1000 );
//    Assert.assertEquals(0, result);
//  }

}
