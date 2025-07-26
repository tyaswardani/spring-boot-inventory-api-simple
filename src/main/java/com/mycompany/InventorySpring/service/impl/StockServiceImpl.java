/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.InventorySpring.service.impl;

import com.mycompany.InventorySpring.dto.StockRequestDTO;
import com.mycompany.InventorySpring.dto.StockResponseDTO;
import com.mycompany.InventorySpring.dto.StockListResponseDTO;
import com.mycompany.InventorySpring.entity.Stock;
import com.mycompany.InventorySpring.mapper.StockMapper;
import com.mycompany.InventorySpring.repository.StockRepository;
import com.mycompany.InventorySpring.service.StockService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author HP
 */
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Override
    public StockResponseDTO createStock(StockRequestDTO requestDTO) {
        Stock stock = StockMapper.toEntity(requestDTO);
        Stock saved = stockRepository.save(stock);
        return StockMapper.toResponseDTO(saved);
    }

    @Override
    public List<StockResponseDTO> getAllStocks() {
        List<Stock> stockList = stockRepository.findAll();
        return stockList.stream()
            .map(StockMapper::toResponseDTO)
            .toList();
    }


    @Override
    public void deleteStock(Long id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found with id " + id));
        stockRepository.delete(stock);
    }
    
    @Override
    public StockResponseDTO updateStock(Long id, StockRequestDTO requestDTO) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found with id " + id));

        stock.setNm_barang(requestDTO.getNm_barang());
        stock.setJml_stok(requestDTO.getJml_stok());
        stock.setNo_seri(requestDTO.getNo_seri());
        stock.setAdditionalInfo(requestDTO.getAdditionalInfo());

        // Update gambar jika ada
        if (requestDTO.getImage() != null && requestDTO.getImage().length > 0) {
            stock.setImage(requestDTO.getImage());
        }

        Stock updated = stockRepository.save(stock);
        return StockMapper.toResponseDTO(updated);
    }

    @Override
    public StockResponseDTO getStockById(Long id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found with id " + id));
        return StockMapper.toResponseDTO(stock);
    }
}