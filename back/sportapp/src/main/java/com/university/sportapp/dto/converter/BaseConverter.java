package com.university.sportapp.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class BaseConverter<Request, Response, Entity> {
    @Autowired
    private ModelMapper mapper;

    protected abstract Class<Entity> getEntityClass();

    protected abstract Class<Response> getResponseClass();

    public Entity dtoToEntity(Request dto) {
        return mapper.map(dto, getEntityClass());
    }

    public List<Entity> dtoToEntity(List<Request> dtoList) {
        return dtoList.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());
    }

    public Response entityToDto(Entity entity) {
        return mapper.map(entity, getResponseClass());
    }

    public List<Response> entityToDto(List<Entity> entityList) {
        return entityList.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}

