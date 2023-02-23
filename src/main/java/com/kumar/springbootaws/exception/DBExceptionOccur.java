package com.kumar.springbootaws.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DBExceptionOccur extends RuntimeException {
    String message;
}