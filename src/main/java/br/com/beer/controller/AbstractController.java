package br.com.beer.controller;

import br.com.beer.dao.DAO;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import br.com.beer.model.AbstractModel;

public abstract class AbstractController<T extends AbstractModel, ID> {

    @Autowired
    private DAO<T, ID> dao;
    private Class<T> itemClass;
    private Collection<T> items;

    public AbstractController() {
    }

    public AbstractController(Class<T> itemClass) {
        this.itemClass = itemClass;
    }


    @RequestMapping(value = "/",method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<T>> list(HttpServletRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        List<T> listAll = dao.findAll();
        if (!listAll.isEmpty()) {
            return new ResponseEntity<List<T>>(listAll, responseHeaders,HttpStatus.ACCEPTED); // 200
        } else {
            return new ResponseEntity<List<T>>(listAll, responseHeaders,HttpStatus.NO_CONTENT); // 204
        }
    }
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)// ,headers="Accept=application/xml, application/json" consumes = "application/json"
    public  T incluir(@RequestBody T entity) {
    	dao.update(entity);
    	return entity;
    }

    @RequestMapping("/{id}")
    public @ResponseBody T load(@PathVariable ID id) {
        return dao.find(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody T update(@RequestBody T entity) throws IOException {
        dao.update(entity);
        return entity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody ID remove(@PathVariable ID id) throws IOException {
        dao.remove(id);
        return id;
    }

    public T mountMyObject(HttpEntity<String> httpEntity) throws IOException {
        return new ObjectMapper().readValue(httpEntity.getBody(), itemClass);
    }

    public DAO<T, ID> getDao() {
        return dao;
    }
}
