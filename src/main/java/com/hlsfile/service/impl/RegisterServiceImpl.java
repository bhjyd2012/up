package com.hlsfile.service.impl;

import com.hlsfile.bean.Register;
import com.hlsfile.mapper.RegisterMapper;
import com.hlsfile.service.RegisterService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hucheng
 * @since 2019-11-06
 */
@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register> implements RegisterService {

}
