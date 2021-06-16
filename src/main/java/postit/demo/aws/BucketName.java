package postit.demo.aws;

public enum BucketName {
    PROFILE_IMAGE("postit-test-image-upload");

    private final String awsBucketName;

    BucketName(String myBucketName) {
        this.awsBucketName = myBucketName;
    }

    public String getBucketName() {
        return awsBucketName;
    }
}
