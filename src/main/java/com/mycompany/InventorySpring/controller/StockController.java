/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.InventorySpring.controller;

import com.mycompany.InventorySpring.dto.StockRequestDTO;
import com.mycompany.InventorySpring.dto.StockResponseDTO;
import com.mycompany.InventorySpring.service.StockService;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;
    private static final Logger logger = LoggerFactory.getLogger(StockController.class);

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<StockResponseDTO> createStock(
            @RequestPart("data") String jsonData,
            @RequestPart("image") MultipartFile imageFile
    ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StockRequestDTO requestDTO = mapper.readValue(jsonData, StockRequestDTO.class);

        requestDTO.setImage(imageFile.getBytes());

        StockResponseDTO response = stockService.createStock(requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<StockResponseDTO>> getAllStocks() {
        List<StockResponseDTO> stocks = stockService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockResponseDTO> getStockById(@PathVariable Long id) {
        StockResponseDTO stock = stockService.getStockById(id);
        return ResponseEntity.ok(stock);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<StockResponseDTO> updateStock(
        @PathVariable Long id,
        @RequestPart("data") @Valid StockRequestDTO requestDTO,
        @RequestPart(value = "image", required = false) MultipartFile imageFile
    ) throws IOException {
        if (imageFile != null && !imageFile.isEmpty()) {
            requestDTO.setImage(imageFile.getBytes());
        }

        StockResponseDTO response = stockService.updateStock(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return ResponseEntity.noContent().build();
    }

    // OPTIONAL: Endpoint untuk menampilkan gambar
    @GetMapping(value = "/{id}/image", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        StockResponseDTO stock = stockService.getStockById(id);
        return ResponseEntity.ok(stock.getImage());
    }

}