package com.common.domain;

import lombok.Data;

import java.util.Date;

@Data
public class FileInfo {

    private Long id;
    private String name;
    private String path;
    private String type;
    private Long size;
    private Date createTime;
    private Date modifyTime;

}
