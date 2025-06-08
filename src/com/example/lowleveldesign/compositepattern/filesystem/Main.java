package com.example.lowleveldesign.compositepattern.filesystem;

import com.example.lowleveldesign.compositepattern.filesystem.directory.Directory;
import com.example.lowleveldesign.compositepattern.filesystem.directory.File;
import com.example.lowleveldesign.compositepattern.filesystem.directory.FileSystem;

public class Main {

    public static void main(String[] args) {

        Directory movieDirectory = new Directory("Movie");

        FileSystem border = new File("Border");
        movieDirectory.add(border);

        Directory comedyMovieDirectory = new Directory("ComedyMovie");
        File hulchul = new File("Hulchul");
        comedyMovieDirectory.add(hulchul);
        movieDirectory.add(comedyMovieDirectory);

        movieDirectory.ls();

    }
}
