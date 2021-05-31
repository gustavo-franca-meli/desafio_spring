package com.mercadolibre.desafiospring.infrastructure.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class JsonDb<T> {
    private File file;
    private String resourcesPath;
    private ObjectMapper mapper;
    private TypeReference<List<T>> typeRef;

    public JsonDb(String resourcesPath) throws IOException {
        OpenOrCreateAndOpenFile(resourcesPath);
        this.resourcesPath = resourcesPath;
        this.mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        this.mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        this.typeRef =  new TypeReference<>() {};
    }

    private void OpenOrCreateAndOpenFile(String resourcesPath) throws IOException {
        var fullResourcePath = "file:src/main/resources/"+resourcesPath+".json";
        try{
            this.file = ResourceUtils.getFile(fullResourcePath);
        } catch (FileNotFoundException e) {
            this.file = new File(ResourceUtils.getURL(fullResourcePath).getPath());
              file.createNewFile();
        }

    }


    public List<T> retrieve() throws Exception {
        try {
            return mapper.readValue(file,typeRef);
        } catch (IOException e) {
            try {
                return mapper.readValue(file,typeRef);
            } catch (IOException ioException) {
                throw new Exception("database unavailable");
            }
        }
    }

    public boolean update(List<T> data) throws IOException {
        FileWriter f2 = new FileWriter(file, false);
        var jsonOrder = mapper.writeValueAsString(data);
        System.out.println(jsonOrder);
        f2.write(jsonOrder);
        f2.flush();
        f2.close();
        return true;
    }
}
