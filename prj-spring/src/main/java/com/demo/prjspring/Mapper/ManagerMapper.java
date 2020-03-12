package com.demo.prjspring.Mapper;

import com.demo.prjspring.entity.ManagerEntity;
import com.demo.prjspring.pojo.Manager;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

    Manager ManagerEntityToManager(ManagerEntity entity);

    ManagerEntity ManagerToManagerEntity(Manager manager);

}
