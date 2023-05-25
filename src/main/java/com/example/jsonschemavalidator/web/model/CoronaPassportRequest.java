package com.example.jsonschemavalidator.web.model;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 18, February 2022
 * Time: 5:31 PM
 * Project: json-schema-validator
 * Package Name: com.example.jsonschemavalidator.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoronaPassportRequest {

    private Passport passport;
    private Person person;

    @Override
    public String toString() {
        return "CoronaPassportRequest{" +
                "passport=" + passport +
                ", person=" + person +
                '}';
    }
}
