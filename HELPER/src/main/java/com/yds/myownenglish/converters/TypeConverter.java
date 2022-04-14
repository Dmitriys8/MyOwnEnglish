package com.yds.myownenglish.converters;

import com.yds.myownenglish.entities.TypeEntity;
import com.yds.myownenglish.models.TenseTypeModel;

import java.util.List;

public class TypeConverter {

    public static TenseTypeModel convertFromEntity(final TypeEntity typeEntity){
        return TenseTypeModel.builder()
                .typeName(typeEntity.getTypeName())
                .typeId(typeEntity.getTypeId())
                .build();
    }

    public static List<TenseTypeModel> convertFromEntity(final List<TypeEntity> typeEntity){
        return typeEntity.stream()
                .map(TypeConverter::convertFromEntity)
                .toList();
    }
}
