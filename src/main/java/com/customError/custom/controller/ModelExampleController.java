package com.customError.custom.controller;


import com.customError.custom.model.ModelExample;
import com.customError.custom.service.ModelExampleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/model")
public class ModelExampleController {

    private final ModelExampleService modelExampleService;

    public ModelExampleController(ModelExampleService modelExampleService) {
        this.modelExampleService = modelExampleService;
    }

    @PostMapping("/insert")
    public ModelExample insert(@RequestBody ModelExample modelExample) {
        return modelExampleService.insertExample(modelExample);
    }

    @GetMapping("/find/{id}")
    public ModelExample findById(@PathVariable Long id) {
        return modelExampleService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        modelExampleService.deleteModelExample(id);
    }
}
