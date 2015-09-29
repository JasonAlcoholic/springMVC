package com.zw.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity(name="user")
public class User implements Serializable {  
  
    private static final long serialVersionUID = -5785857960597910259L;  
    @Id
    @GeneratedValue(generator = "generator")  
    @GenericGenerator(name = "generator", strategy = "uuid")
    @Column(name="id")
    private String id; 
    
    @Column(name="name",length=32)
    private String name;
    
    @Column(name="age")
    private int age;  
    
    public User(String id, String name, int age) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.age = age;  
    }  
    
    public User() {
	}

	public String getId() {  
        return id;  
    }  
  
    public void setId(String id) {  
        this.id = id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
      
    public String toString() {  
        Map<String, String> map = new HashMap<String, String>();  
        map.put("id", id);  
        map.put("name", name);  
        map.put("age", String.valueOf(age));  
        return map.toString();  
    }  
}  