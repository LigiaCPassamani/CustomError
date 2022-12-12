package com.customError.custom.service;

import com.customError.custom.model.ModelExample;
import com.customError.custom.repository.ModelExampleRepository;
import com.customError.custom.service.exception.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModelExampleService {

    private final ModelExampleRepository modelExampleRepository;

    public ModelExampleService(ModelExampleRepository modelExampleRepository) {
        this.modelExampleRepository = modelExampleRepository;
    }

    public ModelExample insertExample(ModelExample object) {
        return modelExampleRepository.save(object);
    }

    public ModelExample findById(Long id) {
        Optional<ModelExample> object = modelExampleRepository.findById(id);
        if (object.isPresent()) {
            return object.get();
        } else {
            throw new ObjectNotFoundException("Object Not Found! Id: " + id + "  " + ModelExample.class.getSimpleName());
        }
    }

    public void deleteModelExample(Long id) {
        findById(id);
        try {
            modelExampleRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("It's not possible delete this ModelExample.");
        }
    }
}
