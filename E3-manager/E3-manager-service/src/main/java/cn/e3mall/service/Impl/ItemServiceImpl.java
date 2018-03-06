package cn.e3mall.service.Impl;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private  TbItemMapper tbItemMapper;

    public TbItem getItemById(long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }
}
