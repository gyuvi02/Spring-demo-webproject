package org.gyula.springdemo.domain.test;

import org.hibernate.validator.constraints.NotBlank;

public class OrganizationRepresentative {

    @NotBlank(message="* First name cannot be blank")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
