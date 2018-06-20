
package com.qpoint.Cic;

import java.util.List;


public interface mailCicService {
   
      mailCic findById(int id);

	List<mailCic> findAllCic();

	void addCic(mailCic cic);

	void deleteCic(int id);
	
	void updateCic(mailCic cic);
	//get all emails
	 List<Email> findAllEmail();
}
