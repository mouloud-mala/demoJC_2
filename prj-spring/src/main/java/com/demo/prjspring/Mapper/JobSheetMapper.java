package com.demo.prjspring.Mapper;

import com.demo.prjspring.entity.JobSheetEntity;
import com.demo.prjspring.pojo.JobSheet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobSheetMapper {
	
	JobSheet jobSheetEntityToJobSheet(JobSheetEntity entity);
	
	JobSheetEntity jobSheetToJobSheetEntity(JobSheet jobSheet);

}
