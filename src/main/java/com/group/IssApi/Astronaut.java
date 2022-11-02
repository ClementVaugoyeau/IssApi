package com.group.IssApi;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;


@Entity
@Table (name = "astronauts")
public class Astronaut {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;
    private String nationality;
    
     
     public Astronaut(){

     }
 

    public Astronaut(String name, String role, String nationality) {
        this.name = name;
        this.role = role;
        this.nationality = nationality;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public String getNationality(){
        return this.nationality;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void setNationality(String nationality){
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
          return true;
        if(!(o instanceof Astronaut))
          return false;
       
        Astronaut astronaut = (Astronaut) o;
        return Objects.equals(this.id, astronaut.id) && Objects.equals(this.name, astronaut.name) && Objects.equals(this.role, astronaut.role) 
        && Objects.equals(this.nationality, astronaut.nationality);


    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role, this.nationality);
    }

    @Override
    public String toString() {
        return "Astronaut{" + " id = " + this.id + ", name = " + this.name + "/" + "role = " + this.role + ", nationality = " + this.nationality + "}";
    }


}
