package io.kodloma.hrms.adapters.concrete;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {
    String url(MultipartFile multipartFile) throws IOException;
}
