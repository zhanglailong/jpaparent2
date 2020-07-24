package com.zll.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name= "hg_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer uid;
    private  String username;
    private  String password;
    private  String name;
    private  String email;
    private  String telephone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private  int sex;
    private  int state;
    private  String code;

    @OneToOne(targetEntity = DriverCard.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id",referencedColumnName = "id",insertable = true,updatable = false,nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private DriverCard driverCard;

    @ManyToOne(targetEntity = Depart.class,cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinColumn(name = "depart_id",referencedColumnName = "id",insertable = true,updatable = true,nullable = true,
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private Depart depart;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "uid",insertable = true,updatable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Room> roomList;

    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinTable(name="hg_user_hobby",
            // 本表与中间表的关系 one to many
            joinColumns={@JoinColumn(name = "user_id",referencedColumnName = "uid",foreignKey=@ForeignKey(value = ConstraintMode.NO_CONSTRAINT))},
            // 描述的中间表与目标表的对应关系  many to one
            inverseJoinColumns = {@JoinColumn(name = "hobby_id",referencedColumnName = "id",foreignKey=@ForeignKey(value = ConstraintMode.NO_CONSTRAINT))},
            //唯一约束
            uniqueConstraints={@UniqueConstraint(name="unit",columnNames={"user_id","hobby_id"})}
    )
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Hobby> hobbyList;
}
