package com.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@XmlRootElement(name = "cars")
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD) //доступ (десериализация) по полям, а не по гетерам

public class Car {

    @XmlElement(name = "car_name")
    private String carName;
    @XmlElement (name = "car_speed")
    private String carSpeed;

    public Car () {

    }
}
