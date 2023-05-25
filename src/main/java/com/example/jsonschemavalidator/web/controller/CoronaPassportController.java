package com.example.jsonschemavalidator.web.controller;

import com.example.jsonschemavalidator.web.model.CoronaPassportRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 18, February 2022
 * Time: 5:42 PM
 * Project: json-schema-validator
 * Package Name: com.example.jsonschemavalidator.web.controller
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequestMapping("/corona/passport")
public class CoronaPassportController {

    @PostMapping("/novalidation")
    public CoronaPassportRequest createPassport(@RequestBody CoronaPassportRequest coronaPassportRequest){
        log.info("Request:{}", coronaPassportRequest);
        return coronaPassportRequest;
    }

    @PostMapping("/withvalidation")
    public ResponseEntity<CoronaPassportRequest> createPassportValidation(@RequestBody String requestStr) throws JsonProcessingException {
        log.info("Request json string:{}", requestStr);
        InputStream schemaAsStream = CoronaPassportController.class.getClassLoader().getResourceAsStream("model/coronapassport.schema.json");
        JsonSchema schema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909).getSchema(schemaAsStream);
        ObjectMapper om = new ObjectMapper();
        JsonNode jsonNode = om.readTree(requestStr);
        Set<ValidationMessage> errors = schema.validate(jsonNode);
        String errorsCombined = "";
        for(ValidationMessage validationMessage : errors){
            log.error("Validation Error:{}", validationMessage);
            errorsCombined += validationMessage.toString() + "\n";
        }
        if(errors.size() > 0){
            throw new RuntimeException("Please fix your JSON: " + errorsCombined);
        }
        CoronaPassportRequest coronaPassportRequest = om.readValue(requestStr, CoronaPassportRequest.class);
        return ResponseEntity.ok(coronaPassportRequest);
    }
}
