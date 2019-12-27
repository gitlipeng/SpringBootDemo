package com.example.demo.mappper;

import com.example.demo.entity.Person;
import tk.mybatis.mapper.common.Mapper;
public interface PersonMapper  extends Mapper<Person> {
    void addPerson();
}
