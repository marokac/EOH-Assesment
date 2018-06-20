
package com.qpoint.Cic;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class mailCicServiceImpl implements mailCicService {
    @Autowired
    mailCicDao cicDaos;

    @Override
    public  mailCic findById(int id) {
        return cicDaos.findById(id);
    }

    @Override
    public List<mailCic> findAllCic(); {
      return cicDaos.findAllBlocks();
    }

    @Override
    public void addCic(mailCic cic) {
      cicDaos.addBlock(cic);
    }

    @Override
    public void deleteCic(int id) {
        cicDaos.deleteBlock(id);
    }

    @Override
    public void updateCic(mailCic cic) {
       cicDaos.updateBlock(cic);
    }

  @Override
    public List<Email> findAllEmail(); {
      return cicDaos.findAllEmail();
    }
}
