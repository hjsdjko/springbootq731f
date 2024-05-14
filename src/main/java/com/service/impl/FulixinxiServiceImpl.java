package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FulixinxiDao;
import com.entity.FulixinxiEntity;
import com.service.FulixinxiService;
import com.entity.vo.FulixinxiVO;
import com.entity.view.FulixinxiView;

@Service("fulixinxiService")
public class FulixinxiServiceImpl extends ServiceImpl<FulixinxiDao, FulixinxiEntity> implements FulixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FulixinxiEntity> page = this.selectPage(
                new Query<FulixinxiEntity>(params).getPage(),
                new EntityWrapper<FulixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FulixinxiEntity> wrapper) {
		  Page<FulixinxiView> page =new Query<FulixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FulixinxiVO> selectListVO(Wrapper<FulixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FulixinxiVO selectVO(Wrapper<FulixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FulixinxiView> selectListView(Wrapper<FulixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FulixinxiView selectView(Wrapper<FulixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
