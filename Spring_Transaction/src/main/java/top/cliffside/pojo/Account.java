package top.cliffside.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cliffside
 * @date 2021-05-15 20:15
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Integer money;
}
