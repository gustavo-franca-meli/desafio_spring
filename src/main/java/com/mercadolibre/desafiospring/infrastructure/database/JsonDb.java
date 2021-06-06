package com.mercadolibre.desafiospring.infrastructure.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.desafiospring.domain.exception.RepositoryNotAvailable;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class JsonDb<T> {
    private File file;
    private String resourcesPath;
    private ObjectMapper mapper;
    private TypeReference<List<T>> typeRef;

    public JsonDb(String resourcesPath, TypeReference<List<T>> type) throws RepositoryNotAvailable {
        this.mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        this.mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        this.typeRef = type;
        OpenOrCreateAndOpenFile(resourcesPath);
        this.resourcesPath = resourcesPath;

    }

    private void OpenOrCreateAndOpenFile(String resourcesPath) throws RepositoryNotAvailable {
        var fullResourcePath = "file:src/main/resources/"+resourcesPath+".json";
        try{
            this.file = ResourceUtils.getFile(fullResourcePath);
            if (!this.file.exists())createFile();
        } catch (FileNotFoundException e) {
            try{
                this.file = new File(ResourceUtils.getURL(fullResourcePath).getPath());
            }catch (IOException ioException){
                throw  new RepositoryNotAvailable(ioException.getMessage());
            }
            createFile();
        }

    }

    private void createFile() throws RepositoryNotAvailable {
            try{
                this.file.createNewFile();
                update(new ArrayList<T>());
            }catch (IOException e){
                throw  new RepositoryNotAvailable(e.getMessage());
            }

    }


    public List<T> retrieve() throws RepositoryNotAvailable {
        try {
            return mapper.<List<T>>readValue(file,typeRef);
        } catch (IOException e) {
            try {
                return mapper.readValue(file,typeRef);
            } catch (IOException ioException) {
                ioException.printStackTrace();
                throw new RepositoryNotAvailable("database unavailable");
            }
        }
    }

    public boolean update(List<T> data) throws RepositoryNotAvailable {
        try {
            FileWriter f2 = new FileWriter(file, false);
            var jsonOrder = mapper.writeValueAsString(data);
            System.out.println(jsonOrder);
            f2.write(jsonOrder);
            f2.flush();
            f2.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            throw new RepositoryNotAvailable(e.getMessage());
        }
    }
}
