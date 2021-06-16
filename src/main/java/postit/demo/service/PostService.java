package postit.demo.service;

import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import postit.demo.aws.BucketName;
import postit.demo.aws.FileStore;
import postit.demo.model.CommentModel;
import postit.demo.model.PostModel;
import postit.demo.repository.CommentRepository;
import postit.demo.repository.PostRepository;


import java.io.IOException;
import java.util.*;

@Service
public class PostService {

    private final PostRepository postRepository;
    private CommentRepository commentRepository;
    private final FileStore fileStore;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository, FileStore fileStore) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.fileStore = fileStore;
    }


    public List<PostModel> getPosts()
    {
        List<PostModel> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    public void addPost(PostModel postModel, MultipartFile file){

        postRepository.save(postModel);

        if(file !=null) {
            uploadPostImage(postModel.getId(),file);
        }

    }

    public void updatePost(PostModel post){
        postRepository.save(post);
    }

    public Optional<PostModel> getPost(Long id){

        return postRepository.findById(id);
    }
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public void uploadPostImage(Long id, MultipartFile file){

        if(file.isEmpty()){
            throw new IllegalStateException("Cannot upload empty file ["+file.getSize()+"]");
        }


        if(!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(),ContentType.IMAGE_PNG.getMimeType(),ContentType.IMAGE_GIF.getMimeType(),ContentType.IMAGE_SVG.getMimeType()).contains(file.getContentType())){
            throw new IllegalStateException("File must be an image");
        }


        Map<String,String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        PostModel post = postRepository.findById(id).orElseThrow();

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(),post.getId());
        String fileName = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
        try {
            fileStore.save(path,fileName,Optional.of(metadata),file.getInputStream());
            post.setImage(fileName);
            postRepository.save(post);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }


    public byte[] downloadPostImage(Long id){
        PostModel post = postRepository.findById(id).orElseThrow();
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(),post.getId());

        return post.getImage().map(key -> fileStore.download(path,key)).orElse(new byte[0]);

    }

    public List<PostModel> getPostsByUserId(Long id){
        return postRepository.findByUserId(id);
    }
    public List<PostModel> getPostsByCommunityId(Long id){
        return postRepository.findByCommunityId(id);
    }
    public List<CommentModel> getPostComments(Long id){
        return commentRepository.findByPostId(id);
    }


}
