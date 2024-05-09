package com.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import domain.FileInfo;
import com.demo.service.FileService;
import com.demo.mapper.FileMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【file】的数据库操作Service实现
* @createDate 2024-04-26 09:34:35
*/
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, FileInfo> implements FileService{

}




