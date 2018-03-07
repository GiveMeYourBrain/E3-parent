package cn.e3mall.service.Impl;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.DataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private  TbItemMapper tbItemMapper;


    public TbItem getItemById(long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult getItemList(int page, int rows) {
        //page当前页 ,rows显示几行
        //pageNum、pageSize、totalRecord、totalPage、startIndex、list、start、end，
        //当前页，每页显示个数，总条数， 总页数，开始索引每页每条信息的id，查询出当页的信息，首页，尾页
        //设置分页信息
        PageHelper.startPage(page ,rows);
        //执行查询  mybati分页插件
        TbItemExample tbItemExample=new TbItemExample();

        List<TbItem> tbItems = tbItemMapper.selectByExample(tbItemExample);
        //取分页信息
        PageInfo<TbItem> tbItempage = new PageInfo<TbItem>(tbItems);
        Long ss=tbItempage.getTotal();
        //创建返回结果对象
        DataGridResult  result=new DataGridResult ();

        result.setTotal(ss);
        result.setRows(tbItems);

        return result;
    }
}
