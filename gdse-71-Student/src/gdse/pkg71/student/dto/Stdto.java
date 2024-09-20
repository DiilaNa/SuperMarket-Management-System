/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gdse.pkg71.student.dto;

/**
 *
 * @author dilan
 */
public class Stdto {
    private String studentId;
    private String name;
    private String email;
    private String description;

    public Stdto() {
    }

    public Stdto(String studentId, String name, String email, String description) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Stdto{" + "studentId=" + studentId + ", name=" + name + ", email=" + email + ", description=" + description + '}';
    }
    
    
    
}
