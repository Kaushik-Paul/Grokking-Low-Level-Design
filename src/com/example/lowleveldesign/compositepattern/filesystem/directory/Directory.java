package com.example.lowleveldesign.compositepattern.filesystem.directory;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    private String directoryName;
    private List<FileSystem> fileSystemList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.fileSystemList = new ArrayList<>();
    }

    @Override
    public void ls() {
        System.out.println("Directory name: " + this.directoryName);

        for (FileSystem fileSystem : this.fileSystemList) {
            fileSystem.ls();
        }
    }

    public FileSystem get(int pos) {
        return this.fileSystemList.get(pos);
    }

    public void add(FileSystem fileSystem) {
        this.fileSystemList.add(fileSystem);
    }
}
