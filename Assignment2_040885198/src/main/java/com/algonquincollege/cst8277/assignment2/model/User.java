/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: User.java
 * Course materials (19F) CST 8277
 * @author (original) Mike Norman
 * 
 * @Author: Jiaying Huang 
 * @Student#: 040885198
 * @modified: 2019/09/30
 */
package com.algonquincollege.cst8277.assignment2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
@Entity
@Table(name="users")
public class User implements Serializable {
    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;

    protected int id;
    //TODO - other member fields
    protected String Student_Name;
    protected int Student_Number;
    protected String college;
    protected String course;
    
    
    // JPA requires the default constructor be present
    public User() {
        super();    
    }

    @Id // JPA will automatically generate the primary key based on IDENTITY column-type
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //TODO - other getters/setters, mappings
    @Column (name="student_Name")
    public String getStudent_Name() {
        return this.Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.Student_Name = student_Name;
    }
    @Column (name="student_Number")
    public int getStudent_Number() {
        return this.Student_Number;
    }

    public void setStudent_Number(int student_Number) {
        this.Student_Number = student_Number;
    }
    @Column (name="college")
    public String getCollege() {
        return this.college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
    @Column (name="course")
    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    
  
 
  

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User)obj;
        if (id != other.id)
            return false;
        return true;
    }
}