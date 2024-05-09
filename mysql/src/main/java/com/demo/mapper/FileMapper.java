package com.demo.mapper;

import domain.FileInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【file】的数据库操作Mapper
* @createDate 2024-04-26 09:34:35
* @Entity generator.domain.File
*/
@Mapper
public interface FileMapper extends BaseMapper<FileInfo> {

}




