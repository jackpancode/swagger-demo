package com.besti.swaggerdemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Jack Pan
 * @version 1.0 2020/11/29
 */
@ApiModel("用户实体类")
public class User {

    @ApiModelProperty("用户名")
    public String username;

    @ApiModelProperty("密码")
    public String password;



}
