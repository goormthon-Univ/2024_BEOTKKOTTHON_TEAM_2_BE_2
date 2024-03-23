package muckkitlist_spring.muckkitlist_spring.controller;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import muckkitlist_spring.muckkitlist_spring.service.S3Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
public class ImageUploadController {

    private final S3Uploader s3Uploader;

    @Autowired
    public ImageUploadController(S3Uploader s3Uploader) {
        this.s3Uploader = s3Uploader;
    }

    @PostMapping(value = "/image/group/upload/{muckatId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "Upload group image", notes = "Uploads an image for a group identified by its muckatId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Image uploaded successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public String uploadGroupImage(@RequestParam("file") MultipartFile file, @RequestParam String muckatId) {
        try {
            // 디렉토리명은 여기에 입력하세요.
            String directoryName = "/cat"; // 예시 디렉토리명
            return s3Uploader.uploadGroup(file, directoryName, muckatId);
        } catch (IOException e) {
            e.printStackTrace(); // 적절한 예외 처리를 수행하세요.
            return "Failed to upload image";
        }
    }

    @PostMapping(value = "/image/personal/upload/{reviewId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "Upload personal image", notes = "Uploads an image for a personal review identified by its reviewId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Image uploaded successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public String uploadPersonalImage(@RequestParam("file") MultipartFile file, @RequestParam String reviewId) {
        try {
            // 디렉토리명은 여기에 입력하세요.
            String directoryName = "/cat"; // 예시 디렉토리명
            return s3Uploader.uploadPersonal(file, directoryName, reviewId);
        } catch (IOException e) {
            e.printStackTrace(); // 적절한 예외 처리를 수행하세요.
            return "Failed to upload image";
        }
    }
}

