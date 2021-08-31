package com.beibei.service.impl;

import com.beibei.entity.BeibeiUser;
import com.beibei.mapper.BeibeiUserMapper;
import com.beibei.service.IBeibeiUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户主表 服务实现类
 * </p>
 *
 * @author linxy
 * @since 2021-08-31
 */
@Service
public class BeibeiUserServiceImpl extends ServiceImpl<BeibeiUserMapper, BeibeiUser> implements IBeibeiUserService {

}
