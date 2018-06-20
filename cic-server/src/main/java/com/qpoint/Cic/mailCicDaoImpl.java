
package com.qpoint.Cic;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class mailCicDaoImpl implements mailCicDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public mailCic findById(int id) {
       mailCic cic = (mailCic) sessionFactory.getCurrentSession().get(mailCic.class, id);
		   return cic;
    }

    @Override
    public List<mailCic> findAllCic() {
      return sessionFactory.getCurrentSession().createQuery("from mailCic m order by m.CicId desc").list();    
    }

    @Override
    public void addCic(mailCic cic); {
      sessionFactory.getCurrentSession().save(cic);  
    }

    @Override
    public void deleteCic(int id) {
         mailCic cic = (mailCic) sessionFactory.getCurrentSession().load(mailCic.class, id); 
        if (null != cic) {
            sessionFactory.getCurrentSession().delete(cic);
        }  
    }

    @Override
    public void updateCic(mailCic cic) {
     sessionFactory.getCurrentSession().update(cic);
    }
   @Override
    public List<Email> findAllEmail(){
      return sessionFactory.getCurrentSession().createQuery("from Email e order by e.EmailId desc").list();  
    }
    
  //     mailCic findById(int id);

	// List<mailCic> findAllCic();

	// void addCic(mailCic cic);

	// void deleteCic(int id);
	
	// void updateCic(mailCic cic); 
}
