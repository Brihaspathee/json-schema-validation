package com.example.jsonschemavalidator.web.model;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 18, February 2022
 * Time: 5:28 PM
 * Project: json-schema-validator
 * Package Name: com.example.jsonschemavalidator.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    private Boolean vaccinationProcessBegun;
    private Boolean vaccinationProcessEnded;
    private Boolean testedNegative;
    private String testDate;
    private Boolean hasBeenSickWithCorona;

    @Override
    public String toString() {
        return "Passport{" +
                "vaccinationProcessBegun=" + vaccinationProcessBegun +
                ", vaccinationProcessEnded=" + vaccinationProcessEnded +
                ", testedNegative=" + testedNegative +
                ", testDate='" + testDate + '\'' +
                ", hasBeenSickWithCorona=" + hasBeenSickWithCorona +
                '}';
    }
}
