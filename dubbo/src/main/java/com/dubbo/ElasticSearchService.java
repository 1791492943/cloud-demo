package com.dubbo;

import com.common.domain.FileInfo;

import java.io.IOException;
import java.util.List;

public interface ElasticSearchService {

    List<FileInfo> search(String name) throws IOException;

}
