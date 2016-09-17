package com.gildedrose;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class RegressionFullOutputTest {
    
    @Test
    public void testFullOutputOver30Days() throws IOException, URISyntaxException {
        URL expectedOutputFileUrl = this.getClass().getClassLoader().getResource("stdout.txt");
        String expectedOutput = new String(Files.readAllBytes(Paths.get(expectedOutputFileUrl.toURI())), "UTF-8");

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        
        TexttestFixture.run(30, new PrintStream(outStream, true, "UTF-8"));
        
        assertThat(outStream.toString()).isEqualTo(expectedOutput);
    }
}
