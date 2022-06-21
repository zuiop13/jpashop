package jpashop.zuiop.service;

import jpashop.zuiop.entity.item.ZuiopItem;
import jpashop.zuiop.repository.ZuiopItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ZuiopItemService {

    private final ZuiopItemRepository zuiopItemRepository;

    @Transactional
    public void save(ZuiopItem zuiopItem) {
        zuiopItemRepository.save(zuiopItem);
    }

    public ZuiopItem findOne(Long id){
        return zuiopItemRepository.findOne(id);
    }

    public List<ZuiopItem> findAll() {
        return zuiopItemRepository.findAll();
    }
}