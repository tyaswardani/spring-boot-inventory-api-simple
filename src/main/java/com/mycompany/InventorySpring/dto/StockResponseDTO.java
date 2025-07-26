/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.InventorySpring.dto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;
/**
 *
 * @author HP
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class StockResponseDTO {
    private Long id;
    private String nm_barang;
    private Integer jml_stok;
    private String no_seri;
    private byte[] image;
    private Map<String, Object> additionalInfo;

    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}