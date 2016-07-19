package com.vincent.SSHProject.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.vincent.SSHProject.model.Department;
import com.vincent.SSHProject.service.DepartmentService;

@Component
public class DepartmentConverter implements Converter<Object, Department>{

    static final Logger logger = LoggerFactory.getLogger(DepartmentConverter.class);
    
    @Autowired
    DepartmentService departmentService;
    
	@Override
	public Department convert(Object element) {
		// TODO Auto-generated method stub
        Integer id = Integer.parseInt((String)element);
        Department department = departmentService.findById(id);
        logger.info("Department : {}",department);
        return department;
	}

}
