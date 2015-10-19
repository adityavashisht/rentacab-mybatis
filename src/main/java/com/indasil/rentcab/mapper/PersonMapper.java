package com.indasil.rentcab.mapper;

import com.indasil.rentcab.domain.Person;
import org.apache.ibatis.annotations.Param;

/**
 * Created by vashishta on 10/19/15.
 */
public interface PersonMapper {

    void create(@Param("person") Person person);

    Person read(@Param("id") Long id, @Param("name") String name);

    void update(@Param("person") Person person);

    void delete(Long id);

}
