package top.cliffside.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-13 15:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
    private Integer pid;
    private String pname;
    private Integer money;

    // 组合一个ProjectRecord对象集合作为属性
    private List<ProjectRecord> projectRecords;

}
