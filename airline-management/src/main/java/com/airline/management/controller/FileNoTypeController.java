package com.airline.management.controller;

import com.airline.management.dto.FileNoTypeDTO;
import com.airline.management.service.FileNoTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/file-no-types")
@AllArgsConstructor
public class FileNoTypeController {
    private final FileNoTypeService fileNoTypeService;

    @PostMapping
    public ResponseEntity<FileNoTypeDTO> createFileNoType(@RequestBody FileNoTypeDTO fileNoTypeDTO) {
        return ResponseEntity.ok(fileNoTypeService.createFileNoType(fileNoTypeDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileNoTypeDTO> getFileNoTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(fileNoTypeService.getFileNoTypeById(id));
    }

    @GetMapping
    public ResponseEntity<List<FileNoTypeDTO>> getAllFileNoTypes() {
        return ResponseEntity.ok(fileNoTypeService.getAllFileNoTypes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FileNoTypeDTO> updateFileNoType(
            @PathVariable Long id,
            @RequestBody FileNoTypeDTO fileNoTypeDTO) {
        return ResponseEntity.ok(fileNoTypeService.updateFileNoType(id, fileNoTypeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFileNoType(@PathVariable Long id) {
        fileNoTypeService.deleteFileNoType(id);
        return ResponseEntity.noContent().build();
    }
}
