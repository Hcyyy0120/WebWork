package com.hcy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecvOrder {
    private Integer uid;
    private Integer oid;
    private String recvName;
    private String title;
}
