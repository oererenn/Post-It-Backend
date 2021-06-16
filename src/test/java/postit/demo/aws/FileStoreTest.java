package postit.demo.aws;

import com.amazonaws.services.medialive.model.MsSmoothOutputSettings;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.amazonaws.services.s3.AmazonS3;
import org.springframework.web.multipart.MultipartFile;
import postit.demo.model.PostModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class FileStoreTest {
    @Test
    void TestConstructor(){
        AmazonS3 s3 = null;
        FileStore fileStore = new FileStore(s3);
        assertEquals(fileStore.getS3(),s3);

    }


    @Test
    void save() throws IOException {
        AmazonS3 s3 = mock(AmazonS3.class);
        MultipartFile file = mock(MultipartFile.class);
        PostModel postModel = new PostModel();
        Map<String,String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(),postModel.getId());
        String fileName = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
        FileStore fileStore = new FileStore(s3);

        fileStore.save(path,fileName, Optional.of(metadata),file.getInputStream());
        postModel.setImage(fileName);
        assertEquals(postModel.getImage().orElseThrow(),fileName);


    }

    @Test
    void download() {
        AmazonS3 s3 = mock(AmazonS3.class);
        FileStore fileStore = new FileStore(s3);
        PostModel postModel = mock(PostModel.class);
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(),postModel.getId());
        byte [] test = postModel.getImage().map(key -> fileStore.download(path,key)).orElse(new byte[0]);
        assertEquals(0,test.length);

    }

    @Test
    void getS3() {
        AmazonS3 s3 = mock(AmazonS3.class);
        FileStore fileStore = new FileStore(s3);
        AmazonS3 tests3 = fileStore.getS3();
        assertEquals(s3,tests3);
    }
}