package com.jonas.file.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@XStreamAlias("users")
public class User{
    @XStreamAlias("user_id")
    private Integer id;

    @XStreamAlias("user_name")
    private String name;

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
