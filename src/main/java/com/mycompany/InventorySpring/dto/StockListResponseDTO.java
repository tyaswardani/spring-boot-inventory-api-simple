/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.InventorySpring.dto;
import lombok.*;
import jakarta.persistence.*;
/**
 *
 * @author HP
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class StockListResponseDTO {
    private Long id;
    private String nm_barang;
    private Integer jml_stok;
    private String no_seri;
}
