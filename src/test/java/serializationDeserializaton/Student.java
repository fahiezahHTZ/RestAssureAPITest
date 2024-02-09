package serializationDeserializaton;

import java.util.List;

/*
          json format //for this file, we need to create class and obj

          {
              "id" : 101,
              "firstName" : "Paven",
              "lastName" : "Kumar",
              "email" : "abcxyz@gmail.com",
              "courses" : [
                              "java",
                              "Selenium"
                          ]
          }
   */
public class Student {

    int id;
    String firstName;
    String lastName;
    String email;
    List<String> courses; // contain multiple values

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setCourses(List<String> courses){
        this.courses = courses;
    }

    public List<String> getCourses(){
        return courses;
    }

    public String getStudentRecord(){
        return (this.id+" "+this.firstName+" "+this.lastName+" "+
                this.email+" "+this.courses);
    }



}
