package com.airline.management.service;

import com.airline.management.dto.FileNoTypeDTO;
import com.airline.management.entity.FileNoType;
import com.airline.management.exception.ResourceNotFoundException;
import com.airline.management.repository.FileNoTypeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FileNoTypeService {
    FileNoTypeRepository fileNoTypeRepository;
    private final ModelMapper modelMapper;

    public FileNoTypeDTO createFileNoType(FileNoTypeDTO fileNoTypeDTO) {
        FileNoType fileNoType = modelMapper.map(fileNoTypeDTO, FileNoType.class);
        fileNoType = fileNoTypeRepository.save(fileNoType);
        return modelMapper.map(fileNoType, FileNoTypeDTO.class);
    }

    public FileNoTypeDTO getFileNoTypeById(Long id) {
        FileNoType fileNoType = fileNoTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FileNoType not found with ID: " + id));
        return modelMapper.map(fileNoType, FileNoTypeDTO.class);
    }

    public List<FileNoTypeDTO> getAllFileNoTypes() {
        return fileNoTypeRepository.findAll().stream()
                .map(fileNoType -> modelMapper.map(fileNoType, FileNoTypeDTO.class))
                .collect(Collectors.toList());
    }

    public FileNoTypeDTO updateFileNoType(Long id, FileNoTypeDTO fileNoTypeDTO) {
        FileNoType fileNoType = fileNoTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FileNoType not found with ID: " + id));

        fileNoType.setCode(fileNoTypeDTO.getCode());
        fileNoType.setName(fileNoTypeDTO.getName());

        fileNoType = fileNoTypeRepository.save(fileNoType);
        return modelMapper.map(fileNoType, FileNoTypeDTO.class);
    }

    public void deleteFileNoType(Long id) {
        if (!fileNoTypeRepository.existsById(id)) {
            throw new ResourceNotFoundException("FileNoType not found with ID: " + id);
        }
        fileNoTypeRepository.deleteById(id);
    }
}
