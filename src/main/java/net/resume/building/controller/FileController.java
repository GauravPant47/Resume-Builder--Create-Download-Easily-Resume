//package net.resume.building.controller;
//
//import java.io.IOException;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import net.resume.building.model.ProfileImageModel;
//import net.resume.building.service.ProfileImageService;
//
//@Controller
//@RequestMapping("/home")
//public class FileController {
//
//	@Autowired
//	private ProfileImageService profileImageService;
//
//	private ProfileImageModel previousImage;
//
//	@GetMapping("/resume")
//	public String showForm(Model model) {
//		if (previousImage != null) {
//			model.addAttribute("image", previousImage.getImage());
//		}
//		return "resume";
//	}
//
//	// This here we can upload a image and show
//
//	@PostMapping("/image")
//	public String submitForm(@RequestParam("image") MultipartFile imageFile, Model model) throws IOException {
//
//		// TODO: Profile Image Model and using the retrieved data and Save Data to
//		// updating
//		ProfileImageModel profileImage = new ProfileImageModel();
//		profileImage.setImage(imageFile.getBytes());
//
//		previousImage = profileImage;
//		profileImageService.saveDatabases(previousImage);
//
//		return "redirect:/home/resume";
//	}
//
//	@GetMapping("/image/{id}")
//	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
//		Optional<ProfileImageModel> optionalImage = profileImageService.getAllById(id);
//		if (optionalImage.isPresent()) {
//			ProfileImageModel imageModel = optionalImage.get();
//
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.IMAGE_JPEG);
//			return new ResponseEntity<>(imageModel.getImage(), headers, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//}
