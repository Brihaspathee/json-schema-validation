package com.example.jsonschemavalidator.web.model;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 18, February 2022
 * Time: 5:30 PM
 * Project: json-schema-validator
 * Package Name: com.example.jsonschemavalidator.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private String name;
    private String socialSecurityNumber;
    private int age;


}
