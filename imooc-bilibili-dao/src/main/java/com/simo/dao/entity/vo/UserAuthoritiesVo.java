package com.simo.dao.entity.vo;


import com.simo.dao.entity.auth.AuthRoleElementOperation;
import com.simo.dao.entity.auth.AuthRoleMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserAuthoritiesVo {

    @ApiModelProperty(name = "用户元素操作权限")
    private List<AuthRoleElementOperation> elementOperations;

    @ApiModelProperty(name = "用户菜单操作权限")
    private List<AuthRoleMenu> authRoleMenus;

}
