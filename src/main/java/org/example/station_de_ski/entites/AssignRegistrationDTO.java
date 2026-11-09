package org.example.station_de_ski.entites;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignRegistrationDTO {
    private Long numRegistration;
    private Long numCourse;
    public Long getNumRegistration() {
        return numRegistration;
    }

    public void setNumRegistration(Long numRegistration) {
        this.numRegistration = numRegistration;
    }

    public Long getNumCourse() {
        return numCourse;
    }

    public void setNumCourse(Long numCourse) {
        this.numCourse = numCourse;
    }
}
