package io.kodloma.hrms.adapters.concrete;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryManager implements CloudinaryService{
    private Environment environment;
    private final Cloudinary cloudinary;

    @Autowired
    public CloudinaryManager(Environment environment){
        this.environment = environment;



        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", this.environment.getProperty("cloud.name"),
                "api_key", this.environment.getProperty("api.key"),
                "api_secret", this.environment.getProperty("api.secret"),
                "secure", true));
    }

    @Override
    public String url(MultipartFile multipartFile) throws IOException {

        Map<String, String> uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());

        return uploadResult.get("url");
    }
}
