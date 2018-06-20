
package com.qpoint.Cic;
import java.util.List;


public interface mailCicDao {
      mailCic findById(int id);

	List<mailCic> findAllCic();

	void addCic(mailCic cic);

	void deleteCic(int id);
	
	void updateCic(mailCic cic); 

	//get all Email to send to
       List<Email> findAllEmail();
}
