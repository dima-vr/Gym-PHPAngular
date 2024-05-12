package com.university.sportapp.controllers;

import com.university.sportapp.dto.converter.BaseConverter;
import com.university.sportapp.services.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
public abstract class BaseController<Request, Response, Entity> {
    protected final BaseService<Entity> baseService;
    protected final BaseConverter<Request, Response, Entity> baseConverter;

    public BaseController(BaseService<Entity> baseService, BaseConverter<Request, Response, Entity> baseConverter) {
        this.baseService = baseService;
        this.baseConverter = baseConverter;
    }

    @GetMapping
    public List<Response> list() {
        List<Entity> entities = baseService.getAll();
        return baseConverter.entityToDto(entities);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Request request) {
        Entity entity = baseConverter.dtoToEntity(request);
        baseService.create(entity);
    }

    @GetMapping("/{id}")
    public Response get(@PathVariable("id") long id) {
        Entity entity = baseService.get(id);
        return baseConverter.entityToDto(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        baseService.delete(id);
    }

    @PutMapping("/{id}")
    public abstract void update(@PathVariable("id") long id, @RequestBody Request request);
}

