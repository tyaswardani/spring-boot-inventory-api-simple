/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mycompany.InventorySpring.service;

import com.mycompany.InventorySpring.dto.*;
import java.util.List;
/**
 *
 * @author HP
 */
public interface StockService {
    
    StockResponseDTO createStock(StockRequestDTO requestDTO);

    List<StockResponseDTO> getAllStocks();

    StockResponseDTO getStockById(Long id);

    StockResponseDTO updateStock(Long id, StockRequestDTO requestDTO);

    void deleteStock(Long id);
}

