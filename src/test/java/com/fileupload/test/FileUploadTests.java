package com.fileupload.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import com.fileupload.controller.RestUploadController;
 
public class FileUploadTests {
 
private MockMvc mockMvc;
RestUploadController restUploadController;
 
@Rule
public TemporaryFolder folder = new TemporaryFolder();
 
@Before
public void setUp() throws Exception {
String uploadPath = folder.getRoot().getAbsolutePath();
restUploadController=new RestUploadController();
}
 
@Test
public void uploadFile() throws Exception {
	
MockMultipartFile file = new MockMultipartFile("file", "hello.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, World!".getBytes());
	restUploadController.uploadFile(file);
	assertThat(folder.getRoot().toPath().resolve("hello.txt")).exists();

}
}