package io.kodloma.hrms.adapters.concrete;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.kodloma.hrms.entities.concrete.Resumes;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryManager implements CloudinaryService<Resumes>{
    @Override
    public String url(MultipartFile multipartFile) throws IOException {

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dnz8o7ktp",
                "api_key", "413266337914377",
                "api_secret", "_cahTSnVzQEAe2xWnUlPGpsMidY",
                "secure", true));

        Map<String, String> uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());

        return uploadResult.get("url");
    }
}
