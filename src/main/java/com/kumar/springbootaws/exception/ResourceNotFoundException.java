package com.kumar.springbootaws.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    String fieldValue;
}