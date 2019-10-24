package com.raindrop.UnitSpring.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/*
 * @Description TODO msqyl的实体类
 * @Author Raindrop
 * @Date 2019/10/24
 */
@Data
@Entity
@Table(name = "account")
public class MysqlDemo implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "uuid")
    private String UUID;
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
