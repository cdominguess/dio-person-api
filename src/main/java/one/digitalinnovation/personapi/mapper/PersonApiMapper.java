package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.PersonRequest;
import one.digitalinnovation.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonApiMapper {
    PersonApiMapper INSTANCE = Mappers.getMapper(PersonApiMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd/MM/yyyy")
    Person toModel(PersonRequest personRequest);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd/MM/yyyy")
    PersonRequest toDTO(Person person);
}
