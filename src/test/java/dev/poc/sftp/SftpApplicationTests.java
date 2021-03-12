package dev.poc.sftp;


import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@TestPropertySource(properties = { "sftp.port = 22" })
public class SftpApplicationTests {

    @Autowired
    private SftpConfig.UploadGateway gateway;

//	@Value("C:\\GM\\projects\\sftp\\src\\test\\java\\dev\\poc\\sftp")
//	private  Path sftpFolder;

    @Value("C:\\GM\\projects\\sftp\\sftp-inbound")
    private String localDirectoryDownload;

    @BeforeClass
    public static void startServer() throws Exception {

    }

    @Before
    @After
    public void cleanSftpFolder() throws IOException {
        //Files.walk(sftpFolder).filter(Files::isRegularFile).map(Path::toFile).forEach(File::delete);
    }

    @Test
    public void testUpload() throws IOException {

        gateway.upload(new File("C:\\GM\\projects\\sftp\\src\\test\\java\\dev\\poc\\sftp\\bar.txt"));

    }


    @Test
    public void testDownload() throws IOException, InterruptedException, ExecutionException, TimeoutException {

    }

    @AfterClass
    public static void stopServer() {

    }

}
