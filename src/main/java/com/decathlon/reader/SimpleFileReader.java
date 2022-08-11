package com.decathlon.reader;

import com.decathlon.exceptions.FileReaderException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleFileReader implements FileReader {

    @Override
    public List<String> readFile(String filePath) {
        System.out.println("Reading file with path: " + filePath);
        Path path = Paths.get(filePath);
        //what if invalid path
        if (!Files.exists(path) && !Files.isDirectory(path)) {
            return Collections.emptyList();
        }

        try (Stream<String> stream = Files.lines(path)) {
            return stream
                    .filter(Objects::nonNull)
                    .filter(a -> !a.isEmpty())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error in reading file: " + e.getMessage());
            throw new FileReaderException(e.getMessage());
        }
    }
}
