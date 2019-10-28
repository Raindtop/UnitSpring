package com.raindrop.UnitSpring.Model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/*
 * @Description TODO msqyl的实体类
 * @Author Raindrop
 * @Date 2019/10/24
 */
@Data
//@Builder
@Entity
@Table(name = "account")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class MysqlDemo implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "uuid")
    private String uuid;
    /**
     * 姓名
     */
    @Column(name = "name", columnDefinition = "varchar(255)")
    private String name;
    /**
     * 年龄
     */
    @Column(name = "age", columnDefinition = "int")
    private String age;
    /**
     * 性别
     */
    @Column(name = "sex", columnDefinition = "varchar(255)")
    private String sex;
    /**
     * 出生日期
     */
    @Column(name = "birthday", columnDefinition = "varchar(255)")
    private String birthday;
}
