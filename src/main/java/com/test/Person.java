package com.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data

//@EqualsAndHashCode(of = {"lastName"}) equals хэшкод только lastName
//@EqualsAndHashCode(exclude = {"lastName"}) equals хэшкод всего, кроме lastName
@AllArgsConstructor

@Accessors (chain = true) //позволяет методу возвращать объект, через точку перечислять атрибуты Person, типа Person.firstName и т д
@XmlRootElement (name = "people")
@XmlAccessorType(XmlAccessType.FIELD) //доступ (десериализация) по полям, а не по гетерам

// Мапперы для перезаписи элементов для джейсона и для хмл. Показывают название поля(атрибута), из которого брать элементы в xml/json
//    @XmlElement (name = "firstName") or @JsonProperty("firstName")
//    @XmlRootElement (name  = "people") or @JsonRootName("person")

public class Person {

    @XmlElement (name = "firstName") //добавляет только тогда, когда нужно перезаписать поле. Пример в Car с нижним подчеркиванием
    private String firstName;
    @XmlElement (name = "lastName")
    private String lastName;
    @XmlElement (name = "id")
    private int id;
    @XmlElement (name = "email")
    private String email;



    public Person() {

    }
}
