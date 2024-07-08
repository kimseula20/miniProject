package com.github.supercodingspringproject.service.mapper;

import com.github.supercodingspringproject.repository.inventory.KoreaInventory;
import com.github.supercodingspringproject.web.dto.SneakerInventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventoryMapper {

    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    SneakerInventory koreaInventoryToSneakerInventory(KoreaInventory koreaInventory);
}
