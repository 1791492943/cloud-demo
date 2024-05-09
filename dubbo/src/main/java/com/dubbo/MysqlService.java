package com.dubbo;

import com.common.domain.FileInfo;

import java.util.List;

public interface MysqlService {

    List<FileInfo> getAll();

}
