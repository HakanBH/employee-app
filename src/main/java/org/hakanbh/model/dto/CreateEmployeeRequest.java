package org.hakanbh.model.dto;

import lombok.Data;

@Data
public class CreateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String department;
}
