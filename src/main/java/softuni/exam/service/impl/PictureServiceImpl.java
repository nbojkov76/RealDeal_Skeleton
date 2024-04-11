package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Dto.PicturesSeedDto;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
private static final String PICTURES_READ_FILES ="src/main/resources/files/json/pictures.json";
    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    private final CarService carService;

    private final Gson gson;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidationUtil validationUtil, CarService carService, Gson gson) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.carService = carService;

        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURES_READ_FILES));
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder sb = new StringBuilder();
         Arrays.stream(gson.fromJson(readPicturesFromFile(), PicturesSeedDto[].class))
                 .filter(picturesSeedDto -> {
                     boolean isValid = validationUtil.isValid(picturesSeedDto);
                     sb.append(isValid ?
                             String.format("Successfully import picture - %s", picturesSeedDto.getName()):
                             "Invalid pictures").append(System.lineSeparator());


                        return isValid;
                 }).map(picturesSeedDto -> {
                     Picture picture = modelMapper.map(picturesSeedDto, Picture.class);
                        picture.setCar(carService.findById(picturesSeedDto.getCar()));
                        return picture;
                 }).forEach(pictureRepository::save);





return sb.toString();
    }
}
