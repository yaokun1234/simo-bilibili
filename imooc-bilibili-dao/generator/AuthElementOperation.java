package generator.;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 权限控制--页面元素操作表
* @TableName t_auth_element_operation
*/
public class AuthElementOperation implements Serializable {

    /**
    * 主键id
    */


    
    @ApiModelProperty("主键id")
    
    private String id;
    /**
    * 页面元素名称
    */
    
    @ApiModelProperty("页面元素名称")
    
    private String elementname;
    /**
    * 页面元素唯一编码
    */
    
    @ApiModelProperty("页面元素唯一编码")
    
    private String elementcode;
    /**
    * 操作类型：0可点击  1可见
    */
    
    @ApiModelProperty("操作类型：0可点击  1可见")
    
    private String operationtype;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createtime;
    /**
    * 更新时间
    */
    @ApiModelProperty("更新时间")
    private Date updatetime;

    /**
    * 主键id
    */
    private void setId(String id){
    this.id = id;
    }

    /**
    * 页面元素名称
    */
    private void setElementname(String elementname){
    this.elementname = elementname;
    }

    /**
    * 页面元素唯一编码
    */
    private void setElementcode(String elementcode){
    this.elementcode = elementcode;
    }

    /**
    * 操作类型：0可点击  1可见
    */
    private void setOperationtype(String operationtype){
    this.operationtype = operationtype;
    }

    /**
    * 创建时间
    */
    private void setCreatetime(Date createtime){
    this.createtime = createtime;
    }

    /**
    * 更新时间
    */
    private void setUpdatetime(Date updatetime){
    this.updatetime = updatetime;
    }


    /**
    * 主键id
    */
    private String getId(){
    return this.id;
    }

    /**
    * 页面元素名称
    */
    private String getElementname(){
    return this.elementname;
    }

    /**
    * 页面元素唯一编码
    */
    private String getElementcode(){
    return this.elementcode;
    }

    /**
    * 操作类型：0可点击  1可见
    */
    private String getOperationtype(){
    return this.operationtype;
    }

    /**
    * 创建时间
    */
    private Date getCreatetime(){
    return this.createtime;
    }

    /**
    * 更新时间
    */
    private Date getUpdatetime(){
    return this.updatetime;
    }

}
