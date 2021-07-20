package io.kodloma.hrms.adapters.concrete;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudinaryService<T> {
    String url(MultipartFile multipartFile) throws IOException;
}
