package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.SportItemDao;
import zjubiomedit.mafld_backend.entity.SportItem;

import java.util.List;

@Service
public class SportItemService {

    @Autowired
    private SportItemDao sportItemDao;

    public List<SportItem> findItemsByType(String type) {
        return sportItemDao.findByType(type);
    }
}