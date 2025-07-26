/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.InventorySpring.mapper;

import com.mycompany.InventorySpring.dto.*;
import com.mycompany.InventorySpring.entity.Stock;

public class StockMapper {

    // Convert Request DTO -> Entity
    public static Stock toEntity(StockRequestDTO dto) {
        if (dto == null) return null;

        Stock stock = new Stock();
        stock.setNm_barang(dto.getNm_barang());
        stock.setJml_stok(dto.getJml_stok());
        stock.setNo_seri(dto.getNo_seri());
        stock.setImage(dto.getImage()); // ganti dari setImagePath
        stock.setAdditionalInfo(dto.getAdditionalInfo());
        return stock;
    }

    // Convert Entity -> Full Response DTO
    public static StockResponseDTO toResponseDTO(Stock stock) {
        if (stock == null) return null;

        return StockResponseDTO.builder()
                .id(stock.getId())
                .nm_barang(stock.getNm_barang())
                .jml_stok(stock.getJml_stok())
                .no_seri(stock.getNo_seri())
                .image(stock.getImage()) // ganti dari getImagePath
                .additionalInfo(stock.getAdditionalInfo())
                .createdBy(stock.getCreatedBy())
                .updatedBy(stock.getUpdatedBy())
                .createdAt(stock.getCreatedAt())
                .updatedAt(stock.getUpdatedAt())
                .build();
    }

    // Convert Entity -> List DTO
    public static StockListResponseDTO toListDTO(Stock stock) {
        if (stock == null) return null;

        return StockListResponseDTO.builder()
                .id(stock.getId())
                .nm_barang(stock.getNm_barang())
                .jml_stok(stock.getJml_stok())
                .no_seri(stock.getNo_seri())
                .build();
    }
}
