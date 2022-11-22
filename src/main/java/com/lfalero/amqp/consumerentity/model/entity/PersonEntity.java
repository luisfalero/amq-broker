package com.lfalero.amqp.consumerentity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
}
