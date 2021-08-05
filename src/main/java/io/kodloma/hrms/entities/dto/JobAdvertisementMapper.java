package io.kodloma.hrms.entities.dto;

import io.kodloma.hrms.entities.concrete.JobAdvertisements;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface JobAdvertisementMapper {

    //JobAdvertisementMapper jobAdMapper = Mappers.getMapper(JobAdvertisementMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "workingType", target="workingType")
    @Mapping(source = "workingLocations", target="workingLocations")
    @Mapping(source = "cities", target="cities")
    @Mapping(source = "jobPositions", target="jobPositions")
    @Mapping(source = "description", target="description")
    @Mapping(source = "employers", target = "employers")
    @Mapping(source = "min_salary", target="min_salary")
    @Mapping(source = "max_salary", target="max_salary")
    @Mapping(source = "person_need", target="person_need")
    JobAdvertisements fromDto(JobAdvertisementDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "workingType", target="workingType", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "workingLocations", target="workingLocations", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "cities", target="cities", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "jobPositions", target="jobPositions", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "employers", target = "employers", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "description", target="description", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "min_salary", target="min_salary", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "max_salary", target="max_salary", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "person_need", target="person_need" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JobAdvertisements fromTwoOther(JobAdvertisementDTO dto, @MappingTarget JobAdvertisements jobAdvertisements);

    @InheritInverseConfiguration(name="fromDto")
    JobAdvertisementDTO toDto(JobAdvertisements entity);

}
