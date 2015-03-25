package com.hackbulgaria.corejava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FaultyProblem9Test {

    @Test
    public void test() {

        assertEquals("/", FaultyProblem9.reduce_file_path("/"));
        assertEquals("/", FaultyProblem9.reduce_file_path("/../"));
        assertEquals("/", FaultyProblem9.reduce_file_path("/../../../../../../../../"));
        assertEquals("/", FaultyProblem9.reduce_file_path("//////////////"));
        assertEquals("/srv/www/htdocs/wtf", FaultyProblem9.reduce_file_path("/srv/www/htdocs/wtf/"));
        assertEquals("/etc/wtf", FaultyProblem9.reduce_file_path("/etc//wtf/"));
        assertEquals("/srv", FaultyProblem9.reduce_file_path("/srv/./"));
        assertEquals("/srv", FaultyProblem9.reduce_file_path("/srv/./asdf/.././ "));
    }

}
