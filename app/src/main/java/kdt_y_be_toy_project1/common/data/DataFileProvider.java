package kdt_y_be_toy_project1.common.data;

import kdt_y_be_toy_project1.itinerary.type.FileType;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@AllArgsConstructor
public abstract class DataFileProvider {
  private final static String RESOURCE_PATH = "/src/main/resources";
  protected String domainPath;
  protected String baseName;

  public final File getDataFile(int tripId, FileType fileType) {
    String format = switch (fileType) {
      case JSON -> "json";
      case CSV -> "csv";
    };

    try {
      Path resourceDirPath = Path.of(System.getProperty("user.dir"), RESOURCE_PATH);

      Path domainDirPath = Path.of(resourceDirPath.toString(), domainPath);
      if (!domainDirPath.toFile().exists()) {
        Files.createDirectories(domainDirPath);
      }

      Path dataFileDirPath = Path.of(domainDirPath.toString(), format);
      if (!dataFileDirPath.toFile().exists()) {
        Files.createDirectories(dataFileDirPath);
      }

      Path dataFilePath = Path.of(dataFileDirPath.toString(), baseName + "_" + tripId + "." + format);
      return dataFilePath.toFile();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
