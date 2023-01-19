package com.org.leetstats.services;

import com.org.leetstats.configs.Appconfig;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class FileService {

    private final Appconfig appconfig;

    private Path codesPath;
    private Path notesPath;

    @PostConstruct
    private void createDirectory() throws IOException {
        codesPath = Paths.get(appconfig.getCodeDirectory()).toAbsolutePath().normalize();
        notesPath = Paths.get(appconfig.getNotesDirectory()).toAbsolutePath().normalize();

        try {
            Files.createDirectory(codesPath);
            Files.createDirectory(notesPath);
        }
        catch(FileAlreadyExistsException ex){
            log.info("Files are already created");
        }
    }


    public String createNotes(String text) throws IOException {
        UUID uuid = UUID.randomUUID();
        Path target = notesPath.resolve(uuid.toString());
        Files.writeString(target, text);

        return target.toString();
    }

    public String createCodes(String text) throws IOException {
        UUID uuid = UUID.randomUUID();
        Path target = codesPath.resolve(uuid.toString());
        Files.writeString(target, text);
        return target.toString();
    }




}
