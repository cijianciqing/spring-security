package cj.springboot.security.template.util.exceptionHandler.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class CJErrorEntity implements Serializable {

    @NotBlank(message = "cj 不许为空")
    private String name;
    @NotBlank(message = "cj 不许为11空")
    private String path;
}
